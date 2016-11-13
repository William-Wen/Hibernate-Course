package com.infiniteskills.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
//import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import com.infiniteskills.data.entities.Account;
import com.infiniteskills.data.entities.AccountType;
import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.Bank;
import com.infiniteskills.data.entities.Bond;
import com.infiniteskills.data.entities.Budget;
import com.infiniteskills.data.entities.Credential;
import com.infiniteskills.data.entities.Currency;
import com.infiniteskills.data.entities.Investment;
import com.infiniteskills.data.entities.Market;
import com.infiniteskills.data.entities.Portfolio;
import com.infiniteskills.data.entities.Stock;
import com.infiniteskills.data.entities.TimeTest;
import com.infiniteskills.data.entities.Transaction;
import com.infiniteskills.data.entities.User;
import com.infiniteskills.data.entities.ids.CurrencyId;

public class Application {

	/*
	 * public static void main(String[] args) { Session session =
	 * HibernateUtil.getSessionFactory().openSession(); //
	 * session.beginTransaction(); // session.close();
	 *
	 * // session.getTransaction().begin(); // User user = new User(); //
	 * user.setBirthDate(new Date());//(null); // user.setCreatedDate(new
	 * Date()); // user.setCreatedBy("kevin"); //
	 * user.setEmailAddress("kmb385@yahoo.com"); // user.setFirstName("kevin");
	 * // user.setLastName("Bowersox"); // user.setLastUpdatedBy("kevin"); //
	 * user.setLastUpdatedDate(new Date()); // session.save(user); //
	 * session.getTransaction().commit();
	 *
	 * // session.beginTransaction(); // User dbUser =(User)
	 * session.get(User.class, user.getUserId()); // dbUser.setFirstName("Joe");
	 * // session.update(dbUser); // session.getTransaction().commit();
	 *
	 * try { // session.getTransaction().begin();
	 *
	 * // session.beginTransaction(); // TimeTest oTimeTest = (TimeTest)
	 * session.get(TimeTest.class, new // Long(8)); //
	 * System.out.println("TimeTest: " + oTimeTest.toString());
	 *
	 * // User oUser = new User(); // oUser.setBirthDate(getMyBirthday()); //
	 * oUser.setCreatedBy("William"); // oUser.setCreatedDate(new Date()); //
	 * oUser.setEmailAddress("william.wen@tac.com.tw"); //
	 * oUser.setFirstName("Wen"); // oUser.setLastName("William"); //
	 * oUser.setLastUpdatedBy("Henry"); // oUser.setLastUpdatedDate(new Date());
	 * // // session.save(oUser); // session.getTransaction().commit(); // //
	 * session.refresh(oUser); // // System.out.println("William's age is " +
	 * oUser.getAge());
	 *
	 * org.hibernate.Transaction oTransaction = session.beginTransaction();
	 *
	 * // Bank oBank = new Bank(); // oBank.setName("Federal Trust"); //
	 * oBank.setAddressLine1("33 Wall Street"); //
	 * oBank.setAddressLine2("Suite 302"); // oBank.setCity("New York"); //
	 * oBank.setState("NY"); // oBank.setZipCode("27914"); //
	 * oBank.setCreatedBy("Kevin BowerSox"); // oBank.setCreatedDate(new
	 * Date()); // oBank.setLastUpdatedBy("Kevin Bowersox"); //
	 * oBank.setLastUpdatedDate(new Date()); // oBank.setInternational(false);
	 * // // // oBank.getContacts().add("Contact 1"); // //
	 * oBank.getContacts().add("Contact 2"); //
	 * oBank.getContacts().put("MANAGER", "Henry"); //
	 * oBank.getContacts().put("TELLER", "William"); // session.save(oBank);
	 *
	 * // User oUser = new User(); // // Address oAddress = new Address(); //
	 * oUser.setAge(26); // oUser.setBirthDate(new Date()); //
	 * oUser.setCreatedBy("William"); // oUser.setCreatedDate(new Date()); //
	 * oUser.setEmailAddress("henry.wen@"); // oUser.setFirstName("Henry"); //
	 * oUser.setLastName("Wen"); // oUser.setLastUpdatedBy("William"); //
	 * oUser.setLastUpdatedDate(new Date());
	 *
	 * // oAddress.setAddressLine1("Line1"); //
	 * oAddress.setAddressLine2("Line2"); // oAddress.setCity("Philadelphia");
	 * // oAddress.setState("PA"); // oAddress.setZipCode("12345");
	 *
	 * // oUser.setAddress(oAddress); // session.save(oUser);
	 *
	 * // Address address1 = new Address(), address2 = new Address(); //
	 * setAddressFields1(address1); // setAddressFields2(address2); //
	 * oUser.getAddress().add(address1); // oUser.getAddress().add(address2);
	 *
	 * // session.save(oUser); // Credential oCredential = new Credential(); //
	 * oCredential.setPassword("1234"); // oCredential.setUsername("henry"); //
	 * oCredential.setUser(oUser); // oUser.setCredential(oCredential); //
	 * session.save(oCredential); // // oTransaction.commit(); // // User dbUser
	 * = (User) session.get(User.class, // oCredential.getUser().getUserId());
	 * // System.out.println("User name is " + dbUser.getFirstName());
	 *
	 * // Account oAccount = createNewAccount(); //
	 * oAccount.getTransactions().add(createNewBeltPurchase(oAccount)); //
	 * oAccount.getTransactions().add(createShoePurchase(oAccount)); //
	 * session.save(oAccount); // oTransaction.commit(); // // Transaction
	 * dbTransaction =(Transaction) // session.get(Transaction.class, //
	 * oAccount.getTransactions().get(0).getTransactionId()); //
	 * System.out.println(dbTransaction.getAccount().getName());
	 *
	 * // Section 06, Lecture 38: @JoinTable // Account account =
	 * createNewAccount(); // Budget budget = new Budget(); //
	 * budget.setGoalAmount(new BigDecimal("10000.00")); //
	 * budget.setName("Emergency Fund"); // budget.setPeriod("Yearly"); //
	 * budget.getTransactions().add(createNewBeltPurchase(account)); //
	 * budget.getTransactions().add(createShoePurchase(account)); // //
	 * session.save(budget); // oTransaction.commit();
	 *
	 * // Section 06, Lecture 39¡G Unidirectional Many To Many Association //
	 * Account account01 = createNewAccount(); // Account account02 =
	 * createNewAccount(); // User user01 = createUser(); // User
	 * user02=createUser(); // account01.getUsers().add(user01); //
	 * account01.getUsers().add(user02); // user01.getAccounts().add(account01);
	 * // user02.getAccounts().add(account01); //
	 * account02.getUsers().add(user01); // account02.getUsers().add(user02); //
	 * user01.getAccounts().add(account02); //
	 * user02.getAccounts().add(account02); // // session.save(account01); //
	 * session.save(account02); // // oTransaction.commit(); // // // Section
	 * 06. Entity Associations // // Lecture 39. Unidirectional Many To Many
	 * Association //// Account dbAccount =(Account) session.get(Account.class,
	 * // account01.getAccountId()); //// System.out.println("Email: " + //
	 * dbAccount.getUsers().iterator().next().getEmailAddress()); // // User
	 * dbUser = (User)session.get(User.class, user01.getUserId()); //
	 * System.out.println("User = [" + //
	 * dbUser.getAccounts().iterator().next().getName() + "]");
	 *
	 * // Section 07, Hibernate API // Lecture 45, Saving Entities // Account
	 * oAccount = createNewAccount(); // Transaction oTransactionBelt =
	 * createNewBeltPurchase(oAccount); // Transaction oTransactionShoe =
	 * createShoePurchase(oAccount); // //
	 * oAccount.getTransactions().add(oTransactionBelt); //
	 * oAccount.getTransactions().add(oTransactionShoe); // //
	 * System.out.println(session.contains(oAccount)); //
	 * System.out.println(session.contains(oTransactionBelt)); //
	 * System.out.println(session.contains(oTransactionShoe)); //
	 * session.save(oAccount); //
	 * System.out.println(session.contains(oAccount)); //
	 * System.out.println(session.contains(oTransactionBelt)); //
	 * System.out.println(session.contains(oTransactionShoe)); //
	 * oTransaction.commit();
	 *
	 * // Section 07, Hibernate API // Lecture 45, Retrieving Entities //// Bank
	 * oBank =(Bank) session.get(Bank.class, 123L); //// Bank oBank = (Bank)
	 * session.get(Bank.class, 1L); //// oBank = (Bank) session.get(Bank.class,
	 * 1L); //// Bank oBank = (Bank) session.load(Bank.class, 1L); // Bank oBank
	 * = (Bank) session.load(Bank.class, 1123L); //
	 * System.out.println("Method Executed"); // // System.out.println("Bank: ["
	 * + oBank.getName() + "]"); // oTransaction.commit();
	 *
	 * // Section 07. Hibernate API // Lecture 46. Modifying Entities. // Bank
	 * oBank = (Bank) session.get(Bank.class, 1L); //
	 * oBank.setName("Standard Bank"); // oBank.setLastUpdatedBy("William Wen");
	 * // oBank.setLastUpdatedDate(new Date()); // // oTransaction.commit();
	 *
	 * // Section 07. Hibernate API // Lecture 47. Removing Entities // Bank
	 * oBank = (Bank) session.get(Bank.class, 1L); //
	 * System.out.println(session.contains(oBank)); // session.delete(oBank); //
	 * System.out.println("Method Invoked"); //
	 * System.out.println(session.contains(oBank)); // oTransaction.commit();
	 *
	 * // Section 07. Hibernate API // Lecture 48. Reattaching Detached Entities
	 * // Bank oBank = (Bank) session.get(Bank.class, 1L); //
	 * oTransaction.commit(); // session.close(); // // Session oSession2 =
	 * HibernateUtil.getSessionFactory().openSession(); //
	 * org.hibernate.Transaction oTransaction2 = oSession2.beginTransaction();
	 * // // System.out.println(oSession2.contains(oBank)); //
	 * oSession2.update(oBank); // oBank.setName("CITI BANK"); //
	 * System.out.println("Update Method Invoke"); //
	 * System.out.println(oSession2.contains(oBank)); // //
	 * oTransaction2.commit(); // oSession2.close();
	 *
	 * // Section 07. Hibernate API // Lecture 49. Save Or Update // Bank
	 * detachedBank = (Bank) session.get(Bank.class, 1L); //
	 * oTransaction.commit(); // session.close(); // // Bank transientBank =
	 * createBank(); // // Session oSession2 =
	 * HibernateUtil.getSessionFactory().openSession(); //
	 * org.hibernate.Transaction oTransaction2 = oSession2.beginTransaction();
	 * // // oSession2.saveOrUpdate(detachedBank); //
	 * oSession2.saveOrUpdate(transientBank); //
	 * detachedBank.setName("Test Bank 2"); // oTransaction2.commit(); //
	 * oSession2.close();
	 *
	 * // Section 07. Hibernate API // Lecture 50. Flushing The Presistence
	 * Context Bank oBank = (Bank) session.get(Bank.class, 1L);
	 * oBank.setName("Changed Bank"); System.out.println("Calling Flush");
	 * session.flush();
	 *
	 * oBank.setAddressLine1("Changed Address");
	 * System.out.println("Calling commit"); oTransaction.commit();
	 *
	 *
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * finally { // session.close(); HibernateUtil.getSessionFactory().close();
	 * } // session.close(); }
	 */

	public static void main(String[] args) {
		SessionFactory oSessionFactory = null;
		Session oSession01 = null;
		Session oSession02 = null;
		org.hibernate.Transaction oTransaction01 = null;
		org.hibernate.Transaction oTransaction02 = null;

		try {
			oSessionFactory = HibernateUtil.getSessionFactory();
			oSession01 = oSessionFactory.openSession();
			oTransaction01 =oSession01.beginTransaction();

/*			Section 09. Advanced Mappings & Configuraition
 			Lecture 60. Compound Primary Keys

  			Currency oCurrency = new Currency();
			oCurrency.setCountryName("Taiwan");
			oCurrency.setName("Dollar");
			oCurrency.setSymbol("$");

			oSession01.persist(oCurrency);
			oTransaction01.commit();

			oSession02 = oSessionFactory.openSession();
			oTransaction02=oSession02.beginTransaction();
			Currency dbCurrency = (Currency) oSession02.get(Currency.class, new CurrencyId("Dollar", "Taiwan"));
			System.out.println("Country Name: [" + dbCurrency.getCountryName() + "]");
			oTransaction02.commit();
*/
/*			Section 09. Advanced Mappings & Configuration
 			Lecture 61. Compound Join Columns

 			Currency oCurrency = new Currency();
			oCurrency.setCountryName("China");
			oCurrency.setName("Pound");
			oCurrency.setSymbol("Pound Sign");

			Market oMarket = new Market();
			oMarket.setMarketName("Stock Exchange");
			oMarket.setCurrency(oCurrency);
			oSession01.persist(oMarket);
			oTransaction01.commit();
*/
//			Section 09. Advanced Mappings & Configuration
//			Lecture 62. Enumerations
//			Account oAccount = createNewAccount();
//			oAccount.setAccountType(AccountType.SAVINGS);
//
//			oSession01.save(oAccount);
//			oTransaction01.commit();
//
//			Account dbAccount = (Account) oSession01.get(Account.class, oAccount.getAccountId());
//			System.out.println("Account Name: [" + dbAccount.getName() + "]");
//			System.out.println("Account Type: [" + dbAccount.getAccountType() + "]");

			// Section 09. Advanced Mappings & Configuration
			// Lecture 63. Mapped Superclass Inheritance
//			Stock oStock = createStock();
//			oSession01.save(oStock);
//			
//			Bond oBond = createBond();
//			oSession01.save(oBond);
//
//			oTransaction01.commit();

			// Section 09. Advanced Mappings & Configuration
			// Lecture 64, 65. Table Per Class Inheritance
			Portfolio oPortfolio = new Portfolio();
			oPortfolio.setName("First Investments");
			
			Stock oStock = createStock();
			oStock.setPortfolio(oPortfolio);
			
			Bond oBond = createBond();
			oBond.setPortfolio(oPortfolio);
			
			oPortfolio.getInvestments().add(oStock);
			oPortfolio.getInvestments().add(oBond);
			
			oSession01.save(oStock);
			oSession01.save(oBond);
			
			oTransaction01.commit();
			
			Portfolio dbPortfolio = (Portfolio) oSession01.get(Portfolio.class, oPortfolio.getPortfolioId());
			oSession01.refresh(dbPortfolio);
			
			for (Investment oInvestment : dbPortfolio.getInvestments()) {
				System.out.println("Name: [" + oInvestment.getName() + "]");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (oTransaction01 != null) {
				oTransaction01.rollback();
			}
//			if (oTransaction02 != null) {
//				oTransaction02.rollback();
//			}
		} finally {
			oSession01.close();
//			oSession02.close();
			oSessionFactory.close();
		}
	}

	private static Bond createBond() {
		Bond oBond = new Bond();
		oBond.setInterestRate(new BigDecimal("123.22"));
		oBond.setIssuer("JP Morgan Chase");
		oBond.setMaturityDate(new Date());
		oBond.setPurchaseDate(new Date());
		oBond.setName("Long Term Bond Purchases");
		oBond.setValue(new BigDecimal("10.22"));
		return oBond;
	}

	private static Stock createStock() {
		Stock oStock = new Stock();
		oStock.setIssuer("Allen Edmonds");
		oStock.setName("Private American Stock Purchases");
		oStock.setPurchaseDate(new Date());
		oStock.setQuantity(new BigDecimal("1922"));
		oStock.setSharePrice(new BigDecimal("100.00"));
		return oStock;
	}

	private static Date getMyBirthday() {
		Calendar oCalendar = Calendar.getInstance();
		oCalendar.set(Calendar.YEAR, 1971);
		oCalendar.set(Calendar.MONTH, 2);
		oCalendar.set(Calendar.DATE, 11);
		return oCalendar.getTime();
	}

	private static void setAddressFields1(Address address) {
		address.setAddressLine1("First Line 1");
		address.setAddressLine2("First Line 2");
		address.setCity("New York");
		address.setState("1");
		address.setZipCode("NY");
	}

	private static void setAddressFields2(Address address) {
		address.setAddressLine1("Second Line 1");
		address.setAddressLine2("Second Line 2");
		address.setCity("New Taipei City");
		address.setState("2");
		address.setZipCode("NT");
	}

	private static User createUser() {
		User user = new User();
		Address address = createAddress();
		user.setAddress(Arrays.asList(new Address[] { createAddress() }));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("William");
		user.setLastName("Wen");
		user.setLastUpdatedBy("William Wen");
		user.setLastUpdatedDate(new Date());
		return user;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("PRIMARY");
		return address;
	}

	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Transaction createNewBeltPurchase(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin Bowersox");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Kevin Bowersox");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}

	private static Transaction createShoePurchase(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Work Shoes");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Kevin Bowersox");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Kevin Bowersox");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		return shoePurchase;
	}

	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}

	private static Bank createBank() {
		Bank oBank = new Bank();
		oBank.setName("First United Federal");
		oBank.setAddressLine1("103 Washington Plaza");
		oBank.setAddressLine2("Suite 332");
		oBank.setAddressType("PRIMARY");
		oBank.setCity("New York");
		oBank.setCreatedBy("William Wen");
		oBank.setCreatedDate(new Date());
		oBank.setInternational(false);
		oBank.setLastUpdatedBy("Henry Wen");
		oBank.setLastUpdatedDate(new Date());
		oBank.setState("NY");
		oBank.setZipCode("999");
		return oBank;
	}

}
