package ua.training.entrance_examination.model.factory.document;

import java.util.Collections;
import java.util.LinkedList;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public class Documents {

	private DocumentFactory documentFactory;
	private LinkedList<Document> documents;

	private int numberOfBiologists;
	private int numberOfMathematicians;

	public Documents(int numberOfBiologists, int numberOfMathematicians) {
		this.documentFactory = new DocumentFactoryImpl();
		this.documents = new LinkedList<>();

		this.numberOfBiologists = numberOfBiologists;
		this.numberOfMathematicians = numberOfMathematicians;

		acceptDocuments();
	}

	private void acceptDocuments() {
		generateBiologistsDocuments();
		generateMathematiciansDocuments();
		Collections.shuffle(documents);
	}

	private void generateBiologistsDocuments() {

		for (int i = 0; i < numberOfBiologists; i++) {
			documents.add(documentFactory.createDocument(StudentSpeciality.BIOLOGIST));
		}
	}

	private void generateMathematiciansDocuments() {
		for (int i = 0; i < numberOfMathematicians; i++) {
			documents.add(documentFactory.createDocument(StudentSpeciality.MATHEMATICIAN));
		}
	}

	public Document getDocument() {
		return documents.removeFirst();
	}

	public boolean isEmpty() {
		return documents.size() == 0;
	}

	public int size() {
		return documents.size();
	}

}
