package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ui.todo_activity_broadcast.Observable;
import ui.todo_activity_broadcast.Observer;

public class Todo extends JPanel implements ActionListener,Observable{
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;
	private Observer todos;
	
	public Todo(String text) {
		this.setPreferredSize(new Dimension(350, 30));

		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		this.add(checkbox, BorderLayout.WEST);

		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);

		checkbox.addActionListener(this);
	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkbox = (JCheckBox) e.getSource();
		if (checkbox.isSelected()) {
			todos.notifyCheckboxChange(true);
		}else {
			todos.notifyCheckboxChange(false);
		}
	}
	
	@Override
	public void addObserver(Observer todos) {
		this.todos=todos;
	}
	
	public void todoDarkMode() {
		this.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		checkbox.setBackground(Color.BLACK);
		border = BorderFactory.createLineBorder(Color.WHITE, 1);
		this.setBorder(border);
	}
	
	public void todoLightMode() {
		this.setBackground(Color.decode("#eeeeee"));
		label.setForeground(Color.BLACK);
		checkbox.setBackground(Color.decode("#eeeeee"));
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
	}
}
