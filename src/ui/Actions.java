package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import mediator.ActivityMediator;
import ui.button_state.Active;
import ui.button_state.ButtonState;
import ui.button_state.Inactive;

public class Actions extends JPanel implements ActionListener {
	private ActivityMediator mediator;
	private JButton done,remove,temp;
	private ButtonState currentState,activeState,inactiveState;
	
	public Actions(ActivityMediator mediator) {
		this.mediator = mediator;
		mediator.addComponent(this);
		temp = new JButton();
		
		done = new JButton("Done");
		remove = new JButton("Remove");
		
		this.add(done);
		this.add(remove);

		inactiveState = new Inactive(this);
		activeState =  new Active(this);
		
		currentState = inactiveState; 
		currentState.uncheckCheckbox();
		
		done.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			mediator.doneTodos();
		}

		if (e.getSource().equals(remove)) {
			mediator.removeTodos();
		}
	}

	public JButton getTemp() {
		return temp;
	}

	public JButton getDone() {
		return done;
	}

	public JButton getRemove() {
		return remove;
	}
	
	public ButtonState getActiveState() {
		return activeState;
	}

	public ButtonState getInactiveState() {
		return inactiveState;
	}

	public ButtonState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ButtonState currentState) {
		this.currentState = currentState;
	}
}
