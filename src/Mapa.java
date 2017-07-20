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
}