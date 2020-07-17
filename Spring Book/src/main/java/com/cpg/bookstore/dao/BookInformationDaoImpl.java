package com.cpg.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.cpg.bookstore.entities.BookInformation;

@Repository
public class BookInformationDaoImpl implements BookInformationDao{
	@PersistenceContext
	private EntityManager entityManager;
	public boolean updateBookInfo(BookInformation bookInfo) {
		BookInformation bookInformation=entityManager.find(BookInformation.class, bookInfo.getBookId());
		entityManager.remove(bookInformation);
		entityManager.persist(bookInfo);
		return true;
	}
//	bookInformation.setAuthor(bookInfo.getAuthor());
//	bookInformation.setDescription(bookInfo.getDescription());
//	bookInformation.setIsbnNumber(bookInfo.getIsbnNumber());
//	bookInformation.setLastUpdateTime(bookInfo.getLastUpdateTime());
//	bookInformation.setTitle(bookInfo.getTitle());
//	entityManager.persist(bookInformation);
}
