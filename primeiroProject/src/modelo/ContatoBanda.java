package modelo;

import java.util.Calendar;

public class ContatoBanda {

        private Long id;
        private String nome;
        private String genero;
        private String local;
        private int capacidade;
        private Calendar data;
		private String dataTexto;

        // métodos get e set para id, nome, email, endereço e dataNascimento

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

        public String getLocal() {
            return this.local;
        }
        public void setLocal(String local) {
            this.local = local;
        }

        public Long getId() {
            return this.id;
        }
        public void setId(Long novo) {
            this.id = novo;
        }
        

        public Calendar getData() {
            return this.data;
        }
        public void setData(Calendar data) {
            this.data = data;
        }
		public void setData(String dataTexto) {
		this.dataTexto = dataTexto;
			
		}
		 public void setCapacidade(int capacidade) {
		       	this.capacidade = capacidade;
		       }
		       
		       public int getCapacidade() {
		       	return this.capacidade;
		       }
			public void setCapacidade(String string) {
            				
			}
       
    }
        