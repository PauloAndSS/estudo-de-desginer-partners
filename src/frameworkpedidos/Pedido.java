package frameworkpedidos;

public class Pedido {
    private String id;
    private double valorOriginal;
    private double valorFinal;
    private String enderecoEntrega; // Para envio físico
    private String emailCliente;    // Para envio digital

    public Pedido(String id, double valorOriginal, String enderecoEntrega, String emailCliente) {
        this.id = id;
        this.valorOriginal = valorOriginal;
        this.enderecoEntrega = enderecoEntrega;
        this.emailCliente = emailCliente;
    }

    public String getId() { return id; }
    public double getValorOriginal() { return valorOriginal; }
    public double getValorFinal() { return valorFinal; }
    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }

    public String getEnderecoEntrega() { return enderecoEntrega; }
    public String getEmailCliente() { return emailCliente; }
}