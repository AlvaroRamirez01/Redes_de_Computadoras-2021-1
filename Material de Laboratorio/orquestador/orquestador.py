from typing import cast
import requests
from decouple import config
import json as js

URL_1 = config("LOCALHOST", cast=str)
URL_2 = config("LOCALHOST", cast=str)


i = 0
valor = 0
while i < 50:
    if i %2 == 0:
        response = requests.post(URL_1+"/suma", json={"variable": valor})
        valor = response.json().get("variable")
        print(valor)
        i = i + 1
    else:
        response = requests.post(URL_2+"/suma", json={"variable": valor})
        valor = response.json().get("variable")
        print(valor)
        i = i + 1