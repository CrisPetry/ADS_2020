
public class UsaProduto {
    public static void main(String [] args){
        
        Produto p = new Produto(126325, "Parafuso", 40.50);
        
        System.out.println("Descrição: " + p.getDescricao());
        System.out.println("Preço: " + p.getPreco());
        System.out.println("Valor do imposto: " + p.valorImposto(50));
    }
}
