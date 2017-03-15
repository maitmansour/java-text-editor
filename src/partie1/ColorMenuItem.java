package partie1;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;




public class ColorMenuItem extends AbstractAction{
	private Color color;
	public ColorMenuItem(String nom , Color color ) {
		putValue(Action.NAME, nom);
		this.color = color;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
