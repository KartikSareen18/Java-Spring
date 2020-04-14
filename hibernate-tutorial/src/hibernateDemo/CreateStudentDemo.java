package hibernateDemo;

import java.util.Date;
import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//create a student object
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            
			Student student=new Student("Kartik","Sareen","kartik@gmail.com",theDateOfBirth);
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object 
			session.save(student);
			
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
