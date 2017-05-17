package ua.training.entrance_examination.service;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.factory.DocumentsStorage;

// in new thread
public class QueueFillingObserver implements Observer {

	private ObservableBlockingQueue observableQueue;

	private DocumentsStorage documentsStorage;

	public QueueFillingObserver(ObservableBlockingQueue observableQueue, DocumentsStorage documentsStorage) {
		this.observableQueue = Objects.requireNonNull(observableQueue);
		this.documentsStorage = Objects.requireNonNull(documentsStorage);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (observableQueue == o) {
			fillObservableQueueToMaxThreshold();
		}
	}

	private void fillObservableQueueToMaxThreshold() {

		while (!documentsStorage.isEmpty()
				&& observableQueue.getDocumentsQueueSize() != GlobalConstants.MAX_QUEUE_THRESHOLD) {
			observableQueue.setDocument(documentsStorage.getDocument());
		}
	}
}
