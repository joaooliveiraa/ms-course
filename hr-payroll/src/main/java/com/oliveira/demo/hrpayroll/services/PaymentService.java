package com.oliveira.demo.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.demo.hrpayroll.entities.Payment;
import com.oliveira.demo.hrpayroll.entities.Worker;
import com.oliveira.demo.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		
		Worker worker =  workerFeignClient.findById(workerId).getBody(); //Pegar na resposta que é tipo worker
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
