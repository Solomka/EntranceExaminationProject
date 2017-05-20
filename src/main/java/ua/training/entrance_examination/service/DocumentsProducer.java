package ua.training.entrance_examination.service;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.factory.document.Documents;

public class DocumentsProducer extends Thread {

	private BlockingQueue<Document> documentsQueue;
	private Documents documents;

	public DocumentsProducer(BlockingQueue<Document> documentsQueue, Documents documents) {
		this.documentsQueue = Objects.requireNonNull(documentsQueue);
		this.documents = Objects.requireNonNull(documents);
	}

	@Override
	public void run() {
		while (!documents.isEmpty()) {
			if (documentsQueue.size() < GlobalConstants.MIN_QUEUE_THRESHOLD) {
				while (documentsQueue.size() < GlobalConstants.MAX_QUEUE_THRESHOLD && !documents.isEmpty()) {
					try {
						documentsQueue.put(documents.getDocument());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
