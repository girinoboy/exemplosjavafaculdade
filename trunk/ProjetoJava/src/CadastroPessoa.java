

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CadastroPessoa extends JFrame implements ActionListener {

	JLabel titulo, nome, idade, email, ondemora, sexo, quemsoul, senha, texto;
	JButton ok, cancel, cad;
	JTextField nomet, idadet, emailt, senhat;
	JTextArea quemsou;
	JComboBox sexoc, ondemorac;
	String opsexo[]={"Feminino", "Masculino"}, opmora[]={"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SP","SE","TO"};
	PessoaBD pessoaBD;



	public CadastroPessoa(){

		montarTela();
		setVisible(true);

		pessoaBD = new PessoaBD();
	}


	private void montarTela(){
		
		Container tela = getContentPane();
		tela.setBackground(Color.WHITE);
		
		setSize(800, 600);
		setTitle("Love Hunter - Cadastro");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);

		titulo = new JLabel("Cadastro");
		titulo.setBounds(500,30 ,200 , 30);
		titulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(titulo);

		nome = new JLabel("Nome:");
		nome.setBounds(30, 50, 200, 70);
		nomet = new JTextField("");
		nomet.setBounds(70, 70, 500, 25);
		add(nome);
		add(nomet);

		idade = new JLabel("Idade:");
		idade.setBounds(30, 100, 200, 70);
		idadet = new JTextField("");
		idadet.setBounds(70, 120, 30, 25);
		add(idade);
		add(idadet);

		sexo = new JLabel("Sexo:");
		sexo.setBounds(30, 150, 200, 70);
		sexoc = new JComboBox(opsexo);
		sexoc.setBounds(70, 170, 80, 25);
		add(sexo);
		add(sexoc);

		ondemora = new JLabel("Onde Mora:");
		ondemora.setBounds(30, 200, 200, 70);
		ondemorac = new JComboBox(opmora);
		ondemorac.setBounds(100, 220, 50, 25);
		add(ondemora);
		add(ondemorac);

		email = new JLabel("E-mail:");
		email.setBounds(30, 250, 200, 70);
		emailt = new JTextField("");
		emailt.setBounds(70, 270, 500, 25);
		add(email);
		add(emailt);

		quemsoul = new JLabel("Quem sou:");
		quemsoul.setBounds(30, 320, 200, 70);
		quemsou = new JTextArea(10,20);
		quemsou.setBounds(30, 370, 600, 100);
		add(quemsoul);
		add(quemsou);

		texto = new JLabel("<html>*Para efetuar seu cadastro digite uma senha de 6 digitos. Seu login será feito atraves do seu e-mail cadastrado.</html>");
		texto.setBounds(30, 450, 1250, 100);
		texto.setForeground(Color.RED);
		add(texto);

		senha = new JLabel("Senha:");
		senha.setBounds(30, 500, 200, 70);
		senhat = new JTextField("");
		senhat.setBounds(70, 525, 100, 25);
		add(senha);
		add(senhat);

		ok = new JButton("Salvar");
		ok.setBounds(30, 600, 200, 30);
		ok.addActionListener(this);
		add(ok);

		/*cad = new JButton("Cadastrar outras informacoes");
		cad.setBounds(250, 600, 250, 30);
		cad.addActionListener(this);
		add(cad);*/

		cancel = new JButton("Voltar");
		cancel.setBounds(250, 600, 200, 30);
		cancel.addActionListener(this);
		add(cancel);
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == cancel){
			setVisible(false);
			new Agencia();
		}else if(e.getSource() == cad){
			setVisible(false);
			//new CadastroOutrasInformacoes();
		}else if(e.getSource() == ok){
			int g = JOptionPane.showConfirmDialog(null, "<html>Salvar dados?</html>","CADASTRO", 2);
			if(g == 0){
				try {
					//popula objetos
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(nomet.getText());
					pessoa.setIdade(idadet.getText());
					pessoa.setSexo(sexoc.getSelectedItem().toString());
					pessoa.setOndemora(ondemorac.getSelectedItem().toString());
					pessoa.setEmail(emailt.getText());
					pessoa.setQuemsou(quemsou.getText());
					pessoa.setSenha(senhat.getText());
					//inclui no banco de dados in mode standalone
					pessoaBD.incluir(pessoa);
					JOptionPane.showMessageDialog(null, "salvo com sucesso", "sucesso", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new Agencia();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "O email já está sendo usado. Informe outro!", "erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		}



	}
}