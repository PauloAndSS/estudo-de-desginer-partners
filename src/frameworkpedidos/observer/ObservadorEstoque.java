package frameworkpedidos.observer;
import frameworkpedidos.Pedido;

public class ObservadorEstoque implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[ESTOQUE] Dando baixa no estoque para o pedido: " + pedido.getId());
    }
}