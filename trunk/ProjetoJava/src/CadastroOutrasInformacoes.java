

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CadastroOutrasInformacoes extends JFrame implements ActionListener {
	JComboBox filhos, bebe, fuma, escolaridade;
	JTextField trabalho;
	JTextArea hobby;
	JLabel filhol, bebel, fumal, escolaridadel, trabalhol, hobbyl, titulo;
	JButton salvar, voltar; 
	String opfilho[]={"","Nao","Sim, moram comigo", "Sim, mas nao moram comigo"}, opbebe[]={"","Nao", "Socialmente", "Moderadamente", "Excessivamente"}, opfuma[]={"","Nao", "Sim"}, opescolaridade[]={"","Fundamental incompleto", "Fundamental completo", "Medio incompleto","Medio completo", "Supletivo", "Superior incompleto", "Superio completo"};
	PessoaBD infoBD;
	OutrasInformacoes info;

	public CadastroOutrasInformacoes(Pessoa pessoa){
		setSize(800, 600);
		setTitle("Love Hunter - Cadastro Outras informacoes");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);

		titulo = new JLabel("Outras Informacoes");
		titulo.setBounds(500,30 ,200 , 30);
		titulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(titulo);

		filhol = new JLabel("Filhos:");
		filhol.setBounds(30, 50, 200, 70);
		filhos = new JComboBox(opfilho);
		filhos.setBounds(70, 70, 200, 25);
		add(filhos);
		add(filhol);

		bebel = new JLabel("Alcool:");
		bebel.setBounds(30, 100, 200, 70);
		bebe = new JComboBox(opbebe);
		bebe.setBounds(72, 120, 100, 25);
		add(bebel);
		add(bebe);

		fumal = new JLabel("Cigarro:");
		fumal.setBounds(30, 150, 200, 70);
		fuma = new JComboBox(opfuma);
		fuma.setBounds(78, 170, 70, 25 );
		add(fumal);
		add(fuma);

		escolaridadel = new JLabel("Escolaridade:");
		escolaridadel.setBounds(30, 200, 200, 70);
		escolaridade = new JComboBox(opescolaridade);
		escolaridade.setBounds(110, 220, 150, 25);
		add(escolaridadel);
		add(escolaridade);

		trabalhol = new JLabel("Pofissao:");
		trabalhol.setBounds(30, 250, 200, 70);
		trabalho = new JTextField("");
		trabalho.setBounds(90, 270, 200, 25);
		add(trabalhol);
		add(trabalho);

		hobbyl = new JLabel("Hobby");
		hobbyl.setBounds(30, 300, 200, 70);
		hobby = new JTextArea(10,20);
		hobby.setBounds(30, 350, 600, 100);
		add(hobbyl);
		add(hobby);

		salvar = new JButton("Salvar");
		salvar.setBounds(60, 460, 100, 40);
		salvar.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.setBounds(170, 460, 100, 40);
		voltar.addActionListener(this);
		add(salvar);
		add(voltar);


		info = new OutrasInformacoes();
		info.setPessoa(pessoa);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource( )== voltar){
			setVisible(false);
			new Perfil();
		}else if(e.getSource() == salvar){
			int g = JOptionPane.showConfirmDialog(null, "<html>Salvar dados?</html>","CADASTRO", 2);
			if(g == 0){
				try {
					//popula objetos
					
					info.setFilhos(filhos.getSelectedItem().toString());
					info.setBebe(bebe.getSelectedItem().toString());
					info.setFuma(fuma.getSelectedItem().toString());
					info.setEscolaridade(escolaridade.getSelectedItem().toString());
					info.setTrabalho(trabalho.getText());
					info.setHobby(hobby.getText());
					//inclui no banco de dados in mode standalone
					infoBD = new PessoaBD();
					infoBD.continuar(info);
					JOptionPane.showMessageDialog(null, "salvo com sucesso", "SALVAR", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Erro ao salvar", "ERRO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				setVisible(false);
				new Perfil();
			}

		}
	}
}