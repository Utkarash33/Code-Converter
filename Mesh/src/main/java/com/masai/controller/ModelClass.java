package com.masai.controller;

public class ModelClass {
 
	
	private String prompt;

	public ModelClass() {
		super();
	}

	public ModelClass(String prompt) {
		super();
		this.prompt = prompt;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	


	public String checkPrompt() {
		
		return "Assess the Code Quality\n\n"
	            + "**Description:**\n"
	            + "You are a Senior software developer Quality checker expert for developers. "
	            + " Users will evaluation the code one the basic of certain parameters. "
	            + " Criteria for evaluating code quality.\n\n"
	            + "**Parameters:**\n"
	            + "1. **Readability (10/10):**\n"
	            + "   - Check the code for readability.\n"
	            + "   - Evaluate variable names, comments, and indentation.\n"
	            + "   - Assign a score from 1 (poor) to 10 (excellent) based on how easy the code is to read.\n\n"
	            + "2. **Documentation (9/10):**\n"
	            + "   - Assess the code for documentation quality.\n"
	            + "   - Evaluate the clarity and comprehensiveness of code comments and documentation.\n"
	            + "   - Assign a score from 1 (poor) to 10 (excellent) based on the quality of documentation.\n\n"
	            + "3. **Performance (8/10):**\n"
	            + "   - Analyze the code's performance.\n"
	            + "   - Consider factors like algorithm efficiency, resource utilization, and optimization.\n"
	            + "   - Assign a score from 1 (poor) to 10 (excellent) based on performance.\n\n"
	            + "4. **Error Handling (9/10):**\n"
	            + "   - Evaluate the code for proper error handling and fault tolerance.\n"
	            + "   - Check for adequate error messages, exception handling, and graceful degradation.\n"
	            + "   - Assign a score from 1 (poor) to 10 (excellent) based on error handling practices.\n\n"
	            + "5. **Maintainability (8/10):**\n"
	            + "   - Assess the code's maintainability.\n"
	            + "   - Consider modularity, design patterns, and code structure.\n"
	            + "   - Assign a score from 1 (poor) to 10 (excellent) based on maintainability.\n\n"
	            + "Code to evaluate:- "
	            + prompt;	}

	public String convertPrompt(String language) {
		
		
		return "Work as a codeConverter , You have to knowledge of all the coding languages,\r\n"
				+ "you can easily convert any code from one programing language to another without compiling or trying to debugging"
				+ " the code."
				+ "Instructions:- COde the code with debugging or compiling to the given language"
				+ "Example:-"
		        +"Code:-"
		        + "static int main(String str)\r\n"
		        + "{\r\n"
		        + "int count =0;\r\n"
		        + "for(int i=0;i<str.length()';i++)\r\n"
		        + "{\r\n"
		        + "  if(str.chatAt(i)=='a')\r\n"
		        + "{\r\n"
		        + "count++;\r\n"
		        + "}\r\n"
		        + "}\r\n"
		        + "return count;\r\n"
		        + "}"
		        + "Langage to convert:- JavaScript"
		        + "output:-"
		        + "function main(str) {\r\n"
		        + "    let count = 0;\r\n"
		        + "\r\n"
		        + "    for (let i = 0; i < str.length; i++) {\r\n"
		        + "        if (str.charAt(i) === 'a') {\r\n"
		        + "            count++;\r\n"
		        + "        }\r\n"
		        + "    }\r\n"
		        + "    return count;\r\n"
		        + "}"
		        + "Code:-"
		        + "while(true)"
		        + "{"
		        + "i++"
		        + "}"
		        + "Language:- Python"
		        + "Output "
		        + "while True:\r\n"
		        + "    i += 1"
		        + "Task:-"
		        + "Code:- "
		        + " "+prompt+" \r\n"
		        		+ "Language to Convert:- "+language;
		        
	}

	public String debugPrompt() {
		
		return " Take the role of a senior Developer expert in debuging the code"
				+ "You are expert in debugging any code and providing the right code."
				+ "Your task is to debug the code and give the right code with the few point "
				+ "in which the mistakes and the right code written"
				+ "also check for the stackoutflow error or anything other error due to with "
				+ "the code might end up in a race codition or infinite loop and also give the solution for that also."
				+ "code to debug:-"
				+ prompt;
	
	}

	
	
}
