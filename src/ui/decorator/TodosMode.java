package ui.decorator;

import javax.swing.JPanel;

import ui.Todos;

public class TodosMode extends Decorator{
	private Todos todos;
	private Boolean dayMode;
	
	public TodosMode(ViewMode viewMode,JPanel component,Boolean dayMode) {
		super(viewMode);
		this.todos=(Todos) component;
		this.dayMode = dayMode;
	}

	@Override
	public void design() {
		super.design();
		if(dayMode) {
			todos.todosLightMode();
		}else {
			todos.todosDarkMode();
		}
	}
}
