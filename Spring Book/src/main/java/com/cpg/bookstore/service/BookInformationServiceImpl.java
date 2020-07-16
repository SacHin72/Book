package com.cpg.bookstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpg.bookstore.dao.BookInformationDaoImpl;
import com.cpg.bookstore.entities.BookInformation;

@Transactional
@Service
public class BookInformationServiceImpl implements BookInformationService{
	
	@Autowired
	private BookInformationDaoImpl bookInfoDao;
	
	public boolean updateBookInfo(BookInformation bookInfo) {
		// TODO Auto-generated method stub
		if(bookInfoDao.updateBookInfo(bookInfo)) {
			return true;
		}
		else {
			return false;
		}
	}

}
