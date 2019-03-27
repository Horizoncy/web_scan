package web_scan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class select extends JFrame{
//	String current_type;
	public select(){
		setTitle("web_scan");
		
		setBounds(400, 300, 300, 200);
		Container cp = getContentPane();
		cp.setLayout(null);
		JLabel label = new JLabel("IP£∫");
		label.setBounds(20, 20, 200, 20);
		final JTextField ip_field = new JTextField();
		ip_field.setBounds(90, 20, 150, 18);
		JComboBox choose;
		String choice[] = {"common port scan", "diy scan"};
		choose = new JComboBox(choice);
		
		cp.add(label);
		cp.add(ip_field);
		cp.add(choose);
		choose.setBounds(50, 55, 200, 20);
		JButton button = new JButton("»∑∂®");
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(choose.getSelectedIndex()==0){
					web_scan wb = new web_scan(ip_field.getText(),1);
					wb.typeA();
					return;
				}
				if(choose.getSelectedIndex()==1){
					setVisible(false);
					new main_page();
				}
			}
		});
		button.setBounds(90, 80, 60, 24);
		cp.add(button);
		final JButton button2 = new JButton();
		button2.setText("÷ÿ÷√");
		setVisible(true);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ip_field.setText("");
			}
		});
	button2.setBounds(160, 80, 60, 24);
	getContentPane().add(button2);
	}
	public static void main(String[] args) {
		new select();
	}

}