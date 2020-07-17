package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;

@Repository
public class BookStoreDaoImpl implements BookStoreDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean createCategory(BookCategory category){
		em.persist(category);
		return true;
	}
	
	public boolean findCategory(String categoryName) {
		String jpql = "from BookCategory b where b.categoryName=:cName";
		TypedQuery<BookCategory> query = em.createQuery(jpql, BookCategory.class);
		query.setParameter("cName",categoryName);
	    List<BookCategory> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		BookInformation book = em.find(BookInformation.class, bookId);
		if(book!=null) {
			em.remove(book);
			return true;
		}
		return false;
	}
	

	@Override
	public boolean addBook(BookInformation bookInfo) {
		em.persist(bookInfo);
		return true;
	}

	@Override
	public boolean updateBook(BookInformation book) {
		// TODO Auto-generated method stub
		em.merge(book);
		return true;
	}

	@Override
	public boolean findBook(String bookName) {
		// TODO Auto-generated method stub
		String jpql = "from BookInformation b where b.title=:cName";
		TypedQuery<BookInformation> query = em.createQuery(jpql, BookInformation.class);
		query.setParameter("cName",bookName);
	    List<BookInformation> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}
}
