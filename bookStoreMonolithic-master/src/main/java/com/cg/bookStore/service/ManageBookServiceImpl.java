package com.cg.bookStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;

@Service
@Transactional
public class ManageBookServiceImpl implements ManageBookService {

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public String deleteBook(int bookId) throws BookException {
		if(dao.deleteBook(bookId)) {
			return "Book deleted";
		}
		
		throw new BookException("Book not found");
	}
	
	public String createBook(BookInformation book) throws BookException{
		return "";
	}
	
	/*******************************************
	 * Method: UpdateBook
	 *Description: To update book details like book title,Author name, publish Date, price etc.
	 * @param name              - input of Object of type BookInformation
	 * @returns       - 		Book Updated Successfully if information updated
	 * @throws Book exception - "Book with same name already Exist!!!" if book with same name already exist
	 * @throws Book exception - "ERROR!!!... Book Not Updated!" if book is not updated.
	            *Created By                              - Sachin kumar
	            *Created Date                            - 16-July-2020                           	 
	 ********************************************/
	@Override
	public String updateBook(BookInformation book) throws BookException {
		// TODO Auto-generated method stub
		if(dao.findBook(book.getTitle())) {
			throw new BookException("Book with same name already Exist!!!");
		}
		else if(dao.updateBook(book)) {
				return "Book Updated Successfully";
		}
		throw new BookException("ERROR!!!... Book Not Updated!");
	}

	public String displayBook(int bookId) throws BookException{
		return "";
	}
	
	@Override
	public List<BookInformation> listAllBookss() throws BookException{
		List<BookInformation>  allBooks= dao.listAllBooks();
		if(allBooks.isEmpty()) {
			throw new BookException("Ooops!!!There is no book");
		}
		
		return allBooks;
	}

}
