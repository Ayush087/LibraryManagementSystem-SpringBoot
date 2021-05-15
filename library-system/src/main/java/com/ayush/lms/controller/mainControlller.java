package com.ayush.lms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayush.lms.model.book;
import com.ayush.lms.services.lmsService;

@Controller
public class mainControlller {

	@Autowired
	private lmsService service;

	@GetMapping("/")
	public String init(HttpServletRequest request) {

		request.setAttribute("bookObj", service.findAllBooks());
		request.setAttribute("mode", "BOOK_VIEW");
		return "index.jsp";
	}

	@GetMapping("/updateBook")
	public String init(@RequestParam long id, HttpServletRequest request) {

		request.setAttribute("bookObjU", service.findOneBook(id));
		request.setAttribute("mode", "BOOK_EDIT");
		return "index.jsp";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam long id, HttpServletRequest request) {
		service.delete(id);
		request.setAttribute("bookObj", service.findAllBooks());
		request.setAttribute("mode", "BOOK_VIEW");
		return "index.jsp";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}

	@PostMapping("/save")
	public void save(@ModelAttribute book b, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		service.save(b);
		request.setAttribute("bookObjU", service.findAllBooks());
		request.setAttribute("mode", "BOOK_VIEW");
		response.sendRedirect("/");
	}

	@GetMapping("/newBook")
	public String newBook(HttpServletRequest request) {
		request.setAttribute("mode", "BOOK_NEW");

		return "index.jsp";
	}
}
