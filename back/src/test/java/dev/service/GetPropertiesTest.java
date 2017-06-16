package dev.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("application.properties")
public class GetPropertiesTest {
	
	@Autowired private Environment env;
	
	@Test
	public void test() {
		assertThat(env.getProperty("mailSender.host"),equalTo("smtp.gmail.com"));
		
		Properties prop = new Properties();
    	prop.setProperty("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
    	assertThat(prop.getProperty("mail.transport.protocol"),equalTo("smtp") );
	}

}
