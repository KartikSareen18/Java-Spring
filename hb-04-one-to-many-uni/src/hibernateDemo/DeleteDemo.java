package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get instructor by id
			int id=1;
			Instructor instructor=session.get(Instructor.class, id);	
			
			// delete the instructor
			if(instructor!=null)
				session.delete(instructor);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}


	}

}
