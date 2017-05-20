package ua.training.entrance_examination.view;

import java.util.Objects;

public class View {

	public void printUniversity(String universityName, int universityDocuments) {
		Objects.requireNonNull(universityName);

		printMessage(universityName, ViewMessage.EMPTY_STR, Integer.toString(universityDocuments));
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
