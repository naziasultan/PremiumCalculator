package com.proof.it.Policy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proof.it.policy.dto.Policy;
import com.proof.it.policy.dto.PolicyAplliance;
import com.proof.it.policy.dto.PolicyModel;
import com.proof.it.policy.dto.PolicyProduct;
import com.proof.it.policy.dto.RiskType;
import com.proof.it.policy.service.PremiumCalculatorService;

@SpringBootTest
@AutoConfigureMockMvc
class PremiumCalculatorServiceTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mvc;
	
	
	@Autowired
	protected ObjectMapper objectMapper;

	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	private PremiumCalculatorService mockService;

	@Test
	public void testCalculate() throws Exception {
		RiskType type1 = new RiskType();
		type1.setName("Fire");
		type1.setSumInsured(100.00);

		RiskType type2 = new RiskType();
		type2.setName("Theft");
		type2.setSumInsured(8.00);
		List<RiskType> riskList = new ArrayList<RiskType>();
		riskList.add(type1);
		riskList.add(type2);

		PolicyAplliance applicance = new PolicyAplliance();
		applicance.setName("TV");
		applicance.setRiskType(riskList);
		List<PolicyAplliance> policyApplicance = new ArrayList<PolicyAplliance>();
		policyApplicance.add(applicance);

		PolicyProduct policyProduct = new PolicyProduct();
		policyProduct.setPolicyAplliances(policyApplicance);
		List<PolicyProduct> policyProductList = new ArrayList<PolicyProduct>();
		policyProductList.add(policyProduct);

		Policy policy = new Policy();
		policy.setPolicyNumber("LV20-02-100000-5");
		policy.setPolicyStatus("REGISTERED");
		policy.setPolicyProducts(policyProductList);

		PolicyModel model = new PolicyModel();
		model.setPolicy(policy);

		mvc.perform(MockMvcRequestBuilders.post("/premiumCalculator/calculate").content(asJsonString(model))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")));

		
		Assertions.assertEquals("2.28 EUR", mockService.calculate(policy));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
