

/*
 * Acessar o Guia de instalação do HSQLDB disponível no BLOG.
 * 
 * Essa classe é um exemplo de como fazer uma conexão simples
 * com o banco de dados do HSQLDB. 
 * ATENÇÃO: 
 * 1.Criar uma classe chamada de Conexao.java
 * 2.Copiar esse conteúdo e colar no corpo da classe criada
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	// driver do SGBD
	private static final String DRIVER = "org.hsqldb.jdbcDriver";
	//Url responsável por fazer a conexão.
	private static final String URL= "jdbc:hsqldb:file:C:\\hsqldb-2.0.1-rc2\\hsqldb-2.0.1-rc2\\hsqldb\\data\\ProjetoJava";//"jdbc:hsqldb:hsql://localhost:59999/sisreceita";
	//usuario para conectar ao Banco de Dados
	private static final String USER="SA";
	//senha do usuario
	private static final String PASSWORD="";
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			//Tenta criar uma conexão
			conn = getConnection();
			System.out.println("Conex�o bem sucedida");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(conn !=null)
				conn.close();
		}
	}
	/*
	 * Método que retorna uma conexão
	 */
	protected static Connection getConnection() throws Exception{
		try {
			//o driver é colocado em memória 
			Class.forName(DRIVER);
			// cria uma conexão com os parâmetros da URL, USER e PASSWORD
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("classe n�o encontrada");
			//retorna uma exceção caso não consiga achar o driver informado
			throw e;
		} catch (SQLException e) {
			System.out.println("ecessa� de sql");
			//retorna uma exceção caso não consiga criar a conexão com o banco de dados
			throw e;
		}
	}


}
