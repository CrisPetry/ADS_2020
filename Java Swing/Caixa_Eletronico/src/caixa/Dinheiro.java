package caixa;

public class Dinheiro {
    private int valor; 
    
    
    public Dinheiro(int valor){
        this.valor = valor;    
    }
    
    public Dinheiro(String v){
       this.valor = Integer.parseInt(v);
    }
    
    public int getNotas2(){
        if(valor>=2 || valor%8==0 || valor%9==0){
           int q2 = valor/2;
            valor = valor%2;
            return q2;
        }
        return 0;
    }
    
    public int getNotas5(){
        if(valor>=5 && valor%5==0 || valor%7==0 || valor%9==0){
           int q5 = valor/5;
            valor = valor%5;
            return q5;
        }
        return 0;
    }
    
    public int getNotas10(){
        if(valor>=10){
         int q10 = valor/10;
            valor = valor%10;
            return q10;
        }
        return 0;
    }
    
    public int getNotas20(){
        if(valor>=20){
         int q20 = valor/20;
            valor = valor%20;
            return q20;
        }
        return 0;
    }
    
    public int getNotas50(){
        if(valor>=50){
          int q50 = valor/50;
            valor = valor%50;
            return q50;
        }
        return 0;
    }
    
    public int getNotas100(){
        if(valor>=100){
           int q100 = valor/100;
            valor = valor%100;
            return q100;
        }
        return 0;
    }
    
    public int getNotas200(){
        if(valor>=200){
          int  q200 = valor/200;
            valor = valor%200;
            return q200;
        }
        return 0;
    }   
}