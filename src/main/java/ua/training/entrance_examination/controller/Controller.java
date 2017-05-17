package ua.training.entrance_examination.controller;

import ua.training.entrance_examination.model.factory.DocumentsStorage;
import ua.training.entrance_examination.service.EntranceExamination;

public class Controller {

	public void startDocumentsAcceptanceProcess() {
		EntranceExamination.handleDocumentsQueue(new DocumentsStorage());
	}

}
