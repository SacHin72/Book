package com.cpg.bookstore.service;

import com.cpg.bookstore.entities.BookInformation;
import com.cpg.bookstore.exception.BookException;

public interface BookInformationService{
	String updateBookInfo(BookInformation bookInfo) throws BookException;
}
