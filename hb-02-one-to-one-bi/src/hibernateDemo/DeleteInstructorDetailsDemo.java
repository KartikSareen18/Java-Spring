package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailsDemo {

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
			
			//get the instructor detail object
			InstructorDetail instructorDetail=session.get(InstructorDetail.class,2);
			
			//print the instructor detail
			System.out.println(instructorDetail);
			
			//print the associated instructor
			System.out.println(instructorDetail.getInstructor());
			
			//delete only instructor detail
			//remove the associated object reference
			//break bidirectional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			
			//delete instructor detail 
			session.delete(instructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}


	}

}
