package ua.training.entrance_examination.service;

import java.util.Objects;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.factory.document.Documents;

public class DocumentsBlockingQueueFiller {

	private ObservableDocumentsBlockingQueue observableQueue;

	private Documents documentsStorage;

	public DocumentsBlockingQueueFiller(ObservableDocumentsBlockingQueue observableQueue, Documents documentsStorage) {
		this.observableQueue = Objects.requireNonNull(observableQueue);
		this.documentsStorage = Objects.requireNonNull(documentsStorage);
	}

	
	public void fillObservableQueueToMaxThreshold() {
		while (!documentsStorage.isEmpty()
				&& observableQueue.getDocumentsQueueSize() != GlobalConstants.MAX_QUEUE_THRESHOLD) {
			observableQueue.setDocument(documentsStorage.getDocument());
		}

	}

}
