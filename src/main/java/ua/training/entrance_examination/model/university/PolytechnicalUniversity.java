package ua.training.entrance_examination.model.university;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;
import ua.training.entrance_examination.service.ObservableDocumentsBlockingQueue;

public class PolytechnicalUniversity extends University {

	@Override
	public void acceptStudentDocument(ObservableDocumentsBlockingQueue documentsQueue) throws InterruptedException {
		Document nextDocument;
		while (!documentsQueue.isEmpty() && (nextDocument = documentsQueue.getDocument())
				.getStudentSpecialty() != StudentSpeciality.BIOLOGIST) {
			getStudentsDocuments().add(nextDocument);
		}


	}

}
