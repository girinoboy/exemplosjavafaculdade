import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SplitPaneExp extends JFrame {
    
	JLabel img, texto, titulo, texto2;
	JButton bt1, bt2, bt3;
	
    public SplitPaneExp() {
        
        setTitle("Example of Split Pane");
        setSize(150, 150);
        /*
        JPanel jsp1 = new JPanel();
        JPanel jsp2 = new JPanel();
        JLabel j1 = new JLabel("Area 1");
        JLabel j2 = new JLabel("Area 2");
        
        jsp1.add(j1);
        jsp2.add(j2);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
                true, jsp1, jsp2);
        
        splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);*/
        
        titulo = new JLabel("Love Hunter");
		titulo.setBounds(450,30 ,200 , 30);
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 20));
		titulo.setForeground(Color.red);
		
		
		
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
		
		texto2 = new JLabel("<html>Encontre a tampa da sua panela. O outro par da sua havaina. O ovo da sua marmita. A matade da sua laranja. <center>CADASTRE-SE AGORA!!!</center></html>");
		texto2.setBounds(30, 450, 1250, 300);
		texto2.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 18));
		texto2.setForeground(Color.red);
		
		img = new JLabel(new ImageIcon("D:/Documents and Settings/Rafael/Desktop/Imagemlogo.jpeg"));
		img.setBounds(300, 300, 800, 250);
		
		bt1 = new JButton("Cadastro");
		bt1.setBounds(30, 350, 200, 30);
		//bt1.addActionListener(this);
		bt3 = new JButton("Login");
		bt3.setBounds(30, 380, 200, 30);
		//bt3.addActionListener(this);
		bt2 = new JButton("Sair");
		bt2.setBounds(30, 410, 200, 30);
		//bt2.addActionListener(this);
		
        
        JPanel panelTitulo = new JPanel();
        JPanel texto1 = new JPanel();
        JPanel botoes = new JPanel();
        JPanel image = new JPanel();
        
        panelTitulo.add(titulo);
        texto1.add(texto);
        
        botoes.add(bt1);
       // botoes.setBounds(10, 500, 100, 50);
        botoes.add(bt3);
        botoes.add(bt2);
        botoes.setLocation(200, 100);
        image.add(img);
		
		 JSplitPane splitPanetop = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
	                true, panelTitulo, texto1);
		 
		 JSplitPane splitPanecenter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
	                false, botoes, image);
		
		 JSplitPane splitPanedown = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
	                false, splitPanecenter, texto2);
		 
		 JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
	                false, splitPanetop, splitPanedown);
	        
	        splitPane.setOneTouchExpandable(true);
	        getContentPane().add(splitPane, BorderLayout.CENTER);
        
    }
    public static void main(String[] args) {
        
        SplitPaneExp sp = new SplitPaneExp();
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);
        sp.pack();
        
    }
}