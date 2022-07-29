public class jogador{
    //atributos da classe
    
    private String nome;
    private int idade; 
    
    jogador(String n, int id){
        this.nome = n;
        this.idade = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCategoria(){
        if(idade==9){
            return "Infantil";
        }else if(idade==14){
            return "Infanto-juvenil";
        }else if(idade==17){
            return "Juvenil";
        }else if(idade==21){
            return "Sub-21";
        }else if(idade>21){
            return "Profissional";
        }else{
            return "Sem categoria";
        }
        
    }
}