#!/bin/python3

from flask import Flask
from flask.json import jsonify

app = Flask(__name__)

@app.route("/")
def hola():
    response_saluda = {"saluda":"hola"}
    return jsonify(response_saluda)

@app.route('/saludo/<username>')
def saludo(username):
    response_mensaje = "Hola %s, bienvenido a la pagina de prueba" % username
    return response_mensaje

if __name__== "_main":
    app.run(host="localhost", debug=True)