package com.infiniteskills.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.TimeTest;
import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.close();
		
//		session.getTransaction().begin();
//		User user = new User();
//		user.setBirthDate(new Date());//(null); 
//		user.setCreatedDate(new Date());
//		user.setCreatedBy("kevin");
//		user.setEmailAddress("kmb385@yahoo.com");
//		user.setFirstName("kevin");
//		user.setLastName("Bowersox");
//		user.setLastUpdatedBy("kevin");
//		user.setLastUpdatedDate(new Date());
//		session.save(user);
//		session.getTransaction().commit();
		
//		session.beginTransaction();
//		User dbUser =(User) session.get(User.class, user.getUserId());
//		dbUser.setFirstName("Joe");
//		session.update(dbUser);
//		session.getTransaction().commit();
		

		try {
			session.getTransaction().begin();
			
//			session.beginTransaction();
//			TimeTest oTimeTest = (TimeTest) session.get(TimeTest.class, new Long(8));
//			System.out.println("TimeTest: " + oTimeTest.toString());
			
			User oUser = new User();
			oUser.setBirthDate(getMyBirthday());
			oUser.setCreatedBy("William");
			oUser.setCreatedDate(new Date());
			oUser.setEmailAddress("william.wen@tac.com.tw");
			oUser.setFirstName("Wen");
			oUser.setLastName("William");
			oUser.setLastUpdatedBy("Henry");
			oUser.setLastUpdatedDate(new Date());
			
			session.save(oUser);
			session.getTransaction().commit();
			
			session.refresh(oUser);
			
			System.out.println("William's age is " + oUser.getAge());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
//		session.close();
	}
	
	private static Date getMyBirthday() {
		Calendar oCalendar=Calendar.getInstance();
		oCalendar.set(Calendar.YEAR, 1971);
		oCalendar.set(Calendar.MONTH, 2);
		oCalendar.set(Calendar.DATE, 11);
		return oCalendar.getTime();
	}
}
