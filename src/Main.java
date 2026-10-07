import frameworkpedidos.Pedido;
import frameworkpedidos.observer.ObservadorAuditoria;
import frameworkpedidos.observer.ObservadorEmail;
import frameworkpedidos.observer.ObservadorEstoque;
import frameworkpedidos.strategy.CalculadoraDesconto;
import frameworkpedidos.strategy.CalculadoraDescontoComum;
import frameworkpedidos.strategy.CalculadoraDescontoVip;
import frameworkpedidos.template.ProcessadorPedido;
import frameworkpedidos.template.ProcessadorPedidoDigital;
import frameworkpedidos.template.ProcessadorPedidoFisico;

public class Main {
    public static void main(String[] args) {
        CalculadoraDesconto descComum = new CalculadoraDescontoComum();
        CalculadoraDesconto descVip = new CalculadoraDescontoVip();

        Pedido jogoTabuleiro = new Pedido("PED-FIS-100", 200.0, "Rua das Flores, 123", "cliente@email.com");
        Pedido jogoDigital = new Pedido("PED-DIG-200", 150.0, null, "gamer@email.com");

        System.out.println("=== CENÁRIO 1: Pedido Físico + Cliente Comum ===");
        ProcessadorPedido processadorFisico = new ProcessadorPedidoFisico(descComum);

        processadorFisico.adicionarObservador(new ObservadorEstoque());
        processadorFisico.adicionarObservador(new ObservadorEmail());
        processadorFisico.adicionarObservador(new ObservadorAuditoria());

        processadorFisico.processar(jogoTabuleiro);


        System.out.println("\n=== CENÁRIO 2: Pedido Digital + Cliente VIP ===");
        ProcessadorPedido processadorDigital = new ProcessadorPedidoDigital(descVip);
        processadorDigital.adicionarObservador(new ObservadorEmail());
        processadorDigital.adicionarObservador(new ObservadorAuditoria());

        processadorDigital.processar(jogoDigital);
    }
}