package ua.training.entrance_examination;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.training.entrance_examination.model.factory.document.Documents;

public class DocumentsTest {

	@Test
	public void testDocumentsNumber() {
		Documents documents = new Documents();

		int expectedDocumentsNumber = 450;
		int actualDocumentsNumber = documents.size();

		assertEquals(expectedDocumentsNumber, actualDocumentsNumber);
	}

}
