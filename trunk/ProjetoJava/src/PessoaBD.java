

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaBD extends Conexao{



	public void incluir(Pessoa pessoa) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		try {

			conn = getConnection();

			String sql = "insert into " +
			"pessoa(nome ,idade ,sexo ,uf,email ,quem_sou,senha ) " +
			"values(?,?,?,?,?,?,?)";

			conn.setAutoCommit(false);

			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getIdade());
			ps.setString(3, pessoa.getSexo());
			ps.setString(4, pessoa.getOndemora());
			ps.setString(5, pessoa.getEmail());
			ps.setString(6, pessoa.getQuemsou());
			ps.setString(7, pessoa.getSenha());

			ps.execute();

			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}

	}




	public void continuar(OutrasInformacoes info) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		try {

			conn = getConnection();

			String sql = "insert into " +
			"outrasInformacoes(filho ,alcool ,cigarro ,escolaridade ,trabalho,hobby,email) " +
			"values(?,?,?,?,?,?,?)";

			conn.setAutoCommit(false);

			ps = conn.prepareStatement(sql);
			ps.setString(1, info.getFilhos());
			ps.setString(2, info.getBebe());
			ps.setString(3, info.getFuma());
			ps.setString(4, info.getEscolaridade());
			ps.setString(5, info.getTrabalho());
			ps.setString(6, info.getHobby());
			ps.setString(7, info.getPessoa().getEmail());

			ps.execute();

			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}

	}





	public Pessoa consultar(Pessoa pessoa) throws Exception{

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = getConnection();

			String sql = "select * from pessoa";



			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setNome(rs.getString("nome"));

			}


		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			if(ps != null)
				ps.close();
			if(rs != null)
				rs.close();
			if(conn != null)
				conn.close();
		}

		return pessoa;

	}

	public boolean logar(Pessoa pessoa) throws Exception{

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Boolean existe = false;
		try {

			conn = getConnection();

			String sql = "select * from pessoa where email =? and senha =?";


			ps = conn.prepareStatement(sql);

			ps.setString(1, pessoa.getEmail());
			ps.setString(2, pessoa.getSenha());

			rs = ps.executeQuery();

			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setNome(rs.getString("nome"));
				existe = true;

			}

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			if(ps != null)
				ps.close();
			if(rs != null)
				rs.close();
			if(conn != null)
				conn.close();
		}

		return existe;
	}

}