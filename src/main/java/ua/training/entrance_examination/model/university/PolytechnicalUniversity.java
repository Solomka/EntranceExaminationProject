package ua.training.entrance_examination.model.university;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.document.StudentSpeciality;

public class PolytechnicalUniversity extends University {

	@Override
	public void acceptStudentDocument(BlockingQueue<Document> documentsQueue) {
		Objects.requireNonNull(documentsQueue);

		while (!documentsQueue.isEmpty()
				&& (documentsQueue.peek().getStudentSpecialty() != StudentSpeciality.BIOLOGIST)) {
			try {
				getStudentsDocuments().add(documentsQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
