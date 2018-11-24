package modelo;

//import java.sql.Date;
import java.util.Calendar;
import java.util.Date;
public class Show {
	 private Long id;
	  private Date data;
	  private String dataTexto;
   private int local_idlocal;
	   
	   
	   public void setLocal_Idlocal(int idlocal) {
		   this.local_idlocal = idlocal;
	   }
	   
	   public int getIdLocal() {
		   return this.local_idlocal;
	   }

	  public Date getData() {
          return this.data;
      }
      public void setData(Date data) {
          this.data = data;
      }
		public void setData(String dataTexto) {
		this.dataTexto = dataTexto;
}
		  public Long getId() {
	            return this.id;
	        }
	        public void setId(Long novo) {
	            this.id = novo;
	        }
}
