package partie1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		super("Main Window");

		// La barre de menu
		JMenuBar menuBar = new JMenuBar();

		// Le menu fichier
		JMenu fichier = new JMenu("Fichier");
		menuBar.add(fichier);
		setJMenuBar(menuBar);
		menuBar.setVisible(true);

		// Les sous-menus (Nouveau / Quitter)
		JMenuItem nouveau = new JMenuItem("Nouveau");
		fichier.add(nouveau);
		JMenuItem quitter = new JMenuItem("Quitter");
		fichier.add(quitter);

		// Ajout des événements sur les sous-menus
		nouveau.addActionListener(e -> {
			new SecondWindow();
			dispose();
		});
		quitter.addActionListener(e -> dispose());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 200));
		pack();
		setVisible(true);
	}
}
