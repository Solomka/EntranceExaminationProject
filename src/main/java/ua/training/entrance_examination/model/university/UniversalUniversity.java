package ua.training.entrance_examination.model.university;

import java.util.Random;

import ua.training.entrance_examination.constants.GlobalConstants;
import ua.training.entrance_examination.service.ObservableDocumentsBlockingQueue;

public class UniversalUniversity extends University {

	@Override
	public void acceptStudentDocument(ObservableDocumentsBlockingQueue documentsQueue) throws InterruptedException {

		int documentsNumber = rand(GlobalConstants.MIN_UNIVERSAL_UNIVERSITY_DOCUMENTS_NUM,
				GlobalConstants.MAX_UNIVERSAL_UNIVERSITY_DOCUMENTS_NUM);

		int i = 0;

		while (!documentsQueue.isEmpty() && i < documentsNumber) {
			getStudentsDocuments().add(documentsQueue.getDocument());
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
