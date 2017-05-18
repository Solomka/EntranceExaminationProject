package ua.training.entrance_examination.model.university;

import java.util.HashSet;
import java.util.Set;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.service.ObservableDocumentsBlockingQueue;

public abstract class University {

	private Set<Document> studentsDocuments;

	public University() {
		studentsDocuments = new HashSet<>();
	}

	public abstract void acceptStudentDocument(ObservableDocumentsBlockingQueue documentsQueue);

	public Set<Document> getStudentsDocuments() {
		return studentsDocuments;
	}
	
}
