package com.oliveira.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.hrworker.entities.Worker;
import com.oliveira.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class); 
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired //Para fazer a injeção de dependecia automaticamente
	private WorkerRepository repository;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
			logger.info("CONFIG = " + testConfig);
			return ResponseEntity.noContent().build();
			
	}	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
			List<Worker> list = repository.findAll(); //Busca tudo do banco.
			return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
			logger.info("PORT = " + env.getProperty("local.server.port"));
		
			Worker obj = repository.findById(id).get(); //Busca por id do banco.
			return ResponseEntity.ok(obj);
	}	

}
