import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Chatbot extends JFrame implements ActionListener, KeyListener{
	TextArea taChatLog = new TextArea(13,50);
	static JTextField tfMessage=new JTextField(25);
	JButton btSend = new JButton("Send");
	JButton btClear = new JButton("Clear");
	JButton magicalContainer = new JButton("Ask me a question and I will give an answer.");
	Label lbM = new Label("Message:");
	String s="";
	Chatbot(){
		setTitle("Chatbot");
		setSize(400,350);
		setResizable(false);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(magicalContainer);
		add(taChatLog);
		taChatLog.setEditable(false);
		taChatLog.setBackground(Color.WHITE);
		add(lbM);
		add(tfMessage);
		tfMessage.addActionListener(this);
		add(btSend);
		btSend.addActionListener(this);
		add(btClear);
		btClear.addActionListener(this);
		tfMessage.requestFocus();
		magicalContainer.addKeyListener(this);
		tfMessage.addKeyListener(this);
	}
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '?' & e.getSource() == tfMessage) {
			magicalContainer.requestFocus();
			s = "";
		}

		else if(e.getSource() == magicalContainer & e.getKeyChar() == '\n') {
			actionPerformed(new ActionEvent(btSend, 0, null));
		}
		
		else if(e.getSource() == magicalContainer & e.getKeyChar() != '\b')
			s = s + e.getKeyChar();
		
		else {
			tfMessage.requestFocus();
			s = "";
		}
	}
	public void keyPressed(KeyEvent e) {

	}
	public void keyReleased(KeyEvent e) {

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btClear){
			tfMessage.setText("");
			taChatLog.setText("");
			s = "";
		}
		if(e.getSource()==btSend){
			taChatLog.setText(taChatLog.getText() + "You:" + tfMessage.getText() + "\nChatbot:" + ChopChop(s)+ '\n');
			s = "";
			tfMessage.requestFocus();
			tfMessage.setText("");
		}
	}
	public static String ChopChop(String s){
		String temp="";
		if(!tfMessage.getText().endsWith("?"))return "Is that a question?";
		if(s.length() == 0)return "I don't know";
		if(s.equalsIgnoreCase("o"))return "Oo";
		if(s.equalsIgnoreCase("y"))return "Yes";
		if(s.equalsIgnoreCase("n"))return "No";
		if(s.equalsIgnoreCase("h"))return "Hindi";
		for(int x = 0;x < s.length(); x++){
			if(Character.isDefined(s.charAt(x)))
				temp = temp + s.charAt(x);
		}
		return temp;
	}
	public static void main(String[]args){
		Chatbot c = new Chatbot();
	}
}
