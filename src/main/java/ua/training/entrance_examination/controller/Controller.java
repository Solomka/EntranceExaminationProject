package ua.training.entrance_examination.controller;

import java.util.Objects;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.factory.document.Documents;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;
import ua.training.entrance_examination.service.EntranceExaminationService;
import ua.training.entrance_examination.view.View;
import ua.training.entrance_examination.view.ViewMessage;

public class Controller {

	private View view;

	public Controller(View view) {
		this.view = Objects.requireNonNull(view);
	}

	public void processUniversitiesDocumentsAcceptance() throws InterruptedException {
		view.printMessage(ViewMessage.GREETING);
		view.printMessage(ViewMessage.DOCUMENTS_PROCESSING, ViewMessage.NEW_LINE);

		EntranceExaminationService.startAcceptingDocumentsToUniversities(
				new Documents(GlobalConstants.BIOLOGISTS_NUMBER, GlobalConstants.MATHEMATICIANS_NUMBER),
				new Universities(UniversityType.MEDICAL_UNIVERSITY, UniversityType.POLYTECHNICAL_UNIVERSITY,
						UniversityType.UNIVERSAL_UNIVERSITY),
				view);
	}
}
