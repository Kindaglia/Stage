import requests

azienda = "http://localhost:8080/"
username = "adimin"
password = "password"

# post azieda
aziedaJson = {
	"nome": "tesla",
	"ragSociale": "ragSociale",
	"logo": "logo",
	"piva": "piva"
}

x = requests.post(url,  auth=(username, password),json = aziedaJson)