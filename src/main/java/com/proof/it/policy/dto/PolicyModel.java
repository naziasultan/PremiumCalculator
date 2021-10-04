package com.proof.it.policy.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PolicyModel {

	private Policy policy;

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
}
