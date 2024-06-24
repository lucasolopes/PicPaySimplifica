# Desafio Back-end PicPay

Realizado o Desafio do PicPay :

https://github.com/PicPay/picpay-desafio-backend/blob/main/readme.md?plain=1

Nesse projeto foi realizado o desafio atentando a proposta realizada pelo proeto focando na realizacao da transferencia.


Realizando uma transferencia: 
```http request
POST /transections
Content-Type: application/json

{
	"senderId": 1,
	"receiverId": 2,
	"value": 10
}
```

Criando um usuario:
```http request
POST /user
Content-Type: application/json

{
	"nomeCompleto": "string",
	"email": "string",
	"senha": "string",
	"documento":"string",
	"saldo":BigDecimal,
	"tipo":"TypeUser"
}
```
TypeUser tem dois tipo sendo eles Comum e Logista.
