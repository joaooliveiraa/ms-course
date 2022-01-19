package com.oliveira.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.hrworker.entities.Worker;
import com.oliveira.hrworker.repositories.WorkerRepository;


@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Autowired //Para fazer a injeção de dependecia automaticamente
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
			List<Worker> list = repository.findAll(); //Busca tudo do banco.
			return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
			Worker obj = repository.findById(id).get(); //Busca por id do banco.
			return ResponseEntity.ok(obj);
	}	

}
