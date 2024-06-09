package lab_14pl.edu.pw.mini.po.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBottomPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public MyBottomPanel(MyGraphicPanel panel) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JTextField text = new JTextField();
		text.setText("Wpisz cos: ");
		
		JButton firstButton = new JButton();
		firstButton.setText("Hello");
		add(firstButton);
		
		JButton secondButton = new JButton();
		secondButton.setText("Jawohl!");
		add(secondButton);
		
		firstButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setBackground(Color.red);
				secondButton.setEnabled(false);
				
				String string = text.getText();
				panel.setText(string);
				panel.repaint();			}
		});
		
		add(text);
		
	}
	
}
