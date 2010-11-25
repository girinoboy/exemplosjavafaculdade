

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;


public class CadastroPessoaProcurada extends JFrame implements ActionListener{

	JLabel idadel, sexol, ondemoral, titulo;
	JButton procurar, voltar;
	JComboBox idade, sexo, ondemora;
	String opidade[]={"","18-22", "23-27", "28-32", "33-37", "38-42", "43-47", "48-52", "53-57", "Maior de 58"}, opmora[]={"","AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SP","SE","TO"}, opsexo[]={"","Maculino", "Feminino"};
	private JScrollPane myScrollPane;
	private JTable myTable;
	private JPanel myPanel;
	ResultSetTable table = null;

	public CadastroPessoaProcurada(){

		inicializar();
		setVisible(true);
	}


	private void inicializar(){
		setSize(800, 600);
		setTitle("Love Hunter - Procurar pessoa");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);

		titulo = new JLabel("Pesquisa");
		titulo.setBounds(500,30 ,200 , 30);
		titulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(titulo);

		idadel = new JLabel("Idade:");
		idadel.setBounds(30, 50, 200, 70);
		idade = new JComboBox(opidade);
		idade.setBounds(70, 70, 100, 25);
		add(idadel);
		add(idade);

		sexol = new JLabel("Sexo:");
		sexol.setBounds(30, 100, 200, 70);
		sexo = new JComboBox(opsexo);
		sexo.setBounds(70, 120, 100, 25);
		add(sexol);
		add(sexo);

		ondemoral = new JLabel("Onde mora:");
		ondemoral.setBounds(30, 150, 200, 70);
		ondemora = new JComboBox(opmora);
		ondemora.setBounds(100, 170, 50, 25);
		add(ondemoral);
		add(ondemora);

		procurar = new JButton("Procurar");
		procurar.setBounds(60, 300, 100, 40);
		procurar.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.setBounds(170, 300, 100, 40);
		voltar.addActionListener(this);
		add(procurar);
		add(voltar);
		myScrollPane = new JScrollPane();
		add(myScrollPane);
		/*add(new JTable());

		Connection con = null;
		Statement stmt = null;

		try
		{
			table = new ResultSetTable();
			// Connect to the Inventory database
			con = Conexao.getConnection();
			// Create statement objects.
			stmt = con.createStatement(); 

			myScrollPane = new JScrollPane();
			myTable = table.createTable(stmt.executeQuery("select * from CadastroOutrasInformacoes"));
			myScrollPane.setViewportView(myTable);
			myTable.setVisible(true);
			myScrollPane.setVisible(false);

			//add(myScrollPane);
			myTable.setVisible(true);
			myScrollPane.setVisible(false);

			myScrollPane.setBounds(0, 500, 600, 400);
			add(myScrollPane);
			myScrollPane.setVisible(false);
			//setContentPane(myScrollPane);
			repaint();

			//createTable(stmt.executeQuery("SELECT * FROM pessoa"));
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void actionPerformed(ActionEvent a) {

		Pessoa pessoa = new Pessoa();

		pessoa.setSexo(sexo.getSelectedItem().toString());
		pessoa.setOndemora(ondemora.getSelectedItem().toString());
		pessoa.setIdade(idade.getSelectedItem().toString());

		if(a.getSource()== voltar){
			setVisible(false);
			new Perfil(pessoa); 
		}else if(a.getSource()== procurar){
			try {
				table = new ResultSetTable();


				myScrollPane.setVisible(false);
				myScrollPane = table.creatScrollPane(pessoa);
				myScrollPane.setBounds(0, 500, 900, 400);
				add(myScrollPane);
				myScrollPane.setVisible(true);
				//repaint();
				//getContentPane().repaint();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
				e.printStackTrace();
			}

		}
	}


	/*

	private boolean DEBUG = false;

    public CadastroPessoaProcurada() {
        super(new GridLayout(1,0));

        String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};

        Object[][] data = {
	    {"Kathy", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)},
	    {"John", "Doe",
	     "Rowing", new Integer(3), new Boolean(true)},
	    {"Sue", "Black",
	     "Knitting", new Integer(2), new Boolean(false)},
	    {"Jane", "White",
	     "Speed reading", new Integer(20), new Boolean(true)},
	    {"Joe", "Brown",
	     "Pool", new Integer(10), new Boolean(false)}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 *//*
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CadastroPessoaProcurada newContentPane = new CadastroPessoaProcurada();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/







}
