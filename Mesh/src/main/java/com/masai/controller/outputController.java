package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.controller.ModelClass;
import com.masai.service.UserService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

@RestController
public class outputController {

	

	  @Value("${openai.api.chat.default.role}")
	  private String defaultRole;
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/convert/{language}")
	public ResponseEntity<String> covertCode( @PathVariable String language, @RequestBody ModelClass model)
	{
		System.out.println(language+" "+model.getPrompt());
		
		String prompt = model.convertPrompt(language);
		
		final OpenAiService aiService = userService.getOpenAiService();
		
		final ChatCompletionRequest chatRequest = userService.getChatCompletionRequest(List.of(new ChatMessage(defaultRole, prompt)));
		
		 String output =  aiService.createChatCompletion(chatRequest).getChoices().get(0).getMessage().getContent();
		
		
		return new ResponseEntity<>(output,HttpStatus.OK);

	}
	

	@PostMapping("/debug")
	public ResponseEntity<String> debugCode(@RequestBody ModelClass model)
	{
		System.out.println(model.getPrompt());
          String prompt = model.debugPrompt();
		
		final OpenAiService aiService = userService.getOpenAiService();
		
		final ChatCompletionRequest chatRequest = userService.getChatCompletionRequest(List.of(new ChatMessage(defaultRole, prompt)));
		
		 String output =  aiService.createChatCompletion(chatRequest).getChoices().get(0).getMessage().getContent();
		
		
		return new ResponseEntity<>(output,HttpStatus.OK);

	}

	@PostMapping("/check")
	public ResponseEntity<String> qualityCheck(@RequestBody ModelClass model)
	{
		System.out.println(model.getPrompt());
          String prompt = model.checkPrompt();
		
		final OpenAiService aiService = userService.getOpenAiService();
		
		final ChatCompletionRequest chatRequest = userService.getChatCompletionRequest(List.of(new ChatMessage(defaultRole, prompt)));
		
		 String output =  aiService.createChatCompletion(chatRequest).getChoices().get(0).getMessage().getContent();
		
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	
	@PostMapping("/test")
	public ResponseEntity<String> test(@RequestBody ModelClass model)
	{
		return new ResponseEntity<>("heeelo",HttpStatus.OK);
	}
	
	
}
