package ua.training.entrance_examination.model.university;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.model.document.Document;

public class UniversalUniversity extends University {

	@Override
	public void acceptStudentDocument(BlockingQueue<Document> documentsQueue) {
		Objects.requireNonNull(documentsQueue);

		int documentsNumber = rand(GlobalConstants.MIN_UNIVERSAL_UNIVERSITY_DOCUMENTS_NUM,
				GlobalConstants.MAX_UNIVERSAL_UNIVERSITY_DOCUMENTS_NUM);

		int i = GlobalConstants.MIN_UNIVERSAL_UNIVERSITY_DOCUMENTS_NUM;
		while (i < documentsNumber && !documentsQueue.isEmpty()) {
			try {
				getStudentsDocuments().add(documentsQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}

	/**
	 * Generates random int value between minValue (inclusive) and maxValue
	 * (inclusive)
	 * 
	 * @param minValue
	 *            lower range value
	 * @param maxValue
	 *            higher range value
	 * @return random int value within determined bounds
	 */
	private int rand(int minValue, int maxValue) {
		return new Random().nextInt((maxValue - minValue) + 1) + minValue;
	}

}
