package com.example.demo;

import java.util.List;

public interface SsttudentService {
	List<Ssttudent> getAllStudents();
	Ssttudent saveSsttudent(Ssttudent student);
	Ssttudent saveSsttudent1(Ssttudent student);
	Ssttudent updateSsttudent(Ssttudent student);
	Ssttudent getSsttudentById(Long id);
	void deleteSsttudentById(Long id);

}
