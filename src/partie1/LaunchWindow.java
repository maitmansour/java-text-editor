package partie1;

import javax.swing.SwingUtilities;

public class LaunchWindow
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(MainWindow::new);
	}
}
