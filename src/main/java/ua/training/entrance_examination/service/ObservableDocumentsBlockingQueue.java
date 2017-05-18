package ua.training.entrance_examination.service;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.document.Document;

public class ObservableDocumentsBlockingQueue extends Observable {

	private BlockingQueue<Document> documentsQueue;

	public ObservableDocumentsBlockingQueue() {
		this(GlobalConstants.MAX_QUEUE_THRESHOLD);
	}

	public ObservableDocumentsBlockingQueue(int capacity) {
		this.documentsQueue = new LinkedBlockingQueue<>(capacity);
	}

	public Document getDocument() throws InterruptedException {

		if (documentsQueue.size() < GlobalConstants.MIN_QUEUE_THRESHOLD) {
			setChanged();
			notifyObservers();
		}

		Document headDocument = documentsQueue.take();
		return headDocument;
	}

	public void setDocument(Document document) {
		documentsQueue.offer(document);
	}

	public BlockingQueue<Document> getDocumentsQueue() {
		return documentsQueue;
	}
	
	public int getDocumentsQueueSize(){
		return documentsQueue.size();
	}
	
	public boolean isEmpty(){
		return documentsQueue.isEmpty();
	}

}
