import java.io.File;
import java.io.IOException;
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
		    	aux[cont]=Integer.parseInt(str[i]);
		    	cont+=1;
		    }
		}
    	return aux;
    }
    
    public static Mapa lerAqruivo(String arquivo){
    	try{
    		Integer[] linhaSeparado;
    		Mapa mapa = new Mapa();
    		Vertices vertices = new Vertices();
    		Scanner sc = new Scanner(new File(arquivo));
    		String linha = sc.nextLine();
    		linhaSeparado = tratarLeitura(linha.split(" "));
    		mapa.setTamanho(linhaSeparado[0]);
    		mapa.setMedianas(linhaSeparado[1]);
    		
    		while (sc.hasNextLine()){
    			linha = sc.nextLine();
        		linhaSeparado = tratarLeitura(linha.split("  "));
        		vertices.setX(linhaSeparado[0]);
        		vertices.setY(linhaSeparado[1]);
        		vertices.setCapacidade(linhaSeparado[2]);
        		vertices.setDemanda(linhaSeparado[3]);
        		mapa.vertices.add(vertices);
        	}

         }catch(IOException ioe){
            ioe.printStackTrace();
         }
        return mapa;
    }
    
    public static void main(String[] args){
       mapa = lerAqruivo("E:/git/pmedianas/src/arquivos/Med 12");
       
    }
    
    
}