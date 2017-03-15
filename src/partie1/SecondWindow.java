package partie1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class SecondWindow extends JFrame
{
	private JTextArea textArea;

	private JCheckBoxMenuItem styleGras;
	private JCheckBoxMenuItem styleItalique;
	private JButton reset ;

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
		JRadioButtonMenuItem blue = new JRadioButtonMenuItem(new ColorMenuItem("blue",Color.blue));
		JRadioButtonMenuItem rouge = new JRadioButtonMenuItem(new ColorMenuItem("Rouge",Color.red));
		JRadioButtonMenuItem noir = new JRadioButtonMenuItem(new ColorMenuItem("Noir",Color.black));
		couleurGroup.add(blue);
		couleurGroup.add(rouge);
		couleurGroup.add(noir);

		couleur.add(blue);
		couleur.add(rouge);
		couleur.add(noir);

		rouge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
		blue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_MASK));
		noir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));


		

		textArea = new JTextArea("");
		textArea.requestFocus();
		add(textArea);
		

		JMenu style = new JMenu("Style");
		menuBar.add(style);
		setJMenuBar(menuBar);
		menuBar.setVisible(true);

		styleGras = new JCheckBoxMenuItem(new ChangeFontStyle("Gras", Font.BOLD));
		styleItalique = new JCheckBoxMenuItem(new ChangeFontStyle("Italique", Font.ITALIC));
		style.add(styleGras);
		style.add(styleItalique);

		styleGras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK));
		styleItalique.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,InputEvent.CTRL_MASK));
		
		
		//setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK+InputEvent.SHIFT_MASK));
		
		
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
		fontBox.addActionListener(e -> {
			Font f = (Font)fontBox.getSelectedItem();
			textArea.setFont(f.deriveFont((float)(int)fontSizeBox.getSelectedItem()));
		});
		toolBar.add(fontBox);

		fontSizeBox = new JComboBox<>();
		for (int i = 8 ; i <= 24 ; i++) {
			fontSizeBox.addItem(i);
		}
		fontSizeBox.addActionListener(e -> {
			textArea.setFont(textArea.getFont().deriveFont((float)(int)fontSizeBox.getSelectedItem())); // Besoin de la méthode avec le paramètre float
		});
		toolBar.add(fontSizeBox);

		this.reset = new JButton("reset");
		reset.addActionListener(new ResetAction());
		toolBar.add(reset);
		InputMap im = reset.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK+InputEvent.SHIFT_MASK), "sar");
        reset.getActionMap().put("sar", new ResetAction());
		
		//reset.setMnemonic(KeyEvent.VK_F5);
		add(toolBar, BorderLayout.NORTH);
	}

	
	
	class ResetAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// On change la font
			textArea.setFont(new Font("Dialog.plain", Font.PLAIN, 12));

			// On réinitialise tout
			styleGras.setSelected(false);
			styleItalique.setSelected(false);
			tbBold.setSelected(false);
			tbItalic.setSelected(false);
			fontBox.setSelectedItem(new Font("Dialog.plain", Font.PLAIN, 1));
			fontSizeBox.setSelectedItem(12);
			
		}
		
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
