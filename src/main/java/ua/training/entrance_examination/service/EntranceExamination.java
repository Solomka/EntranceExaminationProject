package ua.training.entrance_examination.service;

import java.util.List;

import ua.training.entrance_examination.model.factory.DocumentsStorage;
import ua.training.entrance_examination.model.university.MedicalUniversity;
import ua.training.entrance_examination.model.university.PolytechnicalUniversity;
import ua.training.entrance_examination.model.university.UniversalUniversity;
import ua.training.entrance_examination.model.university.University;

public class EntranceExamination {

	private ObservableBlockingQueue blockingQueue;
	private QueueFillingObserver fillingObserver;
	
	private List<University> universities;

	private EntranceExamination(DocumentsStorage documentsStorage) {		

		this.blockingQueue = new ObservableBlockingQueue();
		this.fillingObserver = new QueueFillingObserver(blockingQueue, documentsStorage);
		blockingQueue.addObserver(fillingObserver);
		
		setUniversities();

	}
	/*
	 * create 3 threads
	 * TODO: rewrite with factory
	 */
	private void setUniversities(){
		universities.add(new MedicalUniversity());
		universities.add(new PolytechnicalUniversity());
		universities.add(new UniversalUniversity());
	}

	public static void handleDocumentsQueue(DocumentsStorage documentsStorage) {
		new EntranceExamination(documentsStorage).handleDocumentsQueue();
	}

	private void handleDocumentsQueue() {
		while(!blockingQueue.isEmpty()){
			
		}
		
	}

}
