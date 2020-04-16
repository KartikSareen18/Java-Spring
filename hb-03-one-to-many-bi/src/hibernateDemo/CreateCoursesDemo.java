package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Instructor instructor=session.get(Instructor.class, 1);
			
			Course course1=new Course("Maths");
			Course course2=new Course("Java");
			instructor.add(course1);
			instructor.add(course2);

			//save the instructor object 
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}


	}

}
