package br.com.gigio.javarobot.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3480306110367383796L;
	private JLabel countLabel1 = new JLabel("0");
	private JLabel statusLabel = new JLabel("Task not completed.");
	private JButton startButton = new JButton("Start");

	public MainFrame(String title) {
		super(title);

		setLayout(new GridBagLayout());

		countLabel1.setFont(new Font("serif", Font.BOLD, 28));

		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		add(countLabel1, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		add(statusLabel, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		add(startButton, gc);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});

		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void start() {
		SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
			   @Override
			   protected Boolean doInBackground() throws Exception {
				   
			    // Simulate doing something useful.
			    for (int i = 0; i <= 10; i++) {
			    	if (i % 2 == 0) {
			    		statusLabel.setText("Running on background ...");
					} else {
						statusLabel.setText("Running on background ");

					}
			     Thread.sleep(1000);
			     countLabel1.setText(String.valueOf(i));
			     System.out.println("Running " + i);
			    }

			    // Here we can return some object of whatever type
			    // we specified for the first template parameter.
			    // (in this case we're auto-boxing 'true').
			    
			    return true;
			    
			   }

			   // Can safely update the GUI from this method.
			   protected void done() {

			    boolean status;
			    try {
			     // Retrieve the return value of doInBackground.
			     status = get();
			     statusLabel.setText("Completed with status: " + status);
			     
			    } catch (InterruptedException e) {
			     // This is thrown if the thread's interrupted.
			    	
			    } catch (ExecutionException e) {
			     // This is thrown if we throw an exception
			     // from doInBackground.
			    	
			    }
			   }

			  };

			  worker.execute();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MainFrame("SwingWorker Demo");

			}

		});

	}

}
