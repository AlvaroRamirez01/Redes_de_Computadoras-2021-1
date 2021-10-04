import typing
from typing import cast
import requests 
from decouple import config 

URL=config("LOCALHOST", cast=str)

response = requests.post(URL)

print(response.json())
