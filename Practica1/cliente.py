from getmac import get_mac_address
import requests
import psutil
import json as js
from typing import cast
from decouple import config


URL_1 = config("LOCALHOST", cast=str)
URL_2 = config("INVITADO1", cast=str)
URL_3 = config("INVITADO2", cast=str)

def consultarRAM():
    memory = psutil.virtual_memory().total / (1024.0 ** 3)
    print(memory)
    return memory

def getMAC():
    return get_mac_address()