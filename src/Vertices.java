

class Vertices{
    
    private int x,y,capacidade,demanda;
    
    public float distancia(Vertices proximo){
        float disX = proximo.getX() - this.getX();
        disX = disX * disX;
        
        float disY = proximo.getY() - this.getY();
        disY = disY * disY;

        disX = disX + disY;
        disX = (float) Math.sqrt(disX);
        
        return disX;
    }
    
    private int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
    
    public void setDemanda(int demanda){
        this.demanda = demanda;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getDemanda(){
        return this.demanda;
    }
    
    public int getCapacidade(){
        return this.capacidade;
    }
    
    
}