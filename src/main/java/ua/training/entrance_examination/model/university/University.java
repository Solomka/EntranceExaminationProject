package ua.training.entrance_examination.model.university;

import java.util.HashSet;
import java.util.Set;

import ua.training.entrance_examination.model.document.Document;

public abstract class University {

	private Set<Document> studentsDocuments;

	public University() {
		studentsDocuments = new HashSet<>();
	}

	public void acceptStudentDocument(Document document) {
		if (checkStudentSpeciliaty(document)) {
			studentsDocuments.add(document);
		}
	}

	protected abstract boolean checkStudentSpeciliaty(Document document);

}
