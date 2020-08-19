# spring-boot
1.start the service-registry(port 8082)
2.start the cloud-config-server(port 8086)
3.start cloud-gateway(port 8083 ) and order-service(port 8081),payment-service(port 8080), hystrix-dashboar(port 8085)and spring-security-jwt(port 8087)


POST - http://localhost:8083/order/bookorder
request -{
	"order":{
		"name":" mobile",
		"qty":5,
		"price":90000
		
	},
	"payment":{}
}

response-
{
    "order": {
        "id": 17,
        "name": " mobile",
        "price": 90000.0,
        "qty": 5
    },
    "transactionId": "c0068679-a102-4012-8044-76d1b9c68390",
    "amount": 90000.0,
    "response": "payment unsuccessful .Try later"
}

GET - http://localhost:8083/payment/history/17

response-
{
    "paymentId": 1,
    "paymentStatus": "false",
    "transactionId": "3bdc53d6-3f6d-4a6e-9f5c-2bdc9ca3157f",
    "orderId": 17,
    "amount": 90000.0
}

POST - http://localhost:8083/user/regis

request-
{
    "id":4,
    "userName":"nishuu",
    "password":"1234",
    "email":"123@g.com"
}

response -
{
    "id":4,
    "userName":"nishuu",
    "password":"1234",
    "email":"123@g.com"
}

POST - http://localhost:8083/user/login

request-
{
    "userName":"nishuu",
    "password":"1234"
}

response-
{
  JWT TOKEN e.g.(eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaXNodXUiLCJleHAiOjE1OTc4MDA2NTUsImlhdCI6MTU5Nzc2NDY1NX0.hjoRLz_X7Wl42aiN8DSx3wygyF412ynyIGV4Xg_NvfU)
}

GET- http://localhost:8083/user/check
pass token above in headers
AUTHORIZATION : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaXNodXUiLCJleHAiOjE1OTc4MDA2NTUsImlhdCI6MTU5Nzc2NDY1NX0.hjoRLz_X7Wl42aiN8DSx3wygyF412ynyIGV4Xg_NvfU

