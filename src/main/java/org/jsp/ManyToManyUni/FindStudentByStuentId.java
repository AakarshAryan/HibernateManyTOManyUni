package org.jsp.ManyToManyUni;

import java.util.Scanner;

import javax.persistence.*;

public class FindStudentByStuentId {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID: ");
		int sid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Student s = man.find(Student.class, sid);
		
		if(s != null)
			System.out.println(s);
		else
			System.err.println("Invalid ID");
		
		sc.close();
	}
}
