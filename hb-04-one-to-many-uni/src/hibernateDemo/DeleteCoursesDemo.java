package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

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

			//deleting course not instructor
			Course c=session.get(Course.class,1);
			session.delete(c);
			
			//deleting instructor not courses
//			Instructor i=session.get(Instructor.class, 1);
//			for(Course c:i.getCourses()){
//				c.setInstructor(null);
//			}
//			session.delete(i);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}


	}

}
