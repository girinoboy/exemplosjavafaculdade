

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Perfil extends JFrame implements ActionListener{

	JLabel titulo, texto;
	JButton sair, outrasinfo, consulta;
	Pessoa pessoa;
	
	public Perfil(){}
	
	public Perfil(Pessoa pessoa){
		
		Container tela = getContentPane();
		tela.setBackground(Color.WHITE);
		
		setSize(800, 600);
		setTitle("Love Hunter - Perfil");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);

		titulo = new JLabel("Perfil");
		titulo.setBounds(500,30 ,200 , 30);
		titulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(titulo);

		texto = new JLabel("Agora que voce ja e um membro, cadastre outras informacoes e encontre sua cara metade!");
		texto.setBounds(70, 70, 5000, 30);
		texto.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		texto.setForeground(Color.red);
		add(texto);

		outrasinfo = new JButton("Outras informacoes");
		outrasinfo.setBounds(60, 100, 200, 30);
		outrasinfo.addActionListener(this);
		consulta = new JButton("Procurar perfis");
		consulta.setBounds(270, 100, 200, 30);
		consulta.addActionListener(this);
		sair = new JButton("Logoff");
		sair.setBounds(700, 100, 90, 30);
		sair.addActionListener(this);

		add(outrasinfo);
		add(consulta);
		add(sair);
		
		this.pessoa = pessoa;

		setVisible(true);

	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == consulta){
			setVisible(false);
			new CadastroPessoaProcurada();
		}else if(e.getSource() == outrasinfo){
			setVisible(false);
			new CadastroOutrasInformacoes(pessoa);
		}else if(e.getSource() == sair){
			setVisible(false);
			new Agencia();
		}

	}

}
