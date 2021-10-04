package com.proof.it.policy.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RiskType {

	private String name;
	private double sumInsured;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSumInsured() {
		return sumInsured;
	}
	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}
}
