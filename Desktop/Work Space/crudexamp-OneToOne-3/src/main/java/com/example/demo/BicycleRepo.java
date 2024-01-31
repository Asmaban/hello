package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepo extends JpaRepository<Bicycle, Long> {

}
