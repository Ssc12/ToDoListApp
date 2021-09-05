package ui.view_mode_state;

import ui.TodoFrame;
import ui.decorator.ActionsMode;
import ui.decorator.Basic;
import ui.decorator.TodoInputMode;
import ui.decorator.TodosMode;
import ui.decorator.ViewMode;

public class LightModeState implements InterfaceModeState{
	private TodoFrame todoFrame;
	
	public LightModeState(TodoFrame todoFrame) {
		this.todoFrame=todoFrame;
	}

	@Override
	public void getState() {
		ViewMode action = new ActionsMode(new Basic(),todoFrame.getActions(),true);
		ViewMode todos = new TodosMode(action,todoFrame.getTodos(),true);
		ViewMode todoInput = new TodoInputMode(todos,todoFrame.getTodoInput(),true);
		todoInput.design();
	}
	
	@Override
	public void pressNButton() {
		todoFrame.setCurrentState(todoFrame.getDarkModeState());
	}
}
