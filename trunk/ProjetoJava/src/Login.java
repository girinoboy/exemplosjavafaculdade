

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	JLabel pass, princ, logt, titulo;
	JPasswordField ssenha;
	JTextField log;
	JButton ok,volt;
	Pessoa pessoa;

	public Login(){
		
		Container tela = getContentPane();
		tela.setBackground(Color.WHITE);

		setSize(800,600);
		setTitle("Love Hunter - Login");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);

		titulo = new JLabel("Login");
		titulo.setBounds(500,30 ,200 , 30);
		titulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(titulo);

		princ = new JLabel(new ImageIcon("C:/Users/Isis/Desktop/Pedobear_and_friends.png"));
		princ.setBounds(100, 200, 800, 435);
		add(princ);

		logt = new JLabel("Login: ");
		logt.setBounds(30, 50, 200, 70);
		log = new JTextField("");
		log.setBounds(80, 70, 500, 25);
		add(logt);
		add(log);

		pass = new JLabel("Senha: ");
		pass.setBounds(30, 100, 200, 70);
		ssenha = new JPasswordField();
		ssenha.setBounds(80, 120, 100, 25);
		ssenha.addActionListener(this);
		add(ssenha);
		add(pass);

		ok = new JButton("OK");
		ok.setBounds(200, 120, 100, 25);
		ok.addActionListener(this);
		add(ok);
		
		volt = new JButton("Voltar");
		volt.setBounds(335, 120, 100, 25);
		volt.addActionListener(this);
		add(volt);

		setVisible(true);

		pessoa = new Pessoa();
		pessoaBD = new PessoaBD();
	}

	PessoaBD pessoaBD;

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == ok){

			try {

				pessoa.setEmail(log.getText());
				pessoa.setSenha(ssenha.getText());

				if(pessoaBD.logar(pessoa)){
					JOptionPane.showMessageDialog(null, "Logado com sucesso");
					setVisible(false);
					new Perfil(pessoa);

				}else{
					JOptionPane.showMessageDialog(null, "Login ou Senha incorretos");
				}
				
			} catch (HeadlessException e1) {

				e1.printStackTrace();
			} catch (Exception e1) {

				e1.printStackTrace();
			}

		}else{
			if(e.getSource() == volt){
				setVisible(false);
				new Agencia();
				
			}
		}

	}    

}