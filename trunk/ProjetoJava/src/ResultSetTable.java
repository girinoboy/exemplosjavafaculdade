


import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;


public class ResultSetTable extends JFrame {

	private JScrollPane myScrollPane;
	private JTable myTable;
	private JPanel myPanel;

	public ResultSetTable () throws Exception
	{

		Connection con = null;
		Statement stmt = null;
		try
		{
			// Connect to the Inventory database
			con = Conexao.getConnection();
			// Create statement objects.
			stmt = con.createStatement();  

			initialize(createTable(stmt.executeQuery("SELECT * FROM pessoa")));
			//the table name is WAITING_ITEMS
			//createTable(stmt.executeQuery("SELECT * FROM pessoa"));
			stmt.close();
			con.close();


		}
		catch(SQLException sqle)
		{ sqle.printStackTrace(System.err); }
	}


	public JScrollPane creatScrollPane(Pessoa pessoa) throws Exception{

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		try
		{

			// Connect to the Inventory database
			con = Conexao.getConnection();

			//monta slq
			sql ="select nome ,idade ,sexo ,uf ,p.email ,quem_sou ,filho ,alcool ,cigarro ,escolaridade ,trabalho ,hobby  " +
			" from pessoa p " +
			" left join outrasinformacoes i on i.email = p.email" +
			" where 1=1";

			if(pessoa.getSexo() != ""){
				sql += " and sexo ='" +pessoa.getSexo()+"'";
			}
			if(pessoa.getOndemora() != ""){
				sql +=" and uf ='"+pessoa.getOndemora()+"'";
			}
			if(pessoa.getIdade() != ""){

				sql += " and idade > "+pessoa.getIdade1();
				if(pessoa.getIdade2() > 0)
					sql +=" and idade < "+pessoa.getIdade2();
			}

			// Create statement objects.
			ps = con.prepareStatement(sql);


			myTable = createTable(ps.executeQuery());
			myScrollPane = new JScrollPane();
			myScrollPane.setViewportView(myTable);

			ps.close();
			con.close();
		}
		catch(SQLException sqle)
		{ sqle.printStackTrace(System.err); }
		return myScrollPane;

	}

	public void initialize(JTable jTable) {
		myScrollPane = new JScrollPane();
		myTable = jTable;
		myScrollPane.setViewportView(myTable);
		myPanel = new JPanel();
		myPanel.add(myScrollPane);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setContentPane(myPanel);

		pack();
	}

	public JTable createTable (ResultSet rs) {
		Vector data = null;
		Vector columnNames = null;
		try {
			data = getRowData(rs);
			columnNames = getColumnName(rs);
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}


		myTable = new JTable(data,columnNames);



		//The repaint doesn't seem to work
		myTable.repaint();

		return myTable;

	}

	public Vector getColumnName (ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		Vector colNames = new Vector ();

		for( int col = 0; col < meta.getColumnCount(); col++) {
			colNames.add(meta.getColumnName(col+1));
		}        
		return colNames;
	}

	public Vector  getRowData (ResultSet table) throws SQLException {
		ResultSetMetaData meta = table.getMetaData();
		String[] colNames = new String[meta.getColumnCount()];
		Vector cells = new Vector();
		Vector cell = null;      

		for( int col = 0; col < colNames.length; col++) {
			colNames[col] = meta.getColumnName(col + 1);

		} 

		// hold data from result set
		while(table.next()) {
			cell = new Vector();
			for(int col = 0; col < colNames.length; col++) {
				cell.add(table.getObject(colNames[col]));

			}
			cells.add(cell);
		}


		return cells;
	}


	public static void main(String args[]) {
		//*** NEED TO LOOK UP MORE INFORMATION ***
		//don't know why this code is needed to run the GUI
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ResultSetTable().setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}
}