package tec;

public class PassagerStandard {
	
	private String nomPassager;
	private int destination;
	

	public PassagerStandard(String nom, int numeroArret)
	{
		this.nomPassager = nom;
		this.destination = numeroArret;
	}
	
	  //Accesseurs
	  public String getNomPassager() {return nomPassager;}
	  public void setNomPassager(String nomPassager) {this.nomPassager = nomPassager;}
	  public int getDestination() {return destination;}
	  public void setDestination(int destination) {this.destination = destination;}

	  public void monterDans(Autobus autobus)
	  {
		  
	  }
	



}
