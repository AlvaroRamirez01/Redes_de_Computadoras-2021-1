from flask import Flask, jsonify, request
from utils import suma_peticion

app = Flask(__name__)

@app.route("/", methods=["GET"])
def recibe():
    return jsonify({"variable": 0})

@app.route("/suma", methods= ["POST"])
def suma():
    resultado = suma_peticion(request)
    return jsonify(resultado)

if __name__ == '__main__':
    app.run(host='localhost', debug=True)
    