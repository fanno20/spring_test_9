package com.hsh.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model){/*ModelAndView*/
		e.printStackTrace();
		/*ModelAndView md = new ModelAndView();
		md.addObject("error", "error");
		md.setViewName("error/error500");
		return md;*/
		model.addAttribute("error", "error22");
		return "error/error500";
	}
	
}
