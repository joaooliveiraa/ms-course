package com.oliveira.demo.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oliveira.demo.hrpayroll.entities.Worker;

//Mais de uma possivel porta que o proeto estará rodando
@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id); 
		
}
