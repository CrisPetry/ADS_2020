package associacao;

public class Cidade {
    
    private String nome;
    private String uf;
    
    Cidade(String nome, String uf){
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }
    
}
