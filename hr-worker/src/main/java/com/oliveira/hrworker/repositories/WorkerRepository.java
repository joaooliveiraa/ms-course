package com.oliveira.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
