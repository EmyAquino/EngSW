

class CalcularFrete:
    def calcular(self, tipo: str, peso: float):
        if tipo == "SEDEX":
            return peso * 10.0
        elif tipo == "PAC":
            return peso * 5.0