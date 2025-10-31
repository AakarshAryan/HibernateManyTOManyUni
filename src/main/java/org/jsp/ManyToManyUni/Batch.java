package org.jsp.ManyToManyUni;

import java.util.List;

import javax.persistence.*;

@Entity
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String batchCode;
	private String trainer;
	private String subject;
	
	@JoinTable(name = "BatchStudentTable", 
			joinColumns = {@JoinColumn(name = "Batch_id")}, 
			inverseJoinColumns = {@JoinColumn(name = "Student_id")})
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> students;
	
	
	@Override
	public String toString() {
		return "Batch [id=" + id + ", batchCode=" + batchCode + ", trainer=" + trainer + ", subject=" + subject + "]";
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
