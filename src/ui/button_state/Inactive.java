package ui.button_state;

import ui.Actions;

public class Inactive implements ButtonState{
	private Actions action;
	
	public Inactive(Actions action) {
		this.action=action;
	}

	@Override
	public void checkCheckbox() {
		action.getDone().setEnabled(true);
		action.getRemove().setEnabled(true);
		action.setCurrentState(action.getActiveState());
	}

	@Override
	public void uncheckCheckbox() {
		action.getDone().setEnabled(false);
		action.getRemove().setEnabled(false);
	}
}
