package ua.training.entrance_examination.service;

import java.util.Objects;

import ua.training.entrance_examination.model.factory.document.Documents;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;

/*
 * TODO: 2 threads:
 * 1 thread - filling
 * 2 thread - documents accepting
 */
public class EntranceExamination {

	private ObservableDocumentsBlockingQueue documentsQueue;
	private QueueFillingObserver fillingObserver;

	private DocumentsBlockingQueueFiller documentsBlockingQueueFiller;

	private Universities universities;

	private EntranceExamination(Documents documentsStorage, Universities universities) throws InterruptedException {

		this.documentsQueue = new ObservableDocumentsBlockingQueue();
		this.documentsBlockingQueueFiller = new DocumentsBlockingQueueFiller(documentsQueue, documentsStorage);
		this.fillingObserver = new QueueFillingObserver(documentsQueue, documentsBlockingQueueFiller);
		documentsQueue.addObserver(fillingObserver);
		this.universities = Objects.requireNonNull(universities);

		// start queue filling 
		this.documentsBlockingQueueFiller.fillObservableQueueToMaxThreshold();
	}

	public static Universities acceptDocumentsToUniversities(Documents documentsStorage, Universities universities)
			throws InterruptedException {
		return new EntranceExamination(documentsStorage, universities).handleDocumentsQueue();
	}

	private Universities handleDocumentsQueue() {

		while(!documentsQueue.isEmpty()){
			try {
				universities.getUniversityByType(UniversityType.MEDICAL_UNIVERSITY).acceptStudentDocument(documentsQueue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				universities.getUniversityByType(UniversityType.UNIVERSAL_UNIVERSITY).acceptStudentDocument(documentsQueue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				universities.getUniversityByType(UniversityType.POLITECHNICAL_UNIVERSITY).acceptStudentDocument(documentsQueue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return getUniversities();
	}

	private Universities getUniversities() {
		return universities;
	}

}
