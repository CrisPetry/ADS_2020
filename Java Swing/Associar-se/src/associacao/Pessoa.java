package associacao;


public class Pessoa {
    
    private String nome;
    private Cidade moradia;
    
    Pessoa(String nome, Cidade mora){
        this.nome = nome;
        this.moradia = mora;
    }

    public String getNome() {
        return nome;
    }

    public Cidade getMoradia() {
        return moradia;
    }
    
    
}
