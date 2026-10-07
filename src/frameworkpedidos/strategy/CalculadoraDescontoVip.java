package frameworkpedidos.strategy;

public class CalculadoraDescontoVip implements CalculadoraDesconto {
    @Override
    public double calcular(double valorOriginal) {
        return valorOriginal * 0.20;
    }
}