package Livro;

public class Livro {

    private int ISBN;
    private String titulo;
    private double valor;

    Livro(int ISBN, String titulo, double valor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.valor = valor;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getValor() {
        return valor;
    }

    public double CalculaValorImposto(double imp) {
        double valorImp;
        valorImp = valor * imp / 100;
        double novoValor;
        novoValor = valor + valorImp;
        return novoValor;
    }

    public double CalculaValorFinal(double taxa) {
        double valorTaxaDesc;
        valorTaxaDesc = valor * taxa / 100;
        return valorTaxaDesc;
    }
}
