package ua.training.entrance_examination.model.factory.document;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public class DocumentFactoryImpl implements DocumentFactory {

	@Override
	public Document createDocument(StudentSpeciality studentSpeciality) {
		switch (studentSpeciality) {
		case BIOLOGIST:
			return new Document(StudentSpeciality.BIOLOGIST);
		case MATHEMATICIAN:
			return new Document(StudentSpeciality.MATHEMATICIAN);
		default:
			throw new IllegalArgumentException("Such StudentSpeciality doesn't exist");
		}
	}

}
