package com.hsh.intercept;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Object dto = modelAndView.getModel().get("member");
		if(dto != null){
			request.getSession().setAttribute("member", dto);
			response.sendRedirect(request.getContextPath()+"/");
			/*modelAndView.setViewName("home");*/
		}else{
			response.sendRedirect(request.getContextPath()+"/member/loginForm");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		return super.preHandle(request, response, handler);
	}
	
}
