#!/bin/python3

from flask import Flask
from flask.json import jsonify
from flask.scaffold import _matching_loader_thinks_module_is_package
from flask.wrappers import Request

app = Flask(__name__)

@app.route("/")
def hola():
    response_saluda = {"saluda":"hola"}
    return jsonify(response_saluda)

@app.route('/saludo/<username>')
def saludo(username):
    response_mensaje = "Hola %s, bienvenido a la pagina de prueba" % username
    return response_mensaje

@app.route('/suma',methods=["POST"])
def suma():
    valor = request.json.get("variable")
    valor = valor +1
    return jsonify({"variable", valor})
    

if __name__== "__main__":
    app.run(host="localhost", debug=True)