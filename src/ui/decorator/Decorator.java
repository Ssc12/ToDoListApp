package ui.decorator;

public class Decorator implements ViewMode{
	private ViewMode viewMode;
	
	public Decorator(ViewMode viewMode) {
		this.viewMode=viewMode;
	}

	@Override
	public void design() {
		this.viewMode.design();
	}
}
