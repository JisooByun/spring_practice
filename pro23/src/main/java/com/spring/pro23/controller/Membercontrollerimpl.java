package com.spring.pro23.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.pro23.controller.Membercontroller;
import com.spring.pro23.service.Memberservice;

public class Membercontrollerimpl extends MultiActionController implements Membercontroller{
	private Memberservice memberservice;
	public void setMemberservice(Memberservice memberservice) {
		this.memberservice = memberservice;
	}
	
	
	

}
