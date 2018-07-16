package com.cg.bankwallet.service;

import java.time.LocalDateTime;

import com.cg.bankwallet.beans.Account;
import com.cg.bankwallet.dao.BankWalletDao;
import com.cg.bankwallet.dao.IBankWalletDao;
import com.cg.bankwallet.exception.BankWalletException;

public class BankWalletService implements IBankWalletService {
	IBankWalletDao dao = new BankWalletDao();
	@Override
	public String createAccount(Account acc) throws BankWalletException {
		// TODO Auto-generated method stub
		if (!acc.getMobileNo().matches("\\d{10}")) 
		{
			throw new BankWalletException("Mobile number should contain 10 digits");
		}
		if (acc.getName().isEmpty() || acc.getName() == null) 
		{
			throw new BankWalletException("Name cannot be empty");
		} else {
			if (!acc.getName().matches("[A-Z][A-Za-z]{3,}")) 
			{
				throw new BankWalletException("Name should start with capital letter and should contain only alphabets");
			}
		}
		if (acc.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) 
		{
			throw new BankWalletException("Enter valid emailid");
		}
		if (acc.getBalance() <= 0) 
		{
			throw new BankWalletException("Balance should be greater than zero");
		}
		return dao.createAccount(acc);
	}

	@Override
	public double showBalance(String mobileNo) throws BankWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new BankWalletException("Mobile number should contain 10 digits");
		}
		return dao.showBalance(mobileNo);
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo, double transferAmt) throws BankWalletException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new BankWalletException("Mobile number should contain 10 digits");
		}
		if (!destMobileNo.matches("\\d{10}")) {
			throw new BankWalletException("Mobile number should contain 10 digits");
		}
		IBankWalletService service = new BankWalletService();
		Account acc1 = service.withdraw(sourceMobileNo, transferAmt);
		Account acc2 = service.deposite(destMobileNo, transferAmt);
		return true;
	}
	@Override
	public Account printTransactionDetails(String mobileNo)
			throws BankWalletException {
		// TODO Auto-generated method stub
		return  dao.printTransactionDetails(mobileNo);
	}

	@Override
	public Account deposite(String mobileNo, double depositAmt) throws BankWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) 
		{
			throw new BankWalletException("Mobile number should contain 10 digits");
		}
		Account acc = dao.deposit(mobileNo);
		if (depositAmt <= 0) 
		{
			throw new BankWalletException("Deposit amount must be greater than zero");
		}
		acc.setBalance(acc.getBalance() + depositAmt);
		acc.setDate(LocalDateTime.now());
		return acc;
		
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmt) throws BankWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) 
		{
			throw new BankWalletException("Mobile number should contain 10 digits");
		}
		Account acc = dao.withdraw(mobileNo);
		if (withdrawAmt > acc.getBalance() || withdrawAmt <= 0) 
		{
			throw new BankWalletException("The amount to be withdrawn should be greater than available balance and greater than zero");
		}
		acc.setBalance(acc.getBalance() - withdrawAmt);
		acc.setDate(LocalDateTime.now());
		return acc;
		}


	
}
