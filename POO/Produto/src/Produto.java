
public class Produto {

    private int codigo;
    private String descricao;
    private double preco;
 

    Produto(int cod, String desc, double preco) {
        this.codigo = cod;
        this.descricao = desc;
        this.preco = preco;

    }

    public double getPreco() {
        return preco;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public double valorImposto(double taxa){
        double valorImp;
        valorImp = preco*taxa/100;
        return valorImp;
    }
}
