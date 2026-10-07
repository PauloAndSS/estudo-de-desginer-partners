package frameworkpedidos.observer;
import frameworkpedidos.Pedido;

public class ObservadorEmail implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[EMAIL] Enviando e-mail para o cliente sobre o pedido: " + pedido.getId());
    }
}