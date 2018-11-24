package modelo;

public class Local {
	private Long id;
	   private String local;
	   private int capacidade;
	   private int local_idlocal;
	   
	   
	   public void setLocal_Idlocal(int idlocal) {
		   this.local_idlocal = idlocal;
	   }
	   
	   public int getIdLocal() {
		   return this.local_idlocal;
	   }
	   
	   public String getLocal() {
           return this.local;
       }
       public void setLocal(String local) {
           this.local = local;
       }
       
       
       public void setCapacidade(int capacidade) {
       	this.capacidade = capacidade;
       }
       
       public int getCapacidade() {
       	return this.capacidade;
       }
       public Long getId() {
           return this.id;
       }
       public void setId(Long novo) {
           this.id = novo;
       }
	public void setCapacidade(String parameter) {
		// TODO Auto-generated method stub
		
	}
}
