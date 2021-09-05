package main;

import ui.InterfaceModeScheduler;
import ui.TodoFrame;

/*
 	Nama: Steven
 	Nim : 2201741132
 	Kelas : FLA (LB01)
 */

public class Main {
	public static void main(String[] args) {
		TodoFrame newFrame = new TodoFrame();
		InterfaceModeScheduler frameMode = new InterfaceModeScheduler(newFrame);
		Thread thread =new Thread(frameMode); 
		thread.start();
	}
}
