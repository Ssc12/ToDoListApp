package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mediator.ActivityMediator;

public class TodoInput extends JPanel implements ActionListener {
	private JTextField text;
	private JButton add,temp;
	private ActivityMediator mediator;

	public TodoInput(ActivityMediator mediator) {
		this.mediator = mediator;
		mediator.addComponent(this);
		temp=new JButton();
		
		text = new JTextField(20);
		add = new JButton("Add");
		
		this.add(text);
		this.add(add);

		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		mediator.addTodo(todoText);
		this.text.setText("");
	}

	public JTextField getText() {
		return text;
	}

	public JButton getAdd() {
		return add;
	}
	
	public JButton getTemp() {
		return temp;
	}
}
