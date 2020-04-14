package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			Student student=session.get(Student.class, 1);
			student.setEmail("ax@gmail.com");
			
			// commit transaction
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email='abc@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}


	}

}
