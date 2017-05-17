package ua.training.entrance_examination.model.university;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public class PolytechnicalUniversity extends University{

	@Override
	protected boolean checkStudentSpeciliaty(Document document) {
		return document.getStudentSpecialty() == StudentSpeciality.MATHEMATICIAN ? true : false;
	}

}
