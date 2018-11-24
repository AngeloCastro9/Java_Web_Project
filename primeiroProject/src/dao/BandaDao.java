package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Banda;
import modelo.Local;
import modelo.Show;
import modelo.TesteEnum;

public class BandaDao {
	private Statement st;
	private ResultSet rs;
	 static Connection connection;
	 public void BandaDao1() throws SQLException {
		 connection = ConnectionFactory.getConnection();
	 }
	public BandaDao(HttpServletRequest request, HttpServletResponse response) {
		this.connection = (Connection) request.getAttribute("conexao");
	}
//	@SuppressWarnings("static-access")
	public BandaDao() throws SQLException {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	/*public ContatoDao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
		new ConnectionFactory();
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*public void adicionaBanda(ContatoBanda contato) {
		String sql = "insert into bandas " +
				"(nome,genero,local,capacidade,data)" +
				
				"VALUES (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			//PreparedStatement stmt = connection.prepareStatement("SELECT * FROM bandas WHERE nome=?,genero=?,local=?,capacidade=? and data=?");
			BandaDao1();
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getGenero());
			stmt.setString(3,contato.getLocal());
			stmt.setString(4,contato.getCapacidade());
			//stmt.setDate(5, new Date(contato.getData().getTimeInMillis()));
			stmt.setDate(5, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis()));
			//stmt.setDate(5, new Date(contato.getData().getTimeInMillis()));

			// executa
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}



	}
	*/

	
	
	public void adicionaBanda (Banda banda) {
		String sql = "insert into bandasatestes.banda" +
				"(nome, genero)" +
				
				"VALUES (?,?)";
		try {
			// prepared statement para inserção
			//PreparedStatement stmt = connection.prepareStatement("SELECT * FROM bandas WHERE nome=?,genero=?,local=?,capacidade=? and data=?");
			BandaDao1();
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			//stmt.setLong(1, banda.getId());
			stmt.setString(1,banda.getNome());
			stmt.setString(2,banda.getGenero());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	public void adicionaShow(Show show) {

		String sql = "insert into bandasatestes.show (data,local_idlocal)" +
				
				
				"VALUES (?,?)";
		try {
			// prepared statement para inserção
			
			BandaDao1();
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores	
			//esse aqui funciona mas envia a data do sistema
			
			/*stmt.setDate(1, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis())); */
			
//			DateFormat s = new SimpleDateFormat( "" );
			
			stmt.setDate(1, (new java.sql.Date( show.getData().getTime())));
			
			//stmt.setDate(1,new java.sql.Date (show.getData().getTime()));
		
			
			
			stmt.setInt(2, show.getIdLocal());
		//	stmt.setLong(2,show.());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/*public void adicionaIdLocal(Local idlocal) {
		String sql = "insert into bandasatestes.show (data,local_idlocal)" +
				"local_idlocal" +
				"VALUES (?,?)";
		try {
			BandaDao1();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idlocal.getIdLocal());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	public void adicionaLocal(Local local) {
		String sql = "insert into bandasatestes.local" +
				"(local,capacidade)" +
				
				"VALUES (?,?)";
		try {
			// prepared statement para inserção
			//PreparedStatement stmt = connection.prepareStatement("SELECT * FROM bandas WHERE nome=?,genero=?,local=?,capacidade=? and data=?");
			BandaDao1();
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			//stmt.setString(1,local.getNome());
			stmt.setString(1, local.getLocal());
			stmt.setLong(2,local.getCapacidade());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	} 
	
	
	
	

	public List<Banda> getListaBandas() throws SQLException{
		String sql = "select * from bandasatestes.banda";
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Banda> listaBandas = new ArrayList<Banda>();
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Banda banda = new Banda();
				banda.setNome(resultSet.getString("nome"));
				banda.setGenero(resultSet.getString("genero"));
				listaBandas.add(banda); 
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			connection.close();
		}
		return listaBandas;
		
	
	      }
	
	
	
	public List<Local> getListaLocal() throws SQLException{
		String sql = "select * from bandasatestes.local";
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Local> listaLocal = new ArrayList<Local>();
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Local local = new Local();
				local.setLocal(resultSet.getString("local"));
				local.setCapacidade(resultSet.getInt("capacidade"));
				listaLocal.add(local); 
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			connection.close();
		}
		return listaLocal;
		
	
	      }
	
	public List<Show> getListaShow() throws SQLException{
		String sql = "select * from bandasatestes.show";
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Show> listaShow = new ArrayList<Show>();
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Show show = new Show();
				show.setData(resultSet.getDate("data"));
				
				listaShow.add(show); 
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			connection.close();
		}
		return listaShow;
		
	
	      }
	
	public void exclui(Banda excluir) {
		//String sql = "delete from bandas where nome=?";
		try {
			BandaDao1();
			PreparedStatement stmt = BandaDao.connection.prepareStatement("delete from bandasatestes.banda where nome=?");
			stmt.setString(1, excluir.getNome());
			//	stmt.setLong(1, excluir.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados excluidos");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir no banco de dados:!/nErro:" + e);
		}
	}
	
         

	public void atualizaBanda(Banda atualizar) {
		//String sql = "update contatos set nome = ?, genero = ?, local = ?, capacidade = ?, data = ?, where id = ?";
		try {
			BandaDao1();
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE bandasatestes.banda set nome = ?, genero = ? where idbanda = ?");
			stmt.setString(1, atualizar.getNome());
			stmt.setString(2, atualizar.getGenero());
			stmt.setLong(3, atualizar.getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados editados!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar dados no banco de dados:!/nErro:" + e);
		}
	}
	
	public void atualizaShow(Show atualizar) {
		try {
			BandaDao1();
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE bandasatestes.show set data = ? where local_idlocal = ?");
			
			//stmt.setDate(2, (new java.sql.Date( atualizar.getData().getTime())));
			stmt.setDate(2, (java.sql.Date) atualizar.getData());
			//stmt.setDate(5, new Date(atualizar.getData().getTimeInMillis()));
			stmt.setLong(1, atualizar.getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados editados!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar dados no banco de dados:!/nErro:" + e);
		}
	}
	
	public void atualizaLocal(Local atualizar) {
		//String sql = "update contatos set nome = ?, genero = ?, local = ?, capacidade = ?, data = ?, where id = ?";
		try {
			BandaDao1();
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE bandasatestes.local set local = ?, capacidade = ? where idlocal = ?");
			stmt.setString(1, atualizar.getLocal());
			stmt.setLong(2, atualizar.getCapacidade());
			stmt.setLong(3, atualizar.getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados editados!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar dados no banco de dados:!/nErro:" + e);
		}
	}
	
	
	
	
	
}