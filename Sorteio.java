import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.util.Arrays;
import java.util.Random;

/**
 * Dado um array de strings, o programa ordena o array e cria um número random para escolher uma posição do mesmo.
 * Tendo o resultado, é exibido uma tela mostrando o resultado do sorteio.
 * 
 * @author MarcosFranco
 * @version 1.0
 */
public class Sorteio extends JFrame {

    /* PROPERTIES */

	private String arrayNomes[] = {
		"Maria",
		"Graziela",
		"Claudia",
		"Regiane",
		"Vilma",
		"Fernanda",
		"Emília",
		"Daniela",
		"Emanoele",
		"Dolores"
	};

	/* CONSTRUCTOR */

	public Sorteio() { 
		Arrays.sort(this.arrayNomes);

		// Define frame principal
		this.setTitle("Sorteio");
		this.setSize(250,100);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		// Componentes do frame
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel textoFixo = new JLabel("Nome sorteado: ");
		JLabel resultado = new JLabel(this.Sortear());
		resultado.setForeground(Color.BLUE);

		panel.add(textoFixo);
		panel.add(resultado);
		panel.setBounds(115, 100, 200, 100);
		this.add(panel, BorderLayout.NORTH);
	}

    /* METHODS */
	
	/**
	 * Método responsável por realizar o sorteio do nome
	 * 
	 * @return 
	 */
	public String Sortear() {
		Random rand = new Random();
		int sorteio = (int) rand.nextInt(10);

		try {
			return this.arrayNomes[sorteio];
		} catch(ArrayIndexOutOfBoundsException e) {
			this.Sortear();
			JOptionPane.showMessageDialog(null, "Estamos tentando calcular um novo resultado...", "Nova tentativa", JOptionPane.INFORMATION_MESSAGE, null);

			System.out.println("-- TRY AGAIN --");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Tivemos um problema para calcular o resultado, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE, null);

			System.out.println("-- ERRO --");
			System.out.println(e.getMessage());
		}

		return null;
    }
    
    /* MAIN */

	public static void main(String[] args) {
		new Sorteio();
	}
}
