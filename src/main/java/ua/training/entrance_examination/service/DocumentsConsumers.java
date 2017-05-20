package ua.training.entrance_examination.service;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;

public class DocumentsConsumers extends Thread {

	private BlockingQueue<Document> documentsQueue;
	private Universities universities;

	public DocumentsConsumers(BlockingQueue<Document> documentsQueue, Universities universities) {
		this.documentsQueue = Objects.requireNonNull(documentsQueue);
		this.universities = Objects.requireNonNull(universities);
	}

	@Override
	public void run() {
		waitForProducerQueueFilling();
		processUniversitiesDocumentsAcceptance();
	}

	private void waitForProducerQueueFilling() {
		try {
			sleep(GlobalConstants.CONSUMER_THREAD_SLEEP_BEFORE_FILLING_MSEC);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void processUniversitiesDocumentsAcceptance() {

		while (!documentsQueue.isEmpty()) {

			universities.getUniversityByType(UniversityType.MEDICAL_UNIVERSITY).acceptStudentDocument(documentsQueue);
			try {
				sleep(GlobalConstants.CONSUMER_THREAD_SLEEP_BEFORE_UNIVERSAL_UNIVERSITY_MSEC);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			universities.getUniversityByType(UniversityType.UNIVERSAL_UNIVERSITY).acceptStudentDocument(documentsQueue);
			try {
				sleep(GlobalConstants.CONSUMER_THREAD_SLEEP_BEFORE_POLYTECHNICAL_UNIVERSITY_MSEC);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			universities.getUniversityByType(UniversityType.POLYTECHNICAL_UNIVERSITY)
					.acceptStudentDocument(documentsQueue);
			try {
				sleep(GlobalConstants.CONSUMER_THREAD_SLEEP_BEFORE_MEDICAL_UNIVERSITY_MSEC);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
