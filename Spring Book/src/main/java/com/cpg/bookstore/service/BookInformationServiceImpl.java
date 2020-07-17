package com.cpg.bookstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpg.bookstore.dao.BookInformationDaoImpl;
import com.cpg.bookstore.entities.BookInformation;
import com.cpg.bookstore.exception.BookException;

@Transactional
@Service
public class BookInformationServiceImpl implements BookInformationService{
	
	@Autowired
	private BookInformationDaoImpl bookInfoDao;
	
	public String updateBookInfo(BookInformation bookInfo) throws BookException{
		// TODO Auto-generated method stub
		if(bookInfoDao.updateBookInfo(bookInfo)) {
			return "Book Updated Successfully";
		}
		throw new BookException("ERROR!!!... Book Not Updated!");
	}
}
