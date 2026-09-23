from abc import ABC, abstractmethod


# 1. DEFINIR A FAMÍLIA / INTERFACE (Contrato comum)
class EstrategiaFrete(ABC):

    @abstractmethod
    def calcular(self, peso: float) -> float:
        pass


# 2. ENCAPSULAR EM CLASSES SEPARADAS (Estratégias Concretas)
class FreteSedex(EstrategiaFrete):

    def calcular(self, peso: float) -> float:
        return peso * 10.0


class FretePac(EstrategiaFrete):

    def calcular(self, peso: float) -> float:
        return peso * 5.0


# 3. TORNAR INTERCAMBIÁVEL (O Contexto)
class CalculadoraFrete:

    def __init__(self, estrategia: EstrategiaFrete):
        self.estrategia = estrategia  # Pode ser substituída facilmente!

    def executar_calculo(self, peso: float) -> float:
        return self.estrategia.calcular(peso)


# EXECUÇÃO
# Trocamos o comportamento apenas substituindo a classe, sem alterar a Calculadora!
calculadora = CalculadoraFrete(FreteSedex())
print(calculadora.executar_calculo(2.0))  # Saída: 20.0

# Intercambiável:
calculadora.estrategia = FretePac()
print(calculadora.executar_calculo(2.0))  # Saída: 10.0


