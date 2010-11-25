

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Agencia extends JFrame implements ActionListener {

	private Collection<Pessoa> pessoas= new ArrayList<Pessoa>();


	//cadastrar
	//consultar
	//alterar


	PessoaProcurada perfprocurado = new PessoaProcurada();
	OutrasInformacoes outras = new OutrasInformacoes();
	Pessoa cadperfil = new Pessoa();




	JLabel img, texto, titulo, texto2;
	JButton bt1, bt2, bt3;
	JMenuBar bar;
	JMenuItem mi3;


	public Agencia() {
		//super(new GridLayout(5,0));
		inicializar();
		
		setVisible(true);
	}
	



	private void inicializar(){
		setSize(800,600);
		setTitle("Love Hunter");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);

		



		titulo = new JLabel("Love Hunter");
		titulo.setBounds(450,30 ,200 , 30);
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 20));
		titulo.setForeground(Color.red);
		
		add(titulo);
		
		texto = new JLabel("<html><br>" +" ' " + " Ainda que eu falasse as l�nguas dos homens e dos anjos, " +
				"e n�o tivesse Amor, seria como o metal que soa ou como o sino que tine. " +
				"E ainda que tivesse o dom da profecia," +
				"e conhecesse todos os mist�rios e toda a ci�ncia, " +
				"e ainda que tivesse toda a f�, " +
				"de maneira tal que transportasse os montes, e n�o tivesse Amor, nada seria. " +
				"E ainda que distribu�sse toda a minha fortuna para sustento dos pobres, " +
				"e ainda que entregasse o meu corpo para ser queimado, se n�o tivesse Amor, " +
				"nada disso me aproveitaria.O Amor � paciente, � benigno; o Amor n�o � invejoso, " +
				"n�o trata com leviandade, n�o se ensoberbece, n�o se porta com indec�ncia, " +
				"n�o busca os seus interesses, n�o se irrita, n�o suspeita mal, n�o folga com a " +
				"injusti�a, mas folga com a verdade. Tudo tolera, tudo cr�, tudo espera, tudo suporta. " +
				"O Amor nunca falha. Havendo profecias, ser�o aniquiladas; havendo l�nguas, cessar�o; " +
				"havendo ci�ncia, desaparecer�; porque, em parte conhecemos, e em parte profetizamos;" +
				"mas quando vier o que � perfeito, ent�o o que o � em parte ser� aniquilado. " +
				"Quando eu era menino, falava como menino, sentia como menino, discorria como menino, mas, " +
				"logo que cheguei a ser homem, acabei com as coisas de menino. Porque agora vemos por " +
				"espelho em enigma, mas ent�o veremos face a face; agora conhe�o em parte, mas ent�o conhecerei<br> " +
				"como tamb�m sou conhecido. Agora, pois, permanecem " +
				"a f�, a esperan�a e o amor, estes tr�s; mas o maior destes � o Amor." + " ' " + " (1Cor�ntios 14:3)</html>");
		texto.setBounds(60, 40 ,1020, 250);	
		texto.setFont(new Font("Vijaya", Font.CENTER_BASELINE, 20));
		texto.setForeground(Color.BLUE);
		add(texto);


		bt1 = new JButton("Cadastro");
		bt1.setBounds(30, 350, 200, 30);
		bt1.addActionListener(this);
		bt3 = new JButton("Login");
		bt3.setBounds(30, 380, 200, 30);
		bt3.addActionListener(this);
		bt2 = new JButton("Sair");
		bt2.setBounds(30, 410, 200, 30);
		bt2.addActionListener(this);

		add(bt1);
		add(bt3);
		add(bt2);

		
		img = new JLabel(new ImageIcon("C:/Users/Isis/Desktop/Imagemlogo.jpeg"));
		img.setBounds(300, 300, 800, 250);
		add(img);


		texto2 = new JLabel("<html>Encontre a tampa da sua panela. O outro par da sua havaina. O ovo da sua marmita. A matade da sua laranja. <center>CADASTRE-SE AGORA!!!</center></html>");
		texto2.setBounds(30, 450, 1250, 300);
		texto2.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 18));
		texto2.setForeground(Color.red);
		add(texto2);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource() == bt1){
				setVisible(false);
				new CadastroPessoa();
			}else if(e.getSource() == bt2){
				setVisible(false);
				System.exit(0);
			}else if(e.getSource() == bt3){
				setVisible(false);
				new Login();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}


	}

}


/*int k = JOptionPane.showConfirmDialog(null, "<html>Testando consulta!<br>Fechar o programa?</html>","CONSULTA", 2);
if(k == 0)
System.exit(0);*/