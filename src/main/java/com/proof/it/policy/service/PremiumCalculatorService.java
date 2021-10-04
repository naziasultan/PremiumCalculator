package com.proof.it.policy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proof.it.policy.constants.PolicyConstants;
import com.proof.it.policy.dto.Policy;
import com.proof.it.policy.dto.PolicyAplliance;
import com.proof.it.policy.dto.PolicyProduct;
import com.proof.it.policy.dto.RiskType;
import com.proof.it.policy.utility.PolicyUtility;

@Component
public class PremiumCalculatorService implements PremiumCalculatorServiceImpl {

	@Autowired
	PolicyProduct product;

	@Override
	public String calculate(Policy policy) {

		double premiumAmount = 0;
		for (int i = 0; i < policy.getPolicyProducts().size(); i++) {
			product = policy.getPolicyProducts().get(i);
			premiumAmount += premiumAmount(product, premiumAmount);

		}

		return PolicyUtility.decimalToString(premiumAmount);
	}

	private double premiumAmount(PolicyProduct product, double premiumAmount) {

		for (int j = 0; j < product.getPolicyAplliances().size(); j++) {
			PolicyAplliance applicance = product.getPolicyAplliances().get(j);
			for (int i = 0; i < applicance.getRiskType().size(); i++) {
				RiskType riskType = applicance.getRiskType().get(i);

				if (PolicyConstants.FIRE.equalsIgnoreCase(riskType.getName())) {
					if (riskType.getSumInsured() > 100) {
						premiumAmount += riskType.getSumInsured() * PolicyConstants.COEFFICIENT_FIRE_100;
					} else {
						premiumAmount += riskType.getSumInsured() * PolicyConstants.COEFFICIENT_FIRE_DEFAULT;
					}
				} else if (PolicyConstants.THEFT.equalsIgnoreCase(riskType.getName())) {
					if (riskType.getSumInsured() >= 15) {
						premiumAmount += riskType.getSumInsured() * PolicyConstants.COEFFICIENT_THEFT_15;
					} else {
						premiumAmount += riskType.getSumInsured() * PolicyConstants.COEFFICIENT_THEFT_DEFAULT;
					}
				}
			}

		}
		return premiumAmount;

	}

}
