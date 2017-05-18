package ua.training.entrance_examination.service;

import java.util.Observable;
import java.util.Observer;

// TODO: in new thread
public class QueueFillingObserver implements Observer {

	private DocumentsBlockingQueueFiller documentsBlockingQueueFiller;
	private ObservableDocumentsBlockingQueue observableQueueDocumentsBlockingQueue;

	public QueueFillingObserver(ObservableDocumentsBlockingQueue observableQueueDocumentsBlockingQueue,
			DocumentsBlockingQueueFiller documentsBlockingQueueFiller) {
		this.documentsBlockingQueueFiller = documentsBlockingQueueFiller;
		this.observableQueueDocumentsBlockingQueue = observableQueueDocumentsBlockingQueue;
	}

	@Override
	public void update(Observable o, Object arg) {

		if (observableQueueDocumentsBlockingQueue == o) {
			documentsBlockingQueueFiller.fillObservableQueueToMaxThreshold();
		}
	}

}
