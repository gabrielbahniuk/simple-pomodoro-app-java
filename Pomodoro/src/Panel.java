import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	final DateFormat sdf = new SimpleDateFormat("mm:ss");
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
	lblTempoRestante = new JLabel("--.--");
	lblTempoRestante.setFont(new Font("Arial", Font.BOLD , 15));
	panel.add(lblTempoRestante, cons);
	
	btnStartCount.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			
		Calendar now = Calendar.getInstance();
		Calendar future = Calendar.getInstance();
		JOptionPane.showMessageDialog(panel, "Minimize me and enjoy your time left!", "Pomodoro App", JOptionPane.INFORMATION_MESSAGE);
		future.add(Calendar.MINUTE, Integer.parseInt((String) comboTimes.getSelectedItem()));
			Timer t = new Timer();
			 TimerTask task = new TimerTask(){
			        public void run(){
			        	future.add(Calendar.SECOND, -1);
			        	Calendar c = Calendar.getInstance();
			        	c.setTimeInMillis(future.getTimeInMillis() - now.getTimeInMillis());
			        	if (c.getTimeInMillis() >= 0)
			        		lblTempoRestante.setText("" + sdf.format(c.getTime()));
			        	else {
			        		JOptionPane.showMessageDialog(panel, "Congratulations! You've finished!", "Pomodoro App", JOptionPane.INFORMATION_MESSAGE);
			        		t.cancel();			        		
			        		comboTimes.setEnabled(true);
			        		btnStartCount.setEnabled(true);
			        	}			        	
			        }
			        
			    };
			 t.scheduleAtFixedRate(task, 0, 1000);
			 comboTimes.setEnabled(false);
			 btnStartCount.setEnabled(false);
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
