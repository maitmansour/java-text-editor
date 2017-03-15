package partie2;

import javax.swing.*;
import java.awt.*;

public class WindowScrollPane extends JFrame
{
	public WindowScrollPane()
	{
		super("JScrollPane");
		setLayout(new GridLayout(2, 1));

		JTextArea textArea = new JTextArea(
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n" +
			"Maecenas eleifend magna at massa interdum convallis.\n"
		);

		textArea.setPreferredSize(new Dimension(200, 200));

		add(new JScrollPane(textArea));

		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
