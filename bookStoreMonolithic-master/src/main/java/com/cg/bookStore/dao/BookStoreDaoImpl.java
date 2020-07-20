package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;

@Repository
public class BookStoreDaoImpl implements BookStoreDao {

	@PersistenceContext
	private EntityManager entitiManager;

	@Override
	public boolean createCategory(BookCategory category){
		entitiManager.persist(category);
		return true;
	}
	
	public boolean categoryExists(String categoryName) {
		String jpql = "from BookCategory b where b.categoryName=:cName";
		TypedQuery<BookCategory> query = entitiManager.createQuery(jpql, BookCategory.class);
		query.setParameter("cName",categoryName);
	    List<BookCategory> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}
	
	public boolean categoryExists(int categoryId) {
		String jpql = "from BookCategory b where b.categoryId=:cId";
		TypedQuery<BookCategory> query = entitiManager.createQuery(jpql, BookCategory.class);
		query.setParameter("cId",categoryId);
	    List<BookCategory> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}
	
	public boolean bookExists(int bookId) {
		String jpql = "from BookInformation b where b.bookId=:bId";
		TypedQuery<BookInformation> query = entitiManager.createQuery(jpql, BookInformation.class);
		query.setParameter("bId",bookId);
	    List<BookInformation> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		BookInformation book = entitiManager.find(BookInformation.class,bookId);
		entitiManager.remove(book);
		return true;
	}
	

	@Override
	public boolean addBook(BookInformation bookInfo) {
		entitiManager.persist(bookInfo);
		return true;
	}
	
	public List<BookInformation> listAllBooks() {
		String Qstr="SELECT bookInformation FROM BookInformation bookInformation";
		TypedQuery<BookInformation> query=entitiManager.createQuery(Qstr,BookInformation.class);
		List<BookInformation> listAllBooks=query.getResultList();
		return listAllBooks;
	}

	/*******************************************
	 * Method: UpdateBook
	 *Description: To update book details like book title,Author name, publish Date, price etc.
	 * @param name              - input of Object of type BookInformation
	 * @returns       - 		true if information updated
	 * @throws Booking exception - if number of tickets is less than required tickets 
	            *Created By                              - Sachin kumar
	            *Created Date                            - 16-July-2020                           	 
	 ********************************************/
	@Override
	public boolean updateBookInfo(BookInformation book) {
		// TODO Auto-generated method stub
		String str="update BookInformation bookInfo set bookInfo.title=:title,bookInfo.author=:author,"
				+ "bookInfo.description=:description,bookInfo.isbnNumber=:isbnNumber,bookInfo.publishDate=:publishDate,"
				+ "bookInfo.lastUpdateTime=:lastUpdateTime,bookInfo.price=:price where bookInfo.bookId=:id";
		Query query=entitiManager.createQuery(str);
		query.setParameter("title", book.getTitle());
		query.setParameter("author", book.getAuthor());
		query.setParameter("description", book.getDescription());
		query.setParameter("isbnNumber", book.getIsbnNumber());
		query.setParameter("publishDate", null);
		query.setParameter("lastUpdateTime",null);
		query.setParameter("price", book.getPrice());
		query.setParameter("id", book.getBookId());
		query.executeUpdate();
		return true;	
	}

	@Override
	public boolean updateCategory(BookCategory category) {
		String str="SELECT category FROM BookCategory category WHERE category.categoryName=:newCategoryName";
		TypedQuery<BookCategory> query=entitiManager.createQuery(str,BookCategory.class);
		query.setParameter("newCategoryName", category.getCategoryName());
		try {
			query.getSingleResult();
		}catch(NoResultException e) {
			String str2="update BookCategory category set category.categoryName=:newCategoryName where category.categoryId=:id";
			Query query2=entitiManager.createQuery(str2);
			query2.setParameter("newCategoryName", category.getCategoryName());
			query2.setParameter("id", category.getCategoryId());
			query2.executeUpdate();
			return true;
		}
		return false;
	}
	
	public boolean deleteCategory(int categoryId) {
			BookCategory category = entitiManager.find(BookCategory.class,categoryId);
			entitiManager.remove(category);
			return true;
	}
	
	public boolean bookExists(String bookName) {
		String jpql = "from BookInformation b where b.title=:cName";
		TypedQuery<BookInformation> query = entitiManager.createQuery(jpql, BookInformation.class);
		query.setParameter("cName",bookName);
	    List<BookInformation> existingCat = query.getResultList();
	    if(existingCat.isEmpty()) {
	    	return false;
	    }
	    return true;
	}

}
