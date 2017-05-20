package ua.training.entrance_examination.service;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.factory.document.Documents;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;
import ua.training.entrance_examination.view.View;

public class EntranceExaminationService {

	/** shared resource */
	private BlockingQueue<Document> documentsQueue;

	private DocumentsProducer documentsProducer;
	private DocumentsConsumers documentsConsumers;

	private Universities universities;

	private View view;

	private EntranceExaminationService(Documents documents, Universities universities, View view) {
		Objects.requireNonNull(documents);

		this.documentsQueue = new LinkedBlockingQueue<>();
		this.universities = Objects.requireNonNull(universities);
		this.view = Objects.requireNonNull(view);

		this.documentsProducer = new DocumentsProducer(documentsQueue, documents);
		this.documentsConsumers = new DocumentsConsumers(documentsQueue, this.universities);
	}

	public static void acceptDocumentsToUniversities(Documents documents, Universities universities, View view) {
		new EntranceExaminationService(documents, universities, view).acceptDocumentsToUniversities();
	}

	private void acceptDocumentsToUniversities() {
		documentsProducer.start();
		documentsConsumers.start();

		try {
			documentsProducer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			documentsConsumers.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showUniversitiesAfterDocAcceptance(universities);

	}

	private void showUniversitiesAfterDocAcceptance(Universities universities) {

		for (UniversityType universityType : universities.getUniversitiesTypes()) {
			view.printUniversity(universityType.toString(), universities.getUniversityDocumentsNumber(universityType));
		}
	}

}
