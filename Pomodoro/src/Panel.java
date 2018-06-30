import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSelectTime;
	private JLabel lblTempoRestante;
	private JButton btnStartCount;
	private JComboBox<String> comboTimes;
	
	public Panel() {	
		
	JPanel panel = new JPanel(new GridBagLayout());
	GridBagConstraints cons = new GridBagConstraints();
	cons.insets = new Insets(10, 10, 10, 10);
	cons.gridx = 0;
	cons.gridy = 0;
	lblSelectTime = new JLabel("Preferred time (minutes)");
	panel.add(lblSelectTime, cons);
	
	cons.anchor = GridBagConstraints.CENTER;
	cons.gridx = 1;
	cons.gridy = 0;
	cons.ipadx = 30;
	cons.ipady = 10;
	comboTimes = new JComboBox<>();
	comboTimes.addItem("25");
	comboTimes.addItem("60");
	panel.add(comboTimes, cons);
	
	cons.gridx = 1;
	cons.gridy = 1;
	cons.ipadx = 30;
	cons.ipady = 10;
	btnStartCount = new JButton("Start");
	panel.add(btnStartCount, cons);
	
	cons.ipadx = 30;
	cons.ipady = 10;
	cons.gridx = 1;
	cons.gridy = 3;
	lblTempoRestante = new JLabel("25:00");
	lblTempoRestante.setFont(new Font("Arial", Font.BOLD , 15));
	panel.add(lblTempoRestante, cons);
	
	btnStartCount.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			TimerHandler.setTimer(lblTempoRestante, comboTimes);
		}		
	});
	
	comboTimes.addItemListener(new ItemListener() {		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED)
				lblTempoRestante.setText(e.getItem().toString() + ":00");
		}
	});
	lblSelectTime.setFont(new Font("Cambria", Font.PLAIN, 15));
	add(panel);		
	}
}