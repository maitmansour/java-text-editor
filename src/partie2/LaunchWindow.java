package partie2;

import javax.swing.*;

public class LaunchWindow
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(WindowScrollPane::new);
	}
}
