import requests
from flask import Flask, request
from flask.json import jsonify
from getmac import get_mac_address
from decouple import config

app = Flask(__name__)

URL_1 = config("LOCALHOST", cast=str)
URL_2 = config("INVITADO_1", cast=str)
URL_3 = config("INVITADO_2", cast=str)

mac = get_mac_address()
print(mac)
name = "alvaro"

@app.route("/", methods=["POST"])
def recibe():
    request_inicial = request.get_json()
    mensaje = "El ciclo de suma comenzo en:"+str(URL_1)
    print("Valor actualmente: " + str(request_inicial['valor']))
    print("Enviando al siguiente EndPoint..." + URL_1)
    if(request_inicial['valor'] < 50):
        # esta linea es la que va a cambiar dependiendo del servidor del usuario
        requests.post(URL_1, json={"valor": request_inicial['valor'] + 1, "mac": mac, "name": name})
    else:
        print("Se finalizo la suma")
        requests.post(URL_1 + "/finish", json={"valor": request_inicial['valor'], "mac": mac, "name": name})
        requests.post(URL_2 + "/finish", json={"valor": request_inicial['valor'], "mac": mac, "name": name})
        requests.post(URL_3 + "/finish", json={"valor": request_inicial['valor'], "mac": mac, "name": name})
    return jsonify({"message": mensaje, "statusCode": 200, "mac": mac, "name": name})

@app.route("/finish", methods=["POST"])
def finish():
    request_data = request.get_json()
    finish_valor = request_data['valor']
    finish_mac = request_data['mac']
    finish_name = request_data['name']
    print("El ciclo ha terminado con el valor: " + str(finish_valor))
    print("La mac de quien termino el ciclo es: " + str(finish_mac))
    print("El nombre de quien termino el ciclo es: " + str(finish_name))
    return jsonify({"message": "El ciclo ha terminado", "statusCode": 200})

if __name__ == '__main__':
    app.run("localhost",debug=True)
    