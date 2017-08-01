import java.util.ArrayList;
import java.util.List;

class Mapa{
    
    List<Vertices> vertices = new ArrayList<Vertices>();
    private int tamanho, medianas;
    
    public int getMedianas(){
        return this.medianas;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }

	public List<Vertices> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertices> vertices) {
		this.vertices = vertices;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setMedianas(int medianas) {
		this.medianas = medianas;
	}
	
	public void listarMapa() {
		for(Vertices v: vertices) {
			System.out.println(v.getX()+" "+v.getY()+" "+v.getCapacidade()+v.getCapacidadeUtilizada());
		}
	}
	

    
}