package com.proof.it.policy.dto;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@NonNull
public class Policy {
	
	private String policyNumber;
	private String policyStatus;
	private List<PolicyProduct> policyProducts;
	
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public List<PolicyProduct> getPolicyProducts() {
		return policyProducts;
	}
	public void setPolicyProducts(List<PolicyProduct> policyProduct) {
		this.policyProducts = policyProduct;
	}
	

}
