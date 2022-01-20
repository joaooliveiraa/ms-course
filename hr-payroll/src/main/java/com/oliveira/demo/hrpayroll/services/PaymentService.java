package com.oliveira.demo.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.oliveira.demo.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long WorkerId, int days) {
		return new Payment("Bob", 200.0, days);
	}

}
