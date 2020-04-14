package hibernateDemo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//create 3 student objects	
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

			Student student1=new Student("A","X","a@gmail.com",theDateOfBirth);
			Student student2=new Student("B","Y","b@gmail.com",theDateOfBirth);
			Student student3=new Student("C","Z","c@gmail.com",theDateOfBirth);
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object 
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// commit transaction
			session.getTransaction().commit();
		}
		catch (Exception exc) {
            exc.printStackTrace();
        } 
		finally {
			factory.close();
		}

	}

}
