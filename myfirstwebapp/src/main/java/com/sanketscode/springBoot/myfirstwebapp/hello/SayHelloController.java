package com.sanketscode.springBoot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {
	
	//"say-hello" => "Hello What are you Learning Today?"
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello What are you Learning Today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("First HTML Response");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}

}
