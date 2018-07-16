package com.cg.bankwallet.dao;

import java.util.HashMap;

import com.cg.bankwallet.beans.Account;
import com.cg.bankwallet.db.BankWalletDb;
import com.cg.bankwallet.exception.BankWalletException;
/*
 * Class Name: BankWalletDao
 * Interface Implemented: IBankWalletDao
 * No. of methods: 5
 * Author: @mprathyu
 * Date Of Creation: 13th July 2018
 * Last Date of modification: 16th July 2018
 */
public class BankWalletDao implements IBankWalletDao {
	private static HashMap<String, Account> BankWalletMap = BankWalletDb.getBankWalletMap();
	
	@Override
	/*
	 * Method Name: createAccount
	 * @throws: BankWalletException
	 * Return Type: acc.getMobileNo
	 * 
	 */
	public String createAccount(Account acc) throws BankWalletException {
		// TODO Auto-generated method stub
		BankWalletMap.put(acc.getMobileNo(), acc);
		return acc.getMobileNo();
	}

	@Override
	/*
	 * Method Name: showBalance
	 * @throws : BankWalletException
	 * Return Type: acc.getBalance
	 * 
	 */
	public double showBalance(String mobileNo) throws BankWalletException {
		// TODO Auto-generated method stub
		Account acc=BankWalletMap.get(mobileNo);
		if(acc==null){
			throw new BankWalletException("The Mobile Number does not exist");
		}
		return acc.getBalance();
	}

	@Override
	/*
	 * Method Name: deposit
	 * @throws: BankWalletException
	 * Return Type: acc
	 * 
	 */
	public Account deposit(String mobileNo) throws BankWalletException {
		// TODO Auto-generated method stub
		Account acc=BankWalletMap.get(mobileNo);
		if(acc==null){
			throw new BankWalletException("The Mobile Number does not exist");
		}
		return acc;
	}

	@Override
	/*
	 * Method Name: withdraw
	 * @throws: BankWalletException
	 * Return Type: acc
	 * 
	 */
	public Account withdraw(String mobileNo) throws BankWalletException {
		// TODO Auto-generated method stub
		Account acc= BankWalletMap.get(mobileNo);
		if(acc==null){
			throw new BankWalletException("The Mobile Number does not exist");
		}
		return acc;
	}

	@Override
	/*
	 * Method Name: printTransactionDetails
	 * @throws: BankWalletException
	 * Return Type: acc
	 * 
	 */
	public Account printTransactionDetails(String mobileNo)
			throws BankWalletException {
		// TODO Auto-generated method stub
		Account acc= BankWalletMap.get(mobileNo);
		if(acc==null){
			throw new BankWalletException("The Mobile Number does not exist");
		}
		return acc;
	}

}
