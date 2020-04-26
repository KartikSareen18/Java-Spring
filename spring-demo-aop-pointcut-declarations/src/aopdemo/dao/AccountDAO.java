package aopdemo.dao;

import org.springframework.stereotype.Component;

import aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account acc,boolean vipFlag) {
		System.out.println(getClass()+ " :Doing my db work adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ " :doWork() method");
		return true;
	}

	public String getName() {
		System.out.println(getClass()+ " :getName() method");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ " :setName() method");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ " :getServiceCode() method");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ " :setServiceCode() method");
		this.serviceCode = serviceCode;
	}
	
	
}
