package com.proof.it.policy.utility;

import java.text.DecimalFormat;

public class PolicyUtility {

	public static String decimalToString(double amout)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(amout) + " EUR";
	}
}
