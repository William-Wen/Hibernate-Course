package com.infiniteskills.data;

import java.util.Calendar;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.Bank;
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
//			session.getTransaction().begin();
			
//			session.beginTransaction();
//			TimeTest oTimeTest = (TimeTest) session.get(TimeTest.class, new Long(8));
//			System.out.println("TimeTest: " + oTimeTest.toString());
			
//			User oUser = new User();
//			oUser.setBirthDate(getMyBirthday());
//			oUser.setCreatedBy("William");
//			oUser.setCreatedDate(new Date());
//			oUser.setEmailAddress("william.wen@tac.com.tw");
//			oUser.setFirstName("Wen");
//			oUser.setLastName("William");
//			oUser.setLastUpdatedBy("Henry");
//			oUser.setLastUpdatedDate(new Date());
//			
//			session.save(oUser);
//			session.getTransaction().commit();
//			
//			session.refresh(oUser);
//			
//			System.out.println("William's age is " + oUser.getAge());
			
			Transaction oTransaction = session.beginTransaction();
			
			Bank oBank = new Bank();
			oBank.setName("Federal Trust");
			oBank.setAddressLine1("33 Wall Street");
			oBank.setAddressLine2("Suite 302");
			oBank.setCity("New York");
			oBank.setState("NY");
			oBank.setZipCode("27914");
			oBank.setCreatedBy("Kevin BowerSox");
			oBank.setCreatedDate(new Date());
			oBank.setLastUpdatedBy("Kevin Bowersox");
			oBank.setLastUpdatedDate(new Date());
			oBank.setInternational(false);
			
			oBank.getContacts().add("Contact 1");
			oBank.getContacts().add("Contact 2");
			
			session.save(oBank);
			
//			User oUser = new User();
//			Address oAddress = new Address();
//			oUser.setAge(46);
//			oUser.setBirthDate(new Date());
//			oUser.setCreatedBy("William");
//			oUser.setCreatedDate(new Date());
//			oUser.setEmailAddress("william.wen@");
//			oUser.setFirstName("William");
//			oUser.setLastName("Wen");
//			oUser.setLastUpdatedBy("William");
//			oUser.setLastUpdatedDate(new Date());
//			
//			oAddress.setAddressLine1("Line1");
//			oAddress.setAddressLine2("Line2");
//			oAddress.setCity("Philadelphia");
//			oAddress.setState("PA");
//			oAddress.setZipCode("12345");
//			
//			oUser.setAddress(oAddress);
//			session.save(oUser);
			
			oTransaction.commit();
			
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
