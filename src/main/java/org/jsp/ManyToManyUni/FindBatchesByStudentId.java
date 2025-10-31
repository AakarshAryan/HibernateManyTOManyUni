package org.jsp.ManyToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindBatchesByStudentId {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student ID: ");
		int sid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select s.batches from Student s where s.id = ?1");
		q.setParameter(1, sid);
		
		List<Batch> bl = q.getResultList();
		
		if(bl.size()>0) {
			for(Batch b : bl) {
				System.out.println(b);
			}
		}
		else
			System.err.println("Invalid ID");
	}
}
