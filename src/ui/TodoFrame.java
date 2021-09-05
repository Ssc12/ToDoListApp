package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import mediator.ActivityMediator;
import mediator.Mediator;
import ui.view_mode_state.DarkModeState;
import ui.view_mode_state.InterfaceModeState;
import ui.view_mode_state.LightModeState;

public class TodoFrame extends JFrame implements KeyListener{
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private ActivityMediator mediator;
	private int doneCount;
	private Boolean dayMode;
	private InterfaceModeState currentState,lightModeState,darkModeState;
	
	public TodoFrame() {
		this.setTitle("Done: 0");
		
		mediator= new Mediator(this);
		todoInput = new TodoInput(mediator);
		this.add(todoInput, BorderLayout.NORTH);
		
		todos = new Todos(mediator);
		this.add(todos, BorderLayout.CENTER);

		actions = new Actions(mediator);
		this.add(actions, BorderLayout.SOUTH);
			
		lightModeState = new LightModeState(this);
		darkModeState =  new DarkModeState(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addKeyListener(this);
		this.setFocusable(true);
		this.setVisible(true);
		this.pack();
	}

	public int getDoneCount() {
		return doneCount;
	}

	public void setDoneCount(int doneCount) {
		this.doneCount = doneCount;
	}
	
	public Boolean isLightMode() {
		return dayMode;
	}
	
	public TodoInput getTodoInput() {
		return todoInput;
	}

	public Todos getTodos() {
		return todos;
	}

	public Actions getActions() {
		return actions;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_N) {
			mediator.changeFrameMode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public InterfaceModeState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(InterfaceModeState currentState) {
		if(currentState == lightModeState) {
			this.currentState = getLightModeState();
			dayMode=true;
		}else if(currentState == darkModeState) {
			this.currentState = getDarkModeState();
			dayMode=false;
		}
		this.currentState.getState();
	}

	public InterfaceModeState getLightModeState() {
		return lightModeState;
	}

	public InterfaceModeState getDarkModeState() {
		return darkModeState;
	}

}
