package modelo;

import java.util.ArrayList;

import java.util.List;



public class Banda {
	
	  private Long id;
	  private String nome;
      private String genero;
     // private ArrayList<Show> show;
      
     public static void escolheBanda(TesteEnum opcao) {
    	 if (opcao == TesteEnum.FORRO) {
    		 System.out.println("FORRÓ");
    	 }
    	 
    	 else if (opcao == TesteEnum.ROCK) {
    		 System.out.println("ROCK");
    	 }
    	 
    	 else if (opcao == TesteEnum.AXE) {
    		 System.out.println("AXE");
    	 }
     }
     
     public static void main(String[] args) {
    	 escolheBanda(TesteEnum.AXE); 
     }
      
      
      public String getNome() {
          return this.nome;
      }
      public void setNome(String nome) {
          this.nome = nome;
      }

      public String getGenero() {
          return this.genero;
      }
      public void setGenero(String genero) {
          this.genero = genero;
      }
	  public Long getId() {
            return this.id;
        }
        public void setId(Long novo) {
            this.id = novo;
        }
		public void setData(String dataTexto) {
			// TODO Auto-generated method stub
			
		}public void addAttribute(String string, List<TesteEnum> list) {
			// TODO Auto-generated method stub
			
		}
		public char[] getBandas() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
