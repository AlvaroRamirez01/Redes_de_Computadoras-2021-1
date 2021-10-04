def suma_peticion(request):
    valor = request.json.get("variable")
    valor = valor + 1
    return {"variable": valor}