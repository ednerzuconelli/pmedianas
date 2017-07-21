import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main{
    //min distancia entre o somatorio dos pontos à mediana
    //somatorio do peso < capacidadde da Mediana
    
    static Mapa mapa;
    
    public static String[] corrigeLeitura(String[] str){
		String[] aux={"","","",""};
		int i,cont;
		cont =0;
		int tam = str.length;
		for (i=0; i<tam; i++){
		    if (!String.valueOf(str[i]).isEmpty()){
		    	aux[cont]=str[i];
		    	cont+=1;
		    }
		}
    	return aux;
    }
    
    public static Mapa lerAqruivo(String arquivo){
    	try{
            Scanner sc = new Scanner(new File(arquivo));
    		String linha = sc.nextLine();
    		String[] linhaSeparado = linha.split(" ");
    		Mapa mapa = new Mapa();
    		Vertices vertices = new Vertices();
    		linhaSeparado = corrigeLeitura(linhaSeparado);
    		int aux =Integer.parseInt(linhaSeparado[0].trim());
    		mapa.setTamanho(aux);
    		aux =Integer.parseInt(linhaSeparado[1].trim());
    		mapa.setMedianas(aux);
    		
    		while (sc.hasNextLine()){
    			linha = sc.nextLine();
        		linhaSeparado = linha.split("  ");
        		linhaSeparado = corrigeLeitura(linhaSeparado);
        		
        		aux =Integer.parseInt(linhaSeparado[0].trim());
        		vertices.setX(aux);
        		aux =Integer.parseInt(linhaSeparado[1].trim());
        		vertices.setY(aux);
        		aux =Integer.parseInt(linhaSeparado[2].trim());
        		vertices.setCapacidade(aux);
        		aux =Integer.parseInt(linhaSeparado[3].trim());
        		vertices.setDemanda(aux);
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