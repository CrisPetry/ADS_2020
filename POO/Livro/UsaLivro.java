package Livro;

public class UsaLivro {

    public static void main(String args[]) {

        Livro x = new Livro(12345, "Coraline", 40.50);

        System.out.println("ISBN: " + x.getISBN());
        System.out.println("Título: " + x.getTitulo());
        System.out.println("Valor com Imposto: " + x.CalculaValorImposto(20));
        System.out.println("Valor final do Livro com desconto: " + (x.CalculaValorImposto(20) - x.CalculaValorFinal(10)));
    }

}
