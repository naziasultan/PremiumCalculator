package com.proof.it.policy.dto;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.NonNull;
@NoArgsConstructor
@NonNull
public class PolicyAplliance {
	
	private String name;
	
	private List<RiskType> riskType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<RiskType> getRiskType() {
		return riskType;
	}
	public void setRiskType(List<RiskType> riskType) {
		this.riskType = riskType;
	}
		
}
