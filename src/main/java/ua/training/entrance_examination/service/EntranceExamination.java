package ua.training.entrance_examination.service;

import java.util.Objects;

import ua.training.entrance_examination.model.factory.document.Documents;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;

public class EntranceExamination {

	private ObservableDocumentsBlockingQueue documentsQueue;
	private QueueFillingObserver fillingObserver;

	private Universities universities;

	private EntranceExamination(Documents documentsStorage, Universities universities) {

		this.documentsQueue = new ObservableDocumentsBlockingQueue();
		this.fillingObserver = new QueueFillingObserver(documentsQueue, documentsStorage);
		documentsQueue.addObserver(fillingObserver);
		this.universities = Objects.requireNonNull(universities);
	}

	public static Universities acceptDocumentsToUniversities(Documents documentsStorage, Universities universities) {
		return new EntranceExamination(documentsStorage, universities).handleDocumentsQueue();		
	}

	private Universities handleDocumentsQueue() {
		new Thread(() -> {
			while (!documentsQueue.isEmpty()) {
				universities.getUniversityByType(UniversityType.MEDICAL).acceptStudentDocument(documentsQueue);
				universities.getUniversityByType(UniversityType.UNIVERSAL).acceptStudentDocument(documentsQueue);
				universities.getUniversityByType(UniversityType.POLUTECHNICAL).acceptStudentDocument(documentsQueue);
			}
		}).start();
		
		return getUniversities();
	}
	
	private Universities getUniversities(){
		return universities;
	}

}
