import java.sql.SQLException;
import java.util.List;

import dao.BandaDao;
import modelo.Banda;
public class TesteLista {
	public static void main (String[] args) throws SQLException {
		BandaDao dao = new BandaDao();
		List<Banda> bandas = dao.getListaBandas();
		 for (Banda banda : bandas) {
	          System.out.println("Nome: " + banda.getNome());
	          System.out.println("Genero: " + banda.getGenero());
	      
	}
}
}
