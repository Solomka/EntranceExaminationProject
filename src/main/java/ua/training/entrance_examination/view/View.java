package ua.training.entrance_examination.view;

import java.util.Objects;
import java.util.Set;

import ua.training.entrance_examination.model.document.Document;
import ua.training.entrance_examination.model.university.University;

public class View {

	public void printUniversity(String universityName, final University university) {
		Objects.requireNonNull(universityName);
		Objects.requireNonNull(university);
		
		printUniversityName(universityName);
		printUniversityStudentsDocuments(university.getStudentsDocuments());
	}

	private void printUniversityName(String universityName) {
		printMessage(universityName);
	}

	private void printUniversityStudentsDocuments(Set<Document> documents){
		StringBuilder stringBuilder = new StringBuilder();

		for (Document document : documents) {
			stringBuilder.append(document.toString()).append(ViewMessage.NEW_LINE);
		}

		printMessage(ViewMessage.DOCUMENTS, ViewMessage.NEW_LINE, stringBuilder.toString());
		
	}

	/**
	 * Shows constructed message
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 */
	public void printMessage(String... messages) {
		String resultedMessage = generateMessageFromParts(messages);
		System.out.println(resultedMessage);
	}

	/**
	 * Generates one message from its parts (one or many)
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 * @return constructed message
	 */
	private String generateMessageFromParts(String... messages) {
		StringBuilder builder = new StringBuilder();

		for (String mgs : messages) {
			builder.append(mgs);
		}
		return builder.toString();
	}

}
