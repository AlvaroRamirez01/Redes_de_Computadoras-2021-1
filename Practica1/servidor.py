from flask import Flask, json, jsonify, request
from utils import suma_peticion

app = Flask(__name__)

@app.route("/", methods=["GET"])
def recibe():
    return jsonify({"variable": 0})

@app.route("/suma", methods= ["POST"])
def suma():
    resultado = suma_peticion(request)
    print('servidor respondiendo ' + str(resultado.get("variable")))
    return jsonify(resultado)

if __name__ == '__main__':
    app.run(debug=True)
    