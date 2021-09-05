package ui.decorator;

import java.awt.Color;

import javax.swing.JPanel;

import ui.TodoInput;

public class TodoInputMode extends Decorator{
	private TodoInput todoInput;
	private Boolean dayMode;
	
	public TodoInputMode(ViewMode viewMode,JPanel component,Boolean dayMode) {
		super(viewMode);
		this.todoInput=(TodoInput) component;
		this.dayMode = dayMode;
	}

	@Override
	public void design() {
		super.design();
		
		if(dayMode) {
			todoInput.setBackground(Color.decode("#eeeeee"));
			todoInput.getAdd().setBackground(todoInput.getTemp().getBackground());
			todoInput.getAdd().setForeground(Color.BLACK);
			todoInput.getText().setBackground(Color.WHITE);
			todoInput.getText().setForeground(Color.BLACK);
		}else {
			todoInput.setBackground(Color.BLACK);
			todoInput.getAdd().setBackground(Color.BLACK);
			todoInput.getAdd().setForeground(Color.WHITE);
			todoInput.getText().setBackground(Color.BLACK);
			todoInput.getText().setForeground(Color.WHITE);
		}
	}
}
