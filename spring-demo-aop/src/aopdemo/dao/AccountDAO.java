package aopdemo.dao;

import org.springframework.stereotype.Component;

import aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account acc,boolean vipFlag) {
		System.out.println(getClass()+ " :Doing my db work adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ " :doWork() method");
		return true;
	}
}
