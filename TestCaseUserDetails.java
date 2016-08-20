package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.UserDetailsDAO;

import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {
AnnotationConfigApplicationContext context;
@Autowired
UserDetailsDAO  userDetailsDAO;
@Autowired
UserDetails userDetails;
	@Before
	public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.niit.shoppingcart");
			context.refresh();
		userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails= (UserDetails) context.getBean("userDetails");
	}
	@Test
	public void addUserDetailsTest(){
		userDetails.setId("US_001");
		userDetails.setName("Manogna");
		userDetails.setEmail("manogna123@gmail.com");
		userDetails.setPassword("manu123");
		userDetails.setContact("9177569932");
		userDetails.setAddress("vidyanagar hyd");
		assertEquals("addUserDetailsTest",userDetailsDAO.save(userDetails),true);
	}
@Test
public void deleteuser(){
	userDetails.setId("US_002");
	assertEquals("deleteuser",userDetailsDAO.delete(userDetails),true);
}
@Test
public void updateUser(){
	userDetails.setId("US_001");
	userDetails.setName("Manogna");
	userDetails.setEmail("manogna123@gmail.com");
	userDetails.setPassword("manu1234");
	userDetails.setContact("7623985");
	userDetails.setAddress("vidyanagar,hyd");
	assertEquals("updateUser",userDetailsDAO.update(userDetails),true);
} 
@Test
public void getUser(){
	userDetails=userDetailsDAO.get("US_001");
	assertEquals("updateUser",userDetails.getName(),"Manogna");

}
@Test
public void listUser(){
	assertEquals("listUser",userDetailsDAO.list().size(),1);

}
} 
