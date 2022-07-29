
package heranca;

public class Aluno extends Pessoa{
    private String curso;
    
    Aluno(String nome, double altura, double peso, String curso) {
        super(nome, altura, peso);
        this.curso = curso;
    }

    void exibeDados() {
        super.exibeDados();
        System.out.println("Curso: " + curso);
        
    }
    
}
