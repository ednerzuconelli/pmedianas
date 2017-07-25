import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
       mapa = lerAqruivo("E:/git/pmedianas/src/arquivos/Med 12");
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