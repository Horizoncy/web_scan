package web_scan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main_page extends JFrame{
	int p1, p2;
	public main_page(){
		setTitle("web_scan");
		
		setBounds(400, 300, 300, 200);
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JLabel label = new JLabel("Start Port：");
		label.setBounds(20, 20, 200, 20);
		
		final JTextField ip1_field = new JTextField();
		ip1_field.setBounds(90, 20, 150, 18);
		
		JLabel label2 = new JLabel("End Port：");
		label2.setBounds(20, 55, 200, 18);
		
		final JTextField ip2_field = new JTextField();
		ip2_field.setBounds(90, 55, 150, 18);
		
		JLabel label3 = new JLabel("IP：");
		label3.setBounds(20, 85, 200, 18);
		
		final JTextField ip3_field = new JTextField();
		ip3_field.setBounds(90, 85, 150, 18);
		
		cp.add(label);
		cp.add(ip1_field);
		
		cp.add(label2);
		cp.add(ip2_field);
		
		cp.add(label3);
		cp.add(ip3_field);
		
		JButton button = new JButton("确定");
		button.setBounds(90, 115, 60, 24);
		cp.add(button);

		final JButton button2 = new JButton();
		button2.setText("重置");
		setVisible(true);
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(label.getText()!=null && label2.getText()!=null){
					p1 = Integer.parseInt(ip1_field.getText());
					p2 = Integer.parseInt(ip2_field.getText());
					web_scan wb2 = new web_scan(p1, p2, ip3_field.getText());
					wb2.typeB();
					return;
				}
			}
		});
		
		button2.setBounds(160, 115, 60, 24);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ip1_field.setText("");
				ip2_field.setText("");
				ip3_field.setText("");
			}
		});


	}

}