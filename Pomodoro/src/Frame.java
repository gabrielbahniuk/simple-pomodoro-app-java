import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Frame() {
		super("Pomodoro Simple App");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(300,300));
		add(new Panel());
		setVisible(true);
	}
}
