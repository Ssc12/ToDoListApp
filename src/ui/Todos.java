package ui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import mediator.ActivityMediator;
import ui.todo_activity_broadcast.Observer;

public class Todos extends JPanel implements Observer {
	private ActivityMediator mediator;

	private Vector<Todo> todos;

	public Todos(ActivityMediator mediator) {
		this.todos = new Vector<>();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.mediator = mediator;
		mediator.addComponent(this);
		displayTodos();
	}

	public void addTodo(String text) {
		Todo newTodo = new Todo(text);
		newTodo.addObserver(this);
		
		Boolean isLightMode = mediator.isLightMode();
		if(isLightMode) {
			newTodo.todoLightMode();
		}else {
			newTodo.todoDarkMode();
		}
		
		todos.add(newTodo);
		displayTodos();
	}

	public void done() {
		int doneCount=0;
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				doneCount++;
				continue;
			}
			newTodos.add(todo);
		}
		mediator.doneCounter(doneCount);
		this.todos = newTodos;
		mediator.checkButtonState(false,todos);
		displayTodos();
	}

	public void remove() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		mediator.checkButtonState(false,todos);
		displayTodos();
	}

	private void displayTodos() {
		removeAll();
		for (Todo todo : todos) {
			this.add(todo); 
		}
	} 

	@Override
	public void notifyCheckboxChange(Boolean checkStatus) {
		mediator.checkButtonState(checkStatus,todos);
	}
	
	public void todosDarkMode() {
		for (Todo todo : todos) {
			todo.todoDarkMode();
		}
	}
	
	public void todosLightMode() {
		for (Todo todo : todos) {
			todo.todoLightMode();
		}
	}
}
