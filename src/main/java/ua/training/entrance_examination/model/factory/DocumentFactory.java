package ua.training.entrance_examination.model.factory;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public interface DocumentFactory {

	Document createDocument(StudentSpeciality studentSpecialty);
}
