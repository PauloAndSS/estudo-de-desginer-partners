package frameworkpedidos.template;
import frameworkpedidos.Pedido;
import frameworkpedidos.strategy.CalculadoraDesconto;

public class ProcessadorPedidoDigital extends ProcessadorPedido {

    public ProcessadorPedidoDigital(CalculadoraDesconto calculadoraDesconto) {
        super(calculadoraDesconto);
    }

    @Override
    protected void validar(Pedido pedido) {
        System.out.println("[DIGITAL] Iniciando validação...");
        if (pedido.getEmailCliente() == null || !pedido.getEmailCliente().contains("@")) {
            throw new IllegalArgumentException("Falha na validação: Pedidos digitais exigem um e-mail válido para entrega do link.");
        }
        System.out.println("[DIGITAL] E-mail validado: " + pedido.getEmailCliente());
    }

    @Override
    protected void calcularTotal(Pedido pedido) {
        double desconto = calculadoraDesconto.calcular(pedido.getValorOriginal());
        pedido.setValorFinal(pedido.getValorOriginal() - desconto);
        System.out.println("[DIGITAL] Cálculo -> Original: R$ " + pedido.getValorOriginal() + " | Desconto: -R$ " + desconto + " | Frete: Isento | Total: R$ " + pedido.getValorFinal());
    }
}