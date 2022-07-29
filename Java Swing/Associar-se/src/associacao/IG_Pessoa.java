package associacao;

import javax.swing.JOptionPane;

public class IG_Pessoa {
    
  
    
    public static void main(String [] args){
        int v;
        do{
            
        String nome = JOptionPane.showInputDialog(null, "Informe o nome: ", "NOME", 1);
        String cidade = JOptionPane.showInputDialog(null, "Informe a cidade: ", "CIDADE", 1);
        
        Object[] ufOpcoes = {"RS", "SC", "PR", "RJ", "SP", "ES", "TO"};
        String uf = (String)JOptionPane.showInputDialog(null, "Estado", "UF",1, null, ufOpcoes, null);
        
        
        Pessoa p1 = new Pessoa(nome, new Cidade(cidade, uf));
        
        JOptionPane.showMessageDialog(null,"Dados: \n" + p1.getNome() + " - "
                                                       + p1.getMoradia().getNome() + " - "
                                                       + p1.getMoradia().getUf(), "Resultado", 1);
        
        Object[] opcoes = {"Sim", "Não"};
        
       v = JOptionPane.showOptionDialog(null,"Continuar?", null, JOptionPane.YES_NO_OPTION,
                                          JOptionPane.QUESTION_MESSAGE,null, opcoes, opcoes[0]);
    
       }while(v==0);
    }
    
    
}
