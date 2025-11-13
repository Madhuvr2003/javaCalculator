package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class contoller {
	
	
	
            @GetMapping("/")
			public String home() {
				return "index";
			}
			
            
        @Autowired   
        service se;    
            
       @PostMapping("/calculate")
       String calculate(@RequestParam("num1") int num1, @RequestParam("num2") int num2,@RequestParam("operation") String op, Model m) {
    	   int result =0;
    	  String message ="";
    	  switch(op){
    	  case "add" ->  result = se.add(num1, num2);
    	  case "sub" ->  result = se.sub(num1, num2);
    	  case "mul" ->  result = se.mul(num1, num2);
    	  case "div" -> {
              if (num2 == 0) {
                  message = "Cannot divide by zero!";
              } else {
                  result = se.div(num1, num2);
              }
          }
    	  
    	  
    	 
    	  }
    	  
    	  m.addAttribute("num1", num1);
    	  m.addAttribute("num2", num2);
    	  m.addAttribute("op", op);
    	  m.addAttribute("res", result);
    	  m.addAttribute("mes",message);
    	  
    	   
    	   
    	   return "result";
       }
	
}
