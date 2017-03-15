package partie1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class SecondWindow extends JFrame
{
	private JTextArea textArea;

	private JCheckBoxMenuItem styleGras;
	private JCheckBoxMenuItem styleItalique;

	private JCheckBox tbBold;
	private JCheckBox tbItalic;
	private JComboBox<Font> fontBox;
	private JComboBox<Integer> fontSizeBox;
	
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

		styleGras = new JCheckBoxMenuItem(new ChangeFontStyle("Gras", Font.BOLD));
		styleItalique = new JCheckBoxMenuItem(new ChangeFontStyle("Italique", Font.ITALIC));
		style.add(styleGras);
		style.add(styleItalique);
		
		// Toolbar
		initToolBar();

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initToolBar()
	{
		JToolBar toolBar = new JToolBar();

		tbBold = new JCheckBox( new ChangeFontStyle("gras", Font.ITALIC) );
		tbItalic = new JCheckBox( new ChangeFontStyle("italique", Font.ITALIC) );
		toolBar.add(tbBold);
		toolBar.add(tbItalic);

		fontBox = new JComboBox<>(
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()
		);
		fontBox.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list,
														  Object value, int index, boolean isSelected, boolean cellHasFocus) {
				if (value != null) {
					Font font = (Font) value;
					value = font.getName();
				}
				return super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
			}
		});
		fontBox.addActionListener(e -> textArea.setFont((Font)fontBox.getSelectedItem()));
		toolBar.add(fontBox);

		fontSizeBox = new JComboBox<>();
		for (int i = 8 ; i <= 24 ; i++) {
			fontSizeBox.addItem(i);
		}
		fontSizeBox.addActionListener(e -> {
			textArea.setFont(textArea.getFont().deriveFont((float)(int)fontSizeBox.getSelectedItem())); // Besoin de la méthode avec le paramètre float
		});
		toolBar.add(fontSizeBox);

		JButton reset = new JButton("reset");
		reset.addActionListener(e -> {
			// On change la font
			textArea.setFont(new Font("Dialog.plain", Font.PLAIN, 12));

			// On réinitialise tout
			styleGras.setSelected(false);
			styleItalique.setSelected(false);
			tbBold.setSelected(false);
			tbItalic.setSelected(false);
			fontBox.setSelectedItem(new Font("Dialog.plain", Font.PLAIN, 1));
			fontSizeBox.setSelectedItem(12);
			System.out.println(fontBox.getSelectedItem());
		});
		toolBar.add(reset);

		add(toolBar, BorderLayout.NORTH);
	}
	
	class ChangeFontStyle extends AbstractAction
	{
		private int style;

		ChangeFontStyle(String name, int style)
		{
			putValue(Action.NAME, name);
			this.style = style;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int boldState= Font.PLAIN;
			int italicState = Font.PLAIN;

			if (styleGras.isSelected() || tbBold.isSelected())
			{
				boldState = Font.BOLD;
				// styleGras.setSelected(true);
				// tbBold.setSelected(true);
			}

			if (styleItalique.isSelected() || tbItalic.isSelected())
			{
				italicState = Font.ITALIC;
				// styleItalique.setSelected(true);
				// tbItalic.setSelected(true);
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
