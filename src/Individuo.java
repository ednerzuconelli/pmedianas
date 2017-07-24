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
               j = rand.nextInt(mapa.getTamanho()-1);
               
               if(!medianas.equals(mapa.vertices.get(j))){
                    medianas.add(mapa.vertices.get(j));
                    //calcular capacidade total.
                    i++;
               }
         }
     }
     
     public void calculaDistTotal(Mapa mapa){
          
    	 for (Vertices vertice :mapa.getVertices()){
    		 float menorDistancia=10000000;
    		 Vertices v = null;
    		 for (Vertices mediana : medianas){
        		  if (menorDistancia > vertice.distancia(mediana)){
        		     menorDistancia = vertice.distancia(mediana);
        		     v =mediana;
        		  }   
        	  }
    		 v.setCapacidadeUtilizada(vertice.getDemanda());
    		 distancia += menorDistancia;
          }
    	 for (Vertices mediana : medianas){
    		 System.out.println(mediana.getCapacidadeUtilizada());
    	 }
     }
     

}