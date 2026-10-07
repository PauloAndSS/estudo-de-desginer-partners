package frameworkpedidos.strategy;

public class CalculadoraDescontoComum implements CalculadoraDesconto {
    @Override
    public double calcular(double valorOriginal) {
        return valorOriginal * 0.05;
    }
}