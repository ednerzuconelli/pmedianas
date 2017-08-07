
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


class Main{
    
    static Mapa mapa;
    
    public static Integer[] tratarLeitura(String[] str){
		Integer[] aux={0,0,0,0};
		int i,cont;
		cont =0;
		int tam = str.length;
		for (i=0; i<tam; i++){
		    if (!String.valueOf(str[i]).isEmpty()){
		    	aux[cont]=(int)Math.floor(Float.parseFloat(str[i].trim()));
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
            sc.close();
         }catch(IOException ioe){
            ioe.printStackTrace();
         }
        return mapas;
    }
    
    public static void main(String[] args){
    	try{
	    	PrintWriter out = new PrintWriter(new FileWriter("src/saida.out"));
	    	BufferedWriter bw = new BufferedWriter(out);
	    	File arquivos[];
	    	String arquivo = "src/arquivos/SJC1.dat";
	    	File diretorio = new File("src/arquivos");
	    	arquivos = diretorio.listFiles();
	    	//for(int j = 0; j < arquivos.length; j++){
	    	  // arquivo = arquivos[j].getPath();
	    	   mapa = lerAqruivo(arquivo);
	    	   bw.write(arquivo);
	    	   bw.newLine();
	    	   Genetico genetico = new Genetico();
		       genetico.geraPopulacaoInicial(mapa);
		       genetico.setTaxaMutacao(30);
		       int i=0;
		       float dist=0.0f;
		       while (genetico.populacaoInicial.get(0).getPontos()!=genetico.populacaoInicial.get(0).getDistanciaTotal()){
		   		 System.out.println("distância Mínima = "+genetico.populacaoInicial.get(0).getDistanciaTotal()+" Pontos = "+genetico.populacaoInicial.get(0).getPontos());
		   		 //bw.write("distância Mínima = "+genetico.populacaoInicial.get(0).getDistanciaTotal()+" Pontos = "+genetico.populacaoInicial.get(0).getPontos());
		    	 //bw.newLine();
				 System.out.println("");
	
		    	   genetico.cruzamento(mapa);
		           
		        
		           if(dist==0.0f) {
		        	   dist = genetico.populacaoInicial.get(0).getPontos();
		           }else {
		        	   if(dist==genetico.populacaoInicial.get(0).getPontos()) {
		        		   i++;
		        	   }else {
		        		   dist = genetico.populacaoInicial.get(0).getPontos();
		        		   i =0;
		        	   }
		        	   
		        	   if(i==10) {
		        		   genetico.buscaLocal(mapa);
		        		   i=0;
		        	   }
		           }
		       } 
		       System.out.println("distância Mínima = "+genetico.populacaoInicial.get(0).getDistanciaTotal()+" Pontos = "+genetico.populacaoInicial.get(0).getPontos());
		    //}
	    	bw.flush();
	    	bw.close();
    	}catch(IOException ex){
    		  ex.printStackTrace();
    	}	
    }
    
}