package ua.training.entrance_examination.model.university;

import ua.training.entrance_examination.model.document.Document;

public class UniversalUniversity extends University {

	@Override
	protected boolean checkStudentSpeciliaty(Document document) {
		return true;
	}

}
