package mediator;

import java.util.Vector;

import javax.swing.JPanel;

import ui.Todo;

public interface ActivityMediator {
	public void addComponent(JPanel component);
	public void addTodo(String todoText);
	public void doneTodos();
	public void removeTodos();
	public void doneCounter(Integer doneCount);
	public void checkButtonState(Boolean checkStatus,Vector<Todo> todos);
	public Boolean isLightMode();
	public void changeFrameMode();
}  
