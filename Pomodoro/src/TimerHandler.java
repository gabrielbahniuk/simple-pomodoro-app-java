import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TimerHandler {

	public static Timer timer;
	public static Calendar c = Calendar.getInstance();
	public static Calendar now = Calendar.getInstance();
	public static Calendar future = Calendar.getInstance();
	
	public static long getDifference(Calendar future, Calendar now) {
		return future.getTimeInMillis() - now.getTimeInMillis();
	}
	
	public static void setTimer(JLabel lblTimer, JComboBox<String> comboTimes) {
		future.add(Calendar.MINUTE, Integer.parseInt((String) comboTimes.getSelectedItem()));
		TimerTask task = new TimerTask() {			
			@Override
			public void run() {
				future.add(Calendar.SECOND, -1);
	        	c.setTimeInMillis(TimerHandler.getDifference(future, now));
	        	if (c.getTimeInMillis() >= 0)
	        		lblTimer.setText(new SimpleDateFormat("mm:ss").format(c.getTime()));
	        	else { 		       
	        		JOptionPane.showMessageDialog(null, "Descansar por 5min!", "Descanso", JOptionPane.INFORMATION_MESSAGE);
	        		timer.cancel();
	        	}
			}
		};	
		 timer = new Timer();
		 timer.scheduleAtFixedRate(task, 0, 1000);
	}
}
