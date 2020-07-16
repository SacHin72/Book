package com.cpg.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cpg.bookstore.entities.BookInformation;
import com.cpg.bookstore.service.BookInformationServiceImpl;


@SpringBootApplication
@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	private BookInformationServiceImpl bookService;
	
	@PutMapping("/UpdateBookInfo")
	public String updateBookInfo(@RequestBody BookInformation bookInfo ) {
		try {
			bookService.updateBookInfo(bookInfo);
		}
		catch(Exception e){
			return "ERROR!!!";
		}
		return "Details Updated";
	}
}