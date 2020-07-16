package com.cpg.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpg.bookstore.dao.BookInformationDaoImpl;
import com.cpg.bookstore.entities.BookInformation;
import com.cpg.bookstore.service.BookInformationServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTesting {
	@Autowired
	BookInformationServiceImpl bookInfoServiceTest;
	
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
		assertThat(bookInfoServiceTest.updateBookInfo(bookInfo)).isEqualTo(true);
	}
	@Test
	public void daoBookTesting()throws Exception {
		assertThat(bookInfoServiceTest.updateBookInfo(null)).isEqualTo(false);
	}
}
