package com.cg.bankwallet.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.bankwallet.beans.Account;

public class BankWalletDb {
	public static HashMap<String, Account> bankWalletDb=new HashMap<String, Account>();
	public static HashMap<String, Account> getBankWalletMap(){
		return bankWalletDb;
	} 
	Account obj=new Account();
	static{
		bankWalletDb.put("8185800166", new Account("8185800166","Miya","miya@cg.com",2000.0,LocalDateTime.now()));
		bankWalletDb.put("8185800167", new Account("8185800167","Keira","keira@cg.com",1000.0,LocalDateTime.now()));
		bankWalletDb.put("9948032465", new Account("99480132465","Benji","benji@cg.com",2000.0,LocalDateTime.now()));
		bankWalletDb.put("8185800165", new Account("8185800165","Judy","judy@cg.com",1500.0,LocalDateTime.now()));
	}

}
