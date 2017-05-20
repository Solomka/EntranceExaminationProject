package ua.training.entrance_examination.model.university;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import ua.training.entrance_examination.model.document.Document;

public abstract class University {

	private List<Document> studentsDocuments;

	public University() {
		studentsDocuments = new ArrayList<>();
	}

	public abstract void acceptStudentDocument(BlockingQueue<Document> documentsQueue);

	public List<Document> getStudentsDocuments() {
		return studentsDocuments;
	}
	
	public int getNumberOfDocumnetsAccepted(){
		return studentsDocuments.size();
	}

}
