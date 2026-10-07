package frameworkpedidos.template;

import frameworkpedidos.Pedido;
import frameworkpedidos.observer.ObservadorPedido;
import frameworkpedidos.strategy.CalculadoraDesconto;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessadorPedido {
    private List<ObservadorPedido> observadores = new ArrayList<>();

    protected CalculadoraDesconto calculadoraDesconto;

    public ProcessadorPedido(CalculadoraDesconto calculadoraDesconto) {
        this.calculadoraDesconto = calculadoraDesconto;
    }

    public void adicionarObservador(ObservadorPedido observador) {
        this.observadores.add(observador);
    }

    public final void processar(Pedido pedido) {
        validar(pedido);
        calcularTotal(pedido);
        notificar(pedido);
    }

    protected abstract void validar(Pedido pedido);
    protected abstract void calcularTotal(Pedido pedido);

    private void notificar(Pedido pedido) {
        for (ObservadorPedido obs : observadores) {
            obs.atualizar(pedido);
        }
    }
}