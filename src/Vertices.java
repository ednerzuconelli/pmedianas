

class Vertices{
    
    private int x,y,capacidade,demanda,capacidadeUtilizada;

    
    public float distancia(Vertices proximo){
        float disX = proximo.getX() - this.getX();
        disX = disX * disX;
        
        float disY = proximo.getY() - this.getY();
        disY = disY * disY;

        disX = disX + disY;
        disX = (float) Math.sqrt(disX);
        
        return disX;
    }
    
    
    public int getCapacidadeUtilizada(){
        return this.capacidadeUtilizada;
    }
    
    public void limparCapacidadeUtilizada(){
        this.capacidadeUtilizada = 0;
    }
    
    public void setCapacidadeUtilizada(int cap){
        this.capacidadeUtilizada = this.capacidadeUtilizada + cap;
    }
    
    public int getY() {
		// TODO Auto-generated method stub
		return this.y;
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