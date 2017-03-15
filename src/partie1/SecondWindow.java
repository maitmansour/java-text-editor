package partie1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SecondWindow extends JFrame
{

	//Text Area
	private JTextArea textArea;
	private JCheckBox gras;
	private JCheckBox italique;
	
	public SecondWindow()
	{
		setTitle("Secondaire 0");

		// La barre de menu
		JMenuBar menuBar = new JMenuBar();
		
		// Le menu couleur
		JMenu couleur = new JMenu("Couleur");
		menuBar.add(couleur);
		setJMenuBar(menuBar);
		menuBar.setVisible(true);
		
		//Les radio-bouttons
		ButtonGroup couleurGroup = new ButtonGroup();
		JRadioButton blue = new JRadioButton(new ColorMenuItem("blue",Color.blue));
		JRadioButton rouge = new JRadioButton(new ColorMenuItem("Rouge",Color.red));
		JRadioButton noir = new JRadioButton(new ColorMenuItem("Noir",Color.black));
		couleurGroup.add(blue);
		couleurGroup.add(rouge);
		couleurGroup.add(noir);

		couleur.add(blue);
		couleur.add(rouge);
		couleur.add(noir);
		
		
		textArea = new JTextArea("");
		add(textArea);
		
		
		JMenu style = new JMenu("Style");
		menuBar.add(style);
		setJMenuBar(menuBar);
		menuBar.setVisible(true);

		 gras = new JCheckBox(new ChangeFontStyle("Gras"));
		 italique = new JCheckBox(new ChangeFontStyle("Italique"));
		style.add(gras);
		style.add(italique);
		
		
		
		setPreferredSize(new Dimension(300, 200));

		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class ChangeFontStyle extends AbstractAction{
		
		public ChangeFontStyle(String name) {
			putValue(Action.NAME, name);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

			 int boldState= Font.PLAIN;
			 int italicState = Font.PLAIN;

				if (gras.isSelected()) {
					boldState = Font.BOLD;
				}

				if (italique.isSelected()) {
					italicState = Font.ITALIC;
				}
				
				textArea.setFont(textArea.getFont().deriveFont(boldState+italicState));
			
			
		}
		
	}
	
	class ColorMenuItem extends AbstractAction{
		private Color color;
		public ColorMenuItem(String nom , Color color ) {
			putValue(Action.NAME, nom);
			this.color = color;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.setForeground(color);
		}

	}
}
