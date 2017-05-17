package ua.training.entrance_examination.model.university;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public class MedicalUniversity extends University {

	@Override
	protected boolean checkStudentSpeciliaty(Document document) {
		return document.getStudentSpecialty() == StudentSpeciality.BIOLOGIST ? true : false;
	}

}
