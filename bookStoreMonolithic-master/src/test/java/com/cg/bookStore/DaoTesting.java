package com.cg.bookStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookStore.dao.BookStoreDaoImpl;
import com.cg.bookStore.entities.BookInformation;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTesting {
	
	@MockBean
	BookStoreDaoImpl bookDao;
	
	
	@Test
	public void daoTesting()throws Exception {
		BookInformation bookInfo=new BookInformation();
		bookInfo.setBookId(1);
		bookInfo.setAuthor("Sachin");
		bookInfo.setDescription("Science");
		bookInfo.setIsbnNumber("123");
		bookInfo.setLastUpdateTime(null);
		bookInfo.setPublishDate(null);
		bookInfo.setTitle("Science");
		Mockito.when(bookDao.updateBook(bookInfo)).thenReturn(true);
	}
	@Test
	public void daoBookTesting()throws Exception {
		Mockito.when(bookDao.updateBook(null)).thenReturn(false);
	}
}

