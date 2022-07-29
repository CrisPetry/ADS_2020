public class SelectionSort{
    public static void main (String [] args){
        
        int v [] = {640, 25, 689, 1, 69, 0, 58};
        int menor;
        
        
        for(int i=0; i<v.length-1; i++){
            menor = i;
            
            for (int j=i+1; j<v.length; j++){
                if(v[menor]>v[j]){
                    menor = j;
                }
            }
            
            if(menor!=i){
                int aux = v[i];
                v[i] = v[menor];
                v[menor] = aux;
            }
        System.out.println(v[i]);
        }
    }
}
    