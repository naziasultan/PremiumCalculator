Url- http://localhost:8080/premiumCalculator/calculate

Request-

{"policy":{      
    "policyNumber": "LV20-02-100000-5",
    "policyStatus": "REGISTERED,",
    "policyProducts":[{"productName": "House",
                         "policyAplliances":[
                             {"name":"TV", "riskType":[
                                                {"name":"fire", "sumInsured":100.00},
                                                {"name":"theft", "sumInsured":8.00} 
                                                ]} ]

    }]
}
}
  




Response-

2.28 EUR