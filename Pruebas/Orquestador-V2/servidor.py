from flask import Flask
from flask.json import jsonify

app = Flask(__name__)

@app.route("/")
def inicio():
    response_saluda = {"saluda":"hola"}
    return jsonify(response_saluda)


if __name__=="__main__":
    app.run(debug=True)