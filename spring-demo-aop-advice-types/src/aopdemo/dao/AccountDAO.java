package aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("Runtime Exception");
		}
		
		List<Account> accs=new ArrayList<>();
		
		//create sample accounts
		Account a1=new Account("John","Silver");
		Account a2=new Account("a","Platinum");
		Account a3=new Account("b","Gold");
		
		//add to list
		accs.add(a1);
		accs.add(a2);
		accs.add(a3);
		
		return accs;
		
	}
	
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
