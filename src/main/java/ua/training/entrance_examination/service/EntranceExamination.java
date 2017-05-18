package ua.training.entrance_examination.service;

import java.util.Objects;

import ua.training.entrance_examination.model.factory.document.Documents;
import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;

public class EntranceExamination {

	private ObservableDocumentsBlockingQueue documentsQueue;
	private QueueFillingObserver fillingObserver;

	private Universities universities;

	private EntranceExamination(Documents documentsStorage, Universities universities) throws InterruptedException {

		this.documentsQueue = new ObservableDocumentsBlockingQueue();
		this.fillingObserver = new QueueFillingObserver(documentsQueue, documentsStorage);
		documentsQueue.addObserver(fillingObserver);
		this.universities = Objects.requireNonNull(universities);
		
		System.out.println(documentsQueue.getDocument());
	}

	public static Universities acceptDocumentsToUniversities(Documents documentsStorage, Universities universities) throws InterruptedException {
		return new EntranceExamination(documentsStorage, universities).handleDocumentsQueue();		
	}

	private Universities handleDocumentsQueue() {
		
		new Thread(() -> {
			while (!documentsQueue.isEmpty()) {
				try {
					universities.getUniversityByType(UniversityType.MEDICAL).acceptStudentDocument(documentsQueue);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					universities.getUniversityByType(UniversityType.UNIVERSAL).acceptStudentDocument(documentsQueue);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					universities.getUniversityByType(UniversityType.POLUTECHNICAL).acceptStudentDocument(documentsQueue);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		System.out.println(universities.getUniversityByType(UniversityType.MEDICAL).getStudentsDocuments().toString());
		return getUniversities();
	}
	
	private Universities getUniversities(){
		return universities;
	}

}
