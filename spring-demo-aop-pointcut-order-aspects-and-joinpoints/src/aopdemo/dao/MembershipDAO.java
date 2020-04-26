package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount() {
		System.out.println(getClass()+ " :adding a membership account");
		return true;
	}
	
	public boolean doWorkMember() {
		System.out.println(getClass()+ " :doWorkMember() method");
		return true;
	}
}
