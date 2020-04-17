package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course c=new Course("Python");
			
			session.save(c);
			System.out.println(c);
			
			Student s1=new Student("a","b","a@gmail.com");
			Student s2=new Student("x","y","x@gmail.com");
			
			c.addStudent(s1);
			c.addStudent(s2);
			
			//save the students
			session.save(s1);
			session.save(s2);
			
			System.out.println(c.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}


	}

}
