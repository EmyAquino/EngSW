# Modelo padrão

class ProcessadordePagamentos:
    def processar_pagamento(self, tipo: str, valor: float):
        if tipo == "Cartão":
            print("Processando pagamento via cartão de crédito. Validando CVV...")
        elif tipo == "PayPal":
            print("Processando valor via PayPak. Redirecionando...")
        elif tipo == "PIX":
            print("Processando pagamento via PIX. Gerando QR Code")

