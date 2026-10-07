package frameworkpedidos.observer;
import frameworkpedidos.Pedido;

public class ObservadorAuditoria implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[AUDITORIA] Registrando log de processamento do pedido: " + pedido.getId() + " | Valor Final: R$ " + pedido.getValorFinal());
    }
}