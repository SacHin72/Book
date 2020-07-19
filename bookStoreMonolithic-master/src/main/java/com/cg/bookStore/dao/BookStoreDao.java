package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;

public interface BookStoreDao {

	public boolean createCategory(BookCategory category);
	public boolean findCategory(String categoryName);
	public boolean findBook(String name);
	public boolean deleteBook(int bookId);
	public boolean addBook(BookInformation bookInfo);
	public boolean updateBook(BookInformation book);
	public List<BookInformation> listAllBooks();
}
