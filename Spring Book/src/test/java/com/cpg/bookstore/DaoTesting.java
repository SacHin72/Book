package com.cpg.bookstore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpg.bookstore.dao.BookInformationDaoImpl;
import com.cpg.bookstore.entities.BookInformation;
@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTesting {
	
	@MockBean
	BookInformationDaoImpl bookInfoDao;
	
	
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
		Mockito.when(bookInfoDao.updateBookInfo(bookInfo)).thenReturn(true);
	}
	@Test
	public void daoBookTesting()throws Exception {
		Mockito.when(bookInfoDao.updateBookInfo(null)).thenReturn(false);
	}
}
