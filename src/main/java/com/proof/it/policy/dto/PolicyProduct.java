package com.proof.it.policy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@NonNull
@Component
public class PolicyProduct {

	private String productName;

	private List<PolicyAplliance> policyAplliances;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public List<PolicyAplliance> getPolicyAplliances() {
		return policyAplliances;
	}

	public void setPolicyAplliances(List<PolicyAplliance> policyAplliances) {
		this.policyAplliances = policyAplliances;
	}
	

	

}
