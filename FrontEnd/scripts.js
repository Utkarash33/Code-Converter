let editor;
require.config({ paths: { 'vs': 'https://cdnjs.cloudflare.com/ajax/libs/monaco-editor/0.27.0/min/vs' } });
        require(['vs/editor/editor.main'], function() {
            var languageSelect = document.getElementById("language-select");
             editor = monaco.editor.create(document.getElementById('source-code'), {
                value: `function helloWorld() {
    console.log("Hello, World!");
}`,
                language: "python", 
                theme:"vs-dark"
            });

            // Handle language change
            languageSelect.addEventListener("change", function () {
                var selectedLanguage = this.value;
                monaco.editor.setModelLanguage(editor.getModel(), selectedLanguage);
            });
        });
        

document.addEventListener("DOMContentLoaded", function() {
    
    const convertButton = document.getElementById("convert-button");
    const checkButton = document.getElementById("check-button");
    const debugButton = document.getElementById("debug-button");
    const languageSelect = document.getElementById("language-select");
    const outputDiv = document.getElementById("output");
    const loader = document.getElementById("loader");

    convertButton.addEventListener("click", function() {
        const selectedLanguage = languageSelect.value;
        const sourceCode = editor.getValue();
        if(sourceCode.length>=300)
        {
             alert(`Code is to lengthy please enter the code containing length  less then 300 words`);
             return;
        }
        loader.style.display = "block";
        outputDiv.innerText = "Please wait your code is converting ...."

        const requestOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ prompt: sourceCode })
        };

        fetch(`https://code-converter-production.up.railway.app/convert/${selectedLanguage}`, requestOptions)
            .then(response => response.text())
            .then(data => {
                outputDiv.innerText = "";
                outputDiv.innerText = data;
                loader.style.display = "none";
            })
            .catch(error => {
                outputDiv.innerText = "";
                outputDiv.innerText = "Error: " + error;
                loader.style.display = "none";
            });
    });

    checkButton.addEventListener("click", function() {
        const sourceCode = editor.getValue();

        if(sourceCode.length>=300)
        {
             alert(`Code is to lengthy please enter the code containing length  less then 300 words`);
             return;
        }
        loader.style.display = "block";
        outputDiv.innerText = "Please wait your code is under evaluation...";
        const requestOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ prompt: sourceCode })
        };

        fetch("https://code-converter-production.up.railway.app/check", requestOptions)
            .then(response => response.text())
            .then(data => {
                outputDiv.innerText = "";
                outputDiv.innerText = data;
                loader.style.display = "none";
            })
            .catch (error => {
                outputDiv.innerText = "";
                outputDiv.innerText = "Error: " + error;
                loader.style.display = "none";
            });
    });

    debugButton.addEventListener("click", function() {
        const sourceCode = editor.getValue();
        if(sourceCode.length>=300)
        {
             alert(`Code is to lengthy please enter the code containing length  less then 300 words`);
             return;
        }

        outputDiv.innerText = "Please wait your code is under elvauation..."; 
        loader.style.display = "block";
        const requestOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ prompt: sourceCode })
        };

        fetch("https://code-converter-production.up.railway.app/debug", requestOptions)
            .then(response => response.text())
            .then(data => {
                outputDiv.innerText = "";
                outputDiv.innerText = data;
                loader.style.display = "none";
            })
            .catch(error => {
                outputDiv.innerText = "";
                outputDiv.innerText = "Error: " + error;
                loader.style.display = "none";
            });
    });
});
