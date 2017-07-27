

import java.util.ArrayList;
import java.util.List;

public class Genetico {
	
	public void geraPopulacaoInicial(Mapa mapa){
	   int i;
       List<Individuo> populacaoInicial = new ArrayList<>();
       for (i=0;i<10;i++){
           Individuo individuo = new Individuo();
           individuo.solucaoAleatoria(mapa);
           individuo.calculaDistTotal(mapa);
           populacaoInicial.add(individuo);
       
       }
	}    
}
