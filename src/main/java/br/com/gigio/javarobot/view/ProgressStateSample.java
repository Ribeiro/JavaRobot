package br.com.gigio.javarobot.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public final class ProgressStateSample {
	 
 	public static final void main(final String[] args) throws Exception {
 		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
 
 		final JFrame sampleFrame = new JFrame();
 		sampleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
 		final JPanel body = new JPanel();
 		body.setLayout(new BorderLayout());
 
 		final JSlider slider = new JSlider(0, 60);
 		body.add(slider, BorderLayout.NORTH);
 		
 		final JLabel statusLabel = new JLabel("Task not completed.");
 		body.add(statusLabel);

 		
 		@SuppressWarnings("serial")
 		final Action actionStart = new AbstractAction("Start") {
 
 			public final void actionPerformed(final ActionEvent e) {
 				start();
 			}

			private void start() {
				final SwingWorker<Integer, Integer> backgroundWork = new SwingWorker<Integer, Integer>() {
					 
		 			@Override
		 			protected final Integer doInBackground() throws Exception {
		 				for (int i = 0; i < 61; i++) {
		 					if (i % 2 == 0) {
		 						statusLabel.setText("Task running..");
							} else {
								statusLabel.setText("Task running...");
							}
		 					Thread.sleep(250);
		 					this.publish(i);
		 				}
		 
		 				return 60;
		 			}
		 
		 			@Override
		 			protected final void process(final List<Integer> chunks) {
		 				slider.setValue(chunks.get(0));
		 			}
		 			
		 			@Override
		 			protected void done() {
		 				statusLabel.setText("Task completed!");
		 			}
		 
		 		};
		 
		 		backgroundWork.execute();
				
				
			}
 
 		};
 		
 		final JButton buttonStart = new JButton(actionStart);
 		body.add(buttonStart, BorderLayout.SOUTH);
 
 		sampleFrame.add(body);
 		sampleFrame.pack();
 		sampleFrame.setVisible(true);
 		
 	}
 	
 }