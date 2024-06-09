package pl.edu.pw.mini.po.szprej.app.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBottomPanel extends JPanel {

	public MyBottomPanel(MyGraphicPanel panel) {
		JTextField text = new JTextField();
		text.setText("");
		
		JButton button = new JButton("Calculate area");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("" + panel.getRays());
				
			}
			
		});
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(button);
		this.add(text);
		
	}
	
}
