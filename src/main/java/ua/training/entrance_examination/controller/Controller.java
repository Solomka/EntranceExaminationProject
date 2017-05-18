package ua.training.entrance_examination.controller;

import java.util.Objects;

import ua.training.entrance_examination.model.factory.document.Documents;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;
import ua.training.entrance_examination.service.EntranceExamination;
import ua.training.entrance_examination.view.View;

public class Controller {

	private View view;

	public Controller(View view) {
		this.view = Objects.requireNonNull(view);

	}

	public void startDocumentsAcceptanceProcess() {
		Universities universities = EntranceExamination.acceptDocumentsToUniversities(new Documents(),
				new Universities());

		showUniversitiesAfterDocAcceptance(universities);
	}

	private void showUniversitiesAfterDocAcceptance(Universities universities) {
		for (UniversityType universityType : universities.getUniversitiesTypes()) {
			view.printUniversity(universityType.toString(), universities.getUniversityByType(universityType));
		}
	}

}
