package org.jsp.ManyToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindStudentByBatchId {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch ID: ");
		int bid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select b.students from Batch b where b.id = ?1");
		q.setParameter(1, bid);
		
		List<Student> sl = q.getResultList();
		
		if(sl.size() > 0) {
			for(Student s : sl) {
				System.out.println(s);
			}
		}
		else
			System.err.println("Invalid ID");
		
		sc.close();
	}
}
