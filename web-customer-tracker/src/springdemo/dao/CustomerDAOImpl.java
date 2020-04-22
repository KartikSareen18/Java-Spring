package springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Customer;

@Repository           //always applied to DAO implementation 
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
	
		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> query=session.createQuery("from Customer order by lastName ",Customer.class);
		
		List<Customer> customers=query.getResultList();
		
		return customers;
	
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
//		Customer customer=session.get(Customer.class, id);
//		session.delete(customer);
		
		Query<Customer>query=session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer>query=null;
		
		if(name!=null && name.trim().length()>0)
		{
			query=session.createQuery("from Customer where lower(lastName) like :name or lower(firstName) like :name",Customer.class);
			query.setParameter("name","%"+name.toLowerCase()+"%");
		}
		else {
			query=session.createQuery("from Customer",Customer.class);
		}
		List<Customer>customers=query.getResultList();
		//System.out.println(customers);
		return customers;
	}

}
