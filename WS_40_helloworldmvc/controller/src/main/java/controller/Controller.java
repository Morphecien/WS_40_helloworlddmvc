package controller;

import contract.*;

public class Controller {
	private IView view ;
	private IModel model ;
	
	public Controller(IView view, IModel model) {
		this.view = view ;
		this.model = model ;
	}
	
	public void run(){
		this.view.displayMessage(this.model.getHelloWorld());
	}
}
