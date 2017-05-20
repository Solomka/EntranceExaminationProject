package ua.training.entrance_examination;

import ua.training.entrance_examination.controller.Controller;
import ua.training.entrance_examination.view.View;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		View view = new View();
		Controller controller = new Controller(view);
		controller.processUniversitiesDocumentsAcceptance();
	}
}
