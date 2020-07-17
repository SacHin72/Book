package com.cpg.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cpg.bookstore.entities.BookInformation;
import com.cpg.bookstore.exception.BookException;
import com.cpg.bookstore.service.BookInformationServiceImpl;


@SpringBootApplication
@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	private BookInformationServiceImpl bookService;
	
	@PostMapping("/UpdateBookInfo")
	public String updateBookInfo(@RequestBody BookInformation bookInfo ) throws BookException{
		return bookService.updateBookInfo(bookInfo);
	}
	
}