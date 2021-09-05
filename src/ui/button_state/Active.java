package ui.button_state;

import ui.Actions;

public class Active implements ButtonState{
	private Actions action;
	
	public Active(Actions action) {
		this.action=action;
	}

	@Override
	public void checkCheckbox() {
		action.getDone().setEnabled(true);
		action.getRemove().setEnabled(true);
	}

	@Override
	public void uncheckCheckbox() {
		action.getDone().setEnabled(false);
		action.getRemove().setEnabled(false);
		action.setCurrentState(action.getInactiveState());
	}
}
