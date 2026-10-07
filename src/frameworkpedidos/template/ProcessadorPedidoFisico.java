package frameworkpedidos.template;
import frameworkpedidos.Pedido;
import frameworkpedidos.strategy.CalculadoraDesconto;

public class ProcessadorPedidoFisico extends ProcessadorPedido {

    public ProcessadorPedidoFisico(CalculadoraDesconto calculadoraDesconto) {
        super(calculadoraDesconto);
    }

    @Override
    protected void validar(Pedido pedido) {
        System.out.println("[FÍSICO] Iniciando validação...");
        if (pedido.getEnderecoEntrega() == null || pedido.getEnderecoEntrega().trim().isEmpty()) {
            throw new IllegalArgumentException("Falha na validação: Pedidos físicos exigem um endereço de entrega.");
        }
        System.out.println("[FÍSICO] Endereço validado: " + pedido.getEnderecoEntrega());
    }

    @Override
    protected void calcularTotal(Pedido pedido) {
        double desconto = calculadoraDesconto.calcular(pedido.getValorOriginal());
        double frete = 35.0;
        pedido.setValorFinal((pedido.getValorOriginal() - desconto) + frete);
        System.out.println("[FÍSICO] Cálculo -> Original: R$ " + pedido.getValorOriginal() + " | Desconto: -R$ " + desconto + " | Frete: +R$ " + frete + " | Total: R$ " + pedido.getValorFinal());
    }
}