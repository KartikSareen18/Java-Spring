package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//option 2: hibernate query with HQL
			
			Query<Instructor> query= session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", 2);
			
			//execute query and get instructor
			Instructor instructor=query.getSingleResult();
			
			System.out.println("GET Instructor: "+instructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\nThe session is now closed\n");
			
			System.out.println("GET Courses: "+instructor.getCourses());
			
		}
		finally {
			session.close();
			factory.close();
		}


	}

}
