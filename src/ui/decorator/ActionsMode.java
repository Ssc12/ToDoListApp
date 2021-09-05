package ui.decorator;

import java.awt.Color;

import javax.swing.JPanel;

import ui.Actions;

public class ActionsMode extends Decorator{
	private Actions action;
	private Boolean dayMode;
	
	public ActionsMode(ViewMode viewMode,JPanel component,Boolean dayMode) {
		super(viewMode);
		this.action=(Actions) component;
		this.dayMode = dayMode;
	}

	@Override
	public void design() {
		super.design();
		if(dayMode) {
			action.setBackground(Color.decode("#eeeeee"));
			action.getDone().setBackground(action.getTemp().getBackground());
			action.getDone().setForeground(Color.BLACK);
			action.getRemove().setBackground(action.getTemp().getBackground());
			action.getRemove().setForeground(Color.BLACK);
		}else {
			action.setBackground(Color.BLACK);
			action.getDone().setBackground(Color.BLACK);
			action.getDone().setForeground(Color.WHITE);
			action.getRemove().setBackground(Color.BLACK);
			action.getRemove().setForeground(Color.WHITE);
		}
	}
}
