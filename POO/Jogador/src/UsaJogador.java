public class UsaJogador {
    public static void main(String[] args){
        jogador x = new jogador("Cristian", 8);
        jogador z = new jogador("Juca Bala", 12);
        jogador y = new jogador("Guto", 21);
        
        System.out.println("\nNome: " + x.getNome() + "\nCategoria: " + x.getCategoria());
        System.out.println("\nNome: " + z.getNome() + "\nCategoria: " + z.getCategoria());
        System.out.println("\nNome: " + y.getNome() + "\nCategoria: " + y.getCategoria());
    }
}
