package com.ayush.lms.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello Ayush";
	}
}
