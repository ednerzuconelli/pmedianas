import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Main{
    //min distancia entre o somatorio dos pontos à mediana
    //somatorio do peso < capacidadde da Mediana
    
    static Mapa mapa;
    
    public static Integer[] tratarLeitura(String[] str){
		Integer[] aux={0,0,0,0};
		int i,cont;
		cont =0;
		int tam = str.length;
		for (i=0; i<tam; i++){
		    if (!String.valueOf(str[i]).isEmpty()){
		    	aux[cont]=Integer.parseInt(str[i].trim());
		    	cont+=1;
		    }
		}
    	return aux;
    }
    
    public static Mapa lerAqruivo(String arquivo){
    	Mapa mapas = new Mapa();
    	try{
    		Integer[] linhaSeparado;
    		Scanner sc = new Scanner(new File(arquivo));
    		String linha = sc.nextLine();
    		linhaSeparado = tratarLeitura(linha.split(" "));
    		mapas.setTamanho(linhaSeparado[0]);
    		mapas.setMedianas(linhaSeparado[1]);
    	
    		while (sc.hasNextLine()){
    			linha = sc.nextLine();
        		linhaSeparado = tratarLeitura(linha.split("  "));
        		Vertices vertices = new Vertices();
        		vertices.setX(linhaSeparado[0]);
        		vertices.setY(linhaSeparado[1]);
        		vertices.setCapacidade(linhaSeparado[2]);
        		vertices.setDemanda(linhaSeparado[3]);
        		mapas.vertices.add(vertices);
        	}

         }catch(IOException ioe){
            ioe.printStackTrace();
         }
        return mapas;
    }
    
    public static void main(String[] args){
       mapa = lerAqruivo("src/arquivos/Med 12");
       Genetico genetico = new Genetico();
       genetico.geraPopulacaoInicial(mapa);
       genetico.setTaxaMutacao(10);
      // Random gerador = new Random();
       
       while (genetico.populacaoInicial.get(0).getPontos()!=genetico.populacaoInicial.get(0).getDistanciaTotal()){
           genetico.cruzamento(mapa);
          /* if (genetico.getTaxaMutacao()>gerador.nextInt(100)){
        	   genetico.mutacao(mapa,null);
           }*/
       }  
    }
    
    
}