package hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			//query students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(students);
			
			//query students: lastName='Sareen'
			students=session.createQuery("from Student s where s.lastName='Sareen'").getResultList();
			
			//display the students
			System.out.println("\nQuery using where clause:\n");
			displayStudents(students);
			
			//query students: lastName='Sareen' OR firstName='A'
			students=session.createQuery("from Student s where s.lastName='Sareen' OR s.firstName='A'").getResultList();
			
			//display the students
			System.out.println("\nQuery containing OR:\n");
			displayStudents(students);
			
			//query students: email like '%gmail.com'
			students=session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display the students
			System.out.println("\nQuery containing LIKE:\n");
			displayStudents(students);
			
			
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}


	}

	private static void displayStudents(List<Student> students) {
		for(Student s:students)
			System.out.println(s);
	}

}
