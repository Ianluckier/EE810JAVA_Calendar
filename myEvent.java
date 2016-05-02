

import java.awt.*;
import javax.swing.*;

public class myEvent extends JFrame{
	private MyPanel myPanel;
	
	public myEvent(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		final JTextArea textArea = new JTextArea();
		Color mycolor = new Color(200, 230, 220);
		textArea.setBackground(mycolor);
		myPanel  = new MyPanel();
		
		myPanel.addDisplayListener(new DisplayListener() {
			public void displayPerformed(DisplayEvent e) {
				String text = e.getText();
			
				textArea.append(text);
			}
		});
		
		Container c = getContentPane();
		c.add(textArea, BorderLayout.CENTER);
		c.add(myPanel, BorderLayout.WEST);
		
		setVisible(true);
	}
}
