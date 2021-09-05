package ui.view_mode_state;

import ui.TodoFrame;
import ui.decorator.ActionsMode;
import ui.decorator.Basic;
import ui.decorator.TodoInputMode;
import ui.decorator.TodosMode;
import ui.decorator.ViewMode;

public class DarkModeState implements InterfaceModeState{
	private TodoFrame todoFrame;
	
	public DarkModeState(TodoFrame todoFrame) {
		this.todoFrame=todoFrame;
	}

	@Override
	public void getState() {
		ViewMode action = new ActionsMode(new Basic(),todoFrame.getActions(),false);
		ViewMode todos = new TodosMode(action,todoFrame.getTodos(),false);
		ViewMode todoInput = new TodoInputMode(todos,todoFrame.getTodoInput(),false);
		todoInput.design();
	}
	
	@Override
	public void pressNButton() {
		todoFrame.setCurrentState(todoFrame.getLightModeState());
	}
}
