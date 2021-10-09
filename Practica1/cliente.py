from getmac import get_mac_address
import requests
import psutil
import json as js
from typing import cast
from decouple import config


URL_1 = config("LOCALHOST", cast=str)
URL_2 = config("INVITADO1", cast=str)
URL_3 = config("INVITADO2", cast=str)

def checaRAM():
    ram1 = psutil.virtual_memory().total / (1024.0 ** 3)
    ram2 = requests.get(URL_2 + "/get-ram").json()['ram']
    ram3 = requests.get(URL_3 + "/getRam").json()['ram']
    response = ""
    if(ram1 >= ram2 and ram1 >= ram3):
        response = requests.post(
            URL_1, json={"valor": 0, "mac": mac, "name": "Alvaro"})
    elif(ram2 > ram1 and ram2 > ram3):
        response = requests.post(
            URL_2, json={"valor": 0, "mac": mac, "name": "Eric"})
    else:
        response = requests.post(
            URL_3, json={"valor": 0, "mac": mac, "name": "Dan"})
    print(response.json())

def getMAC():
    return get_mac_address()

checaRAM()
getMAC()