

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Pessoa  {

	private String nome;
	private String idade;
	private String sexo;
	private String quemsou;
	private String ondemora;
	private String email;
	private String senha;
	private Long idade1;
	private Long idade2;
	
	public Pessoa(){}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		if(idade == "18-22"){
			idade1 = 18L;
			idade2 = 22L;
		}
		if(idade == "23-27"){
			idade1 = 23L;
			idade2 = 27L;
		}
		if(idade == "28-32"){
			idade1 = 28L;
			idade2 = 32L;
		}
		if(idade == "33-37"){
			idade1 = 33L;
			idade2 = 37L;
		}
		if(idade == "38-42"){
			idade1 = 38L;
			idade2 = 42L;
		}
		if(idade == "43-47"){
			idade1 = 43L;
			idade2 = 47L;
		}
		if(idade == "48-52"){
			idade1 = 48L;
			idade2 = 52L;
		}
		if(idade == "53-57"){
			idade1 = 53L;
			idade2 = 57L;
		}
		if(idade == "Maior de 58"){
			idade1 = 58L;
			idade2 = 0L;
		}
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getQuemsou() {
		return quemsou;
	}
	public void setQuemsou(String quemsou) {
		this.quemsou = quemsou;
	}
	public String getOndemora() {
		return ondemora;
	}
	public void setOndemora(String ondemora) {
		this.ondemora = ondemora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdade1() {
		return idade1;
	}

	public void setIdade1(Long idade1) {
		this.idade1 = idade1;
	}

	public Long getIdade2() {
		return idade2;
	}

	public void setIdade2(Long idade2) {
		this.idade2 = idade2;
	}
	
	
}
