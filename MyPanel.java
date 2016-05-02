

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MyPanel extends JPanel {
	
	private EventListenerList listenerList = new EventListenerList(); 
	
	
	public MyPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Add Event"));
		Color mycolor = new Color(180, 210, 250);
		setBackground(mycolor);
		
		JLabel dateLabel = new JLabel("Time: ");
		JLabel  eventLabel = new JLabel("Event: ");
		
		JTextField dateField = new JTextField(10);
		JTextField eventField = new JTextField(15);
		
		JButton addButton = new JButton("Add");
		JButton addButton2 = new JButton("New Event");
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = dateField.getText();
				String event = eventField.getText();
				
				String text = date + "\n" + "\n" + event + "\n" + "\n" + "\n";
				
				launchDisplayEvent(new DisplayEvent(this, text));
			}
		});
		
		addButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateField.setText("");
				eventField.setText("");
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.weightx = 2.5;
		gc.weighty = 2.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(dateLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(eventLabel, gc);
		
		// Second Column
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(dateField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(eventField, gc);
		
		//Final row
		gc.weightx = 3.5;
		gc.weighty = 0.2;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		add(addButton, gc);
		
		gc.weightx = 3.5;
		gc.weighty = 10;
		gc.gridx = 1;
		gc.gridy = 3;
		add(addButton2, gc);
		
		
	}
	
	public void launchDisplayEvent(DisplayEvent e) {
		Object[] listeners = listenerList.getListenerList();
		
		for(int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == DisplayListener.class) {
				((DisplayListener)listeners[i+1]).displayPerformed(e);
			}
		}
	}
	
	public void addDisplayListener(DisplayListener listener) {
		listenerList.add(DisplayListener.class, listener);
	}
	public void removeDisplayListener(DisplayListener listener) {
		listenerList.remove(DisplayListener.class, listener);
	}
}
