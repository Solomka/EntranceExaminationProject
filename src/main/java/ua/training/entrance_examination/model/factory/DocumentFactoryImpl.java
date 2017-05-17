package ua.training.entrance_examination.model.factory;

import ua.training.entrance_examination.model.document.BiologistDocument;
import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.MathematicianDocument;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public class DocumentFactoryImpl implements DocumentFactory {

	@Override
	public Document createDocument(StudentSpeciality studentSpeciality) {
		switch (studentSpeciality) {
		case BIOLOGIST:
			return new BiologistDocument();
		case MATHEMATICIAN:
			return new MathematicianDocument();
		default:
			throw new IllegalArgumentException("Such StudentSpeciality doesn't exist");
		}
	}

}
