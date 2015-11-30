package wuerfel;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

/**
 * Das ist die einzige Klasse des bescheidenen Wuerfels, welche die Wuerfelgroesse annimmt, wuerfelt und sie graphisch wieder ausgibt.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Wuerfel {
	
	private JFrame frame1 = new JFrame("Würfel");
	private NumberFormat format = NumberFormat.getInstance(); 
    private NumberFormatter formatter = new NumberFormatter(format); 
    private JFormattedTextField tfwuerfelgroesse = new JFormattedTextField(formatter);
    private JLabel labelGroesse = new JLabel("Würfelgröße:");
    private JLabel labelZahl = new JLabel("Zahl:");
    private JLabel labelausgabe = new JLabel();
	private JButton buttonwuerfeln = new JButton("Würfeln");
	
	public Wuerfel() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(280,95);
		frame1.setResizable(false);
		Container cp = frame1.getContentPane();
		cp.setLayout(null);
		
		buttonwuerfeln.setBounds(190, 10, 80, 50);
		buttonwuerfeln.setMargin(new Insets(2, 2, 2, 2));
		buttonwuerfeln.setVisible(true);
		buttonwuerfeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				wuerfeln();
			}
		});
		cp.add(buttonwuerfeln);
		
		labelGroesse.setBounds(10, 10, 80, 25);
		cp.add(labelGroesse);
		
		tfwuerfelgroesse.setBounds(100, 10, 80, 25);
		tfwuerfelgroesse.setHorizontalAlignment(SwingConstants.RIGHT);
		tfwuerfelgroesse.setText("6");
		cp.add(tfwuerfelgroesse);
		
		labelZahl.setBounds(10, 40, 80, 25);
		cp.add(labelZahl);
		
		labelausgabe.setBounds(92, 40, 80, 25);
		labelausgabe.setHorizontalAlignment(SwingConstants.RIGHT);
		cp.add(labelausgabe);
		
		format.setGroupingUsed(false);
		format.setMaximumIntegerDigits(9);
		formatter.setAllowsInvalid(false);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode liest die Groesse des Wuerfels ein und gibt eine Zufallszahl wieder aus.
	 */
	private void wuerfeln() {
		try {
			Random wuerfel = new Random();
			int wuerfeln = Integer.parseInt(tfwuerfelgroesse.getText());
			if(wuerfeln > 0) {
				int wurf = wuerfel.nextInt(wuerfeln)+1;
				labelausgabe.setText(wurf+"");
			} else {
				JOptionPane.showMessageDialog(null, wuerfeln+" Seiten sind zu klein für einen Würfel."+System.getProperty("line.separator")+"Bitte wähle mehr als eine Seite.", "Fehler", JOptionPane.PLAIN_MESSAGE);
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Die Würfelgröße ist ungültig."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Ergebnis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new Wuerfel();
	}
}