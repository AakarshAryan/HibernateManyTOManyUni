package org.jsp.ManyToManyUni;

import java.util.Arrays;

import javax.persistence.*;

public class SaveBatchsAndStudents {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		
		Batch b1 = new Batch();
		b1.setBatchCode("B1");
		b1.setTrainer("Keshava");
		b1.setSubject("JAVA");
		
		Batch b2 = new Batch();
		b2.setBatchCode("B2");
		b2.setTrainer("Rohan");
		b2.setSubject("SQL");
		
		Student s1 = new Student();
		s1.setName("Aakarsh");
		s1.setPhone(8877445566l);
		s1.setPercentage(82.12);
		
		Student s2 = new Student();
		s2.setName("Sagar");
		s2.setPhone(6655441122l);
		s2.setPercentage(98.25);
		
		Student s3 = new Student();
		s3.setName("Rohit");
		s3.setPhone(8784512635l);
		s3.setPercentage(75.15);
		
		b1.setStudents(Arrays.asList(s1,s2,s3));
		b2.setStudents(Arrays.asList(s1,s3));
		
		s1.setBatches(Arrays.asList(b1,b2));
		s2.setBatches(Arrays.asList(b1));
		s3.setBatches(Arrays.asList(b1,b2));
		
		
		man.persist(b1);
		man.persist(b2);
		
		tran.commit();
		
	}
}
