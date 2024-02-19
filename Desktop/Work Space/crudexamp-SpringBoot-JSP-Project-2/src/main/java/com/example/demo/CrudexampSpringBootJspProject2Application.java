package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudexampSpringBootJspProject2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudexampSpringBootJspProject2Application.class, args);
	}
	
	@Autowired
	private SsttudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Ssttudent student1 = new Ssttudent("Asma", "Banu", "asmabanu@gmail.com");
		studentRepo.save(student1);
		
		Ssttudent student2 = new Ssttudent("Sravani", "Roy", "sravani123@gmail.com");
		studentRepo.save(student2);
		
		Ssttudent student3 = new Ssttudent("Alla", "Manikyam", "alla765@gmail.com");
		studentRepo.save(student3);*/
		
		
	}

}
