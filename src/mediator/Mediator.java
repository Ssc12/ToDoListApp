package mediator;

import java.util.Vector;

import javax.swing.JPanel;

import ui.Actions;
import ui.Todo;
import ui.TodoFrame;
import ui.TodoInput;
import ui.Todos;

/*
	Nama: Steven
	Nim : 2201741132
	Kelas : FLA (LB01)
*/

public class Mediator implements ActivityMediator{
	private TodoFrame frame;
	private TodoInput todoInput;
	private Actions action;
	private Todos todos;
	
	public Mediator(TodoFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void addComponent(JPanel component) {
		if(component instanceof Todos) {
			this.todos=(Todos) component;
		}else if(component instanceof TodoInput) {
			this.todoInput=(TodoInput) component;
		}else if(component instanceof Actions) {
			this.action=(Actions) component;
		}
	}
	
	@Override
	public void addTodo(String todoText) {
		todos.addTodo(todoText);
		frame.toFront();
		frame.requestFocus();
		frame.pack();
	}

	@Override
	public void doneTodos() {
		todos.done();
		frame.pack();
	}

	@Override
	public void removeTodos() {
		todos.remove();
		frame.pack();
	}

	@Override
	public void doneCounter(Integer doneCount) {
		frame.setDoneCount(frame.getDoneCount() + doneCount);
		frame.setTitle("Done: " + frame.getDoneCount());
	}

	@Override
	public void checkButtonState(Boolean checkStatus, Vector<Todo> todos) {
		if(checkStatus == true) {
			action.getCurrentState().checkCheckbox();
		}else {
			int countCheck =0;
			for (Todo todo : todos) {
				if (todo.isChecked()) {
					countCheck++;
					break;
				}
			}
			if(countCheck==0) {
				// setButtonDisable (all checkbox is unchecked)
				action.getCurrentState().uncheckCheckbox();
			}else {
				// there is checkbox that still checked.
				action.getCurrentState().checkCheckbox();
			}
		}
	}

	@Override
	public Boolean isLightMode() {
		return frame.isLightMode();
	}

	@Override
	public void changeFrameMode() {
		frame.getCurrentState().pressNButton();
	}

}
