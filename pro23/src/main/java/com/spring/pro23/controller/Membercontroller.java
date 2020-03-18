package com.spring.pro23.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface Membercontroller {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
