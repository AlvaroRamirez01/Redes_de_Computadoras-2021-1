from getmac import get_mac_address,getmac
from typing import cast
import requests
from decouple import config
import json as js

URL_1 = config("LOCALHOST", cast=str)
URL_2 = config("LOCALHOST", cast=str)
URL_3 = config("LOCALHOST", cast=str)


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




# ejemplos para usar la mac

''' eth_mac = get_mac_address(interface="eth0")
win_mac = get_mac_address(interface="Ethernet 3")
ip_mac = get_mac_address(ip="192.168.0.1")
ip6_mac = get_mac_address(ip6="::1")
host_mac = get_mac_address(hostname="localhost")
updated_mac = get_mac_address(ip="10.0.0.1", network_request=True) '''

# Changing the port used for updating ARP table (UDP packet)

#getmac.PORT = 44444  # Default: 55555
#print(getmac.get_mac_address(ip="192.168.0.1", network_request=True))

# Enabling debugging

#getmac.DEBUG = 2  # DEBUG level 2
#print(getmac.get_mac_address(interface="Ethernet 3"))

#import psutil

# gives a single float value
#psutil.cpu_percent()
# gives an object with many fields
#psutil.virtual_memory()
# you can convert that object to a dictionary 
#print (psutil.virtual_memory().total)
#memory = psutil.virtual_memory().total / (1024.0 ** 3)
#print(memory)