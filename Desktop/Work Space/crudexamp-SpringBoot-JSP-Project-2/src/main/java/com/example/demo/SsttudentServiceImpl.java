package com.example.demo;
import com.example.demo.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SsttudentServiceImpl implements SsttudentService {
	
	private SsttudentRepo studentRepo;
	
	

	public SsttudentServiceImpl(SsttudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}



	@Override
	public List<Ssttudent> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}



	@Override
	public Ssttudent saveSsttudent(Ssttudent student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}



	@Override
	public Ssttudent updateSsttudent(Ssttudent student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}



	@Override
	public Ssttudent getSsttudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}



	@Override
	public void deleteSsttudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
		
	}



	@Override
	public Ssttudent saveSsttudent1(Ssttudent student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

}
