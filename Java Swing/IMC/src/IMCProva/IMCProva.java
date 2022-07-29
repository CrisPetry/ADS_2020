package IMCProva;


public class IMCProva {

    private double peso, altura;

    public IMCProva(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double getImc() {
        return peso / (altura * altura);
    }
}
