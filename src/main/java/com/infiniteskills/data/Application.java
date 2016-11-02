package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.close();
		
		session.getTransaction().begin();
		User user = new User();
		user.setBirthDate(new Date());//(null); 
		user.setCreatedDate(new Date());
		user.setCreatedBy("kevin");
		user.setEmailAddress("kmb385@yahoo.com");
		user.setFirstName("kevin");
		user.setLastName("Bowersox");
		user.setLastUpdatedBy("kevin");
		user.setLastUpdatedDate(new Date());
		session.save(user);
		session.getTransaction().commit();
		
//		session.beginTransaction();
//		User dbUser =(User) session.get(User.class, user.getUserId());
//		dbUser.setFirstName("Joe");
//		session.update(dbUser);
//		session.getTransaction().commit();
		
		session.close();
	}
}
