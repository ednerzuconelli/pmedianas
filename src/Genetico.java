

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Genetico {
	List<Individuo> populacaoInicial;
	int tamanhoMediana;
	
	public void geraPopulacaoInicial(Mapa mapa){
	   int i;
	   tamanhoMediana =mapa.getMedianas();
	   populacaoInicial = new ArrayList<>();	
       for (i=0;i<10;i++){
           Individuo individuo = new Individuo();
           individuo.solucaoAleatoria(mapa);
           individuo.calculaDistTotal(mapa);
           populacaoInicial.add(individuo);
       }
       Collections.sort(populacaoInicial, idComparator);
       
	}  

	public  Comparator<Individuo> idComparator = new Comparator<Individuo>() {

		@Override
		public int compare(Individuo o1, Individuo o2) {
			// TODO Auto-generated method stub
			return  o1.getDistanciaTotal() < o2.getDistanciaTotal()?-1:
				o1.getDistanciaTotal() > o2.getDistanciaTotal()?1:
					0;
		}

	};
	
	public List<Individuo> selecao(){
		return populacaoInicial.subList(0, 1);
		
	}
		
	public void cruzamento(){
		List<Individuo> pais = selecao();
		Individuo filho = new Individuo();
		
		for(Vertices v: pais.get(0).medianas){
			if(pais.get(1).medianas.contains(v)){
				filho.medianas.add(v);
			}
		}
		int i = 0;
		int j=0;
		while(filho.medianas.size()<tamanhoMediana){
			if (!filho.medianas.contains(pais.get(0).medianas.get(i))){
				filho.medianas.add(pais.get(0).medianas.get(i));
				i+=1;
			}else i+=1;
			if (!filho.medianas.contains(pais.get(1).medianas.get(j))){
				filho.medianas.add(pais.get(1).medianas.get(j));
				j+=1;
			}else j+=1;
		}
		
	}
}
