package com.proof.it.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proof.it.policy.dto.Policy;
import com.proof.it.policy.dto.PolicyModel;
import com.proof.it.policy.service.PremiumCalculatorService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/premiumCalculator")
public class PremiumCalculatorController {
	@Autowired
	PremiumCalculatorService premiumService;
	
	
	@PostMapping(value = "/calculate", consumes = "application/json")	
	public String calculate(@RequestBody PolicyModel policyModel){
	Policy policy=policyModel.getPolicy();
		return premiumService.calculate(policy);
	}
	

}
