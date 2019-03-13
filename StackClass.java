import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StackClass extends JFrame implements ActionListener {
	private LinkedList<Integer> stack = new LinkedList<Integer>();
	private JButton pushbutton = new JButton("Push");
	private JButton popbutton = new JButton("Pop");
	private JButton showbutton = new JButton("Show");
	private JButton clearall = new JButton("Clear All");
	private JTextField displaytext = new JTextField("Welcome to the stack!");
	private JTextField entry = new JTextField("0",3);
	private JLabel stacktext = new JLabel("Stack: ");
	
	StackClass(){
		super("Stack");
		Container cont = getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(stacktext);
		cont.add(displaytext);
		cont.add(entry);
		cont.add(pushbutton);
		cont.add(popbutton);
		cont.add(showbutton);
		cont.add(clearall);
		popbutton.addActionListener(this);
		pushbutton.addActionListener(this);
		clearall.addActionListener(this);
		showbutton.addActionListener(this);
		displaytext.setEditable(false);
	}
	
	void push() {
		String s = this.entry.getText();
		Integer val = Integer.parseInt(s);
		stack.addFirst(val);
		displaytext.setText("Added to stack : "+val);
	}
	
	Integer pop() {
		displaytext.setText("Popped : "+stack.peekFirst());
		return stack.removeFirst();
	}
	
	void clearStack() {
		stack.removeAll(stack);
	}
	
	void displaymystack() {
		displaytext.setText("Top");
		for(Iterator<Integer> it = stack.iterator(); it.hasNext();) {
			displaytext.setText(displaytext.getText()+", "+it.next());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton b = (JButton)ae.getSource();
		if(b == pushbutton) {
			push();
			displaytext.setText("Added value: "+this.entry.getText());
		}
		else if(b == popbutton) {
			Integer popval = pop();
			displaytext.setText("Removed value: "+popval);
		}
		else if(b == clearall) {
			clearStack();
			entry.setText("0");
			displaytext.setText("");
		}
		else {
			displaytext.setText("");
			displaymystack();
		}
	}
	
	public static void main(String[] args) {
		StackClass sc = new StackClass();
		sc.setSize(250,150);
		sc.setVisible(true);
		sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
