import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Individuo{
 
     private float distancia;   
     private float penalidade;
     List<Vertices> medianas = new ArrayList<Vertices>();
     
     public void solucaoAleatoria(Mapa mapa){
         int i = 0;
         int j;
         Random rand = new Random();
         
         while(i<mapa.getMedianas()){
               j = rand.nextInt(mapa.getTamanho());
               
               if(!medianas.contains(mapa.vertices.get(j))){
                    medianas.add(mapa.vertices.get(j));
                    //calcular capacidade total.
                    i++;
               }
         }
     }
     
     public void calculaDistTotal(Mapa mapa){
         for(Vertices v:mapa.vertices){
              
         }
     }
     

}