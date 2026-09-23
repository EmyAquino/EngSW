# Arquivo: com_strategy.py

from abc import ABC, abstractmethod

# Passo A: Criação de uma base abstrata / Interface (Estratégia)
class EstrategiaPagamento(ABC):

    @abstractmethod
    def pagar(self, valor: float):
        pass


# Passo B: Criação de classes específicas (Estratégias Concretas)
class PagamentoCartao(EstrategiaPagamento):

    def pagar(self, valor: float):
        print(
            f"Processando R$ {valor:.2f} via cartão de crédito. Validando CVV..."
        )


class PagamentoPix(EstrategiaPagamento):

    def pagar(self, valor: float):
        print(f"Processando R$ {valor:.2f} via PIX. Gerando QR Code...")


# Passo C: A classe que usa a estratégia (O Contexto)
class CarrinhoDeCompras:

    def __init__(self):
        self._estrategia = None  # Começa sem estratégia definida

    def set_estrategia(self, estrategia: EstrategiaPagamento):
        self._estrategia = estrategia

    def finalizar_compra(self, valor: float):
        if self._estrategia:
            self._estrategia.pagar(valor)  # Chamada corrigida usando _estrategia
        else:
            print("Erro: Escolha uma forma de pagamento!")


# EXECUÇÃO
if __name__ == "__main__":
    print("--- Executando o modelo com Strategy ---")

    # Instanciando o contexto
    carrinho = CarrinhoDeCompras()

    # 1. Tentativa sem definir estratégia
    carrinho.finalizar_compra(100.50)

    # 2. Definindo a estratégia como PIX
    print("\n[Cliente selecionou PIX]:")
    carrinho.set_estrategia(PagamentoPix())
    carrinho.finalizar_compra(100.50)

    # 3. Alterando a estratégia para Cartão sem mexer no Carrinho
    print("\n[Cliente alterou para Cartão de Crédito]:")
    carrinho.set_estrategia(PagamentoCartao())
    carrinho.finalizar_compra(250.00)