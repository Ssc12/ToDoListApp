package ui;

import java.time.LocalTime;

/*
	Nama: Steven
	Nim : 2201741132
	Kelas : FLA (LB01)
*/

public class InterfaceModeScheduler implements Runnable{
	private boolean dayMode,darkMode;
	private TodoFrame frame;
	
	public InterfaceModeScheduler(TodoFrame frame) {
		this.frame = frame;
	}

	@Override
	public void run() {
		LocalTime dayNight = LocalTime.of(18, 00);
		LocalTime midNight = LocalTime.of(0, 00);
		LocalTime dayLight = LocalTime.of(6, 00);
		LocalTime nowTemp = LocalTime.now();
		
		dayMode=false;
		darkMode = false;
		
		if(nowTemp.compareTo(dayNight) > 0 || nowTemp.compareTo(dayLight) < 0){
			//night mode
			frame.setCurrentState(frame.getDarkModeState());
			darkMode = true;
		}else if(nowTemp.compareTo(dayNight) < 0 && nowTemp.compareTo(dayLight) > 0){
			//light mode
			frame.setCurrentState(frame.getLightModeState());
			dayMode=true;
		}
			
		while(true) {
			LocalTime now = LocalTime.now();
			if((now.compareTo(dayNight) > 0 || (now.compareTo(midNight) >= 0 && now.compareTo(dayLight) < 0)) && !darkMode){
				// change to night mode
				frame.setCurrentState(frame.getDarkModeState());
				darkMode=true;
				dayMode=false;
			}else if((now.compareTo(dayLight) > 0 && now.compareTo(dayNight) < 0) && !dayMode){
				// change to light mode
				frame.setCurrentState(frame.getLightModeState());
				dayMode=true;
				darkMode = false;
			}
		}	
	}

}
