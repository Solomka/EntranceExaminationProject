package ua.training.entrance_examination;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ua.training.entrance_examination.model.factory.university.Universities;
import ua.training.entrance_examination.model.university.UniversityType;

public class UniversitiesTest {

	@Test
	public void testUniversitiesNumber() {
		Universities universities = new Universities(UniversityType.MEDICAL_UNIVERSITY,
				UniversityType.POLYTECHNICAL_UNIVERSITY, UniversityType.UNIVERSAL_UNIVERSITY);

		int expectedUniversitiesNumber = 3;
		int actualUniversitiesNumber = universities.size();

		assertEquals(expectedUniversitiesNumber, actualUniversitiesNumber);
	}

	@Test
	public void testUniversitiesTypes() {
		Universities universities = new Universities(UniversityType.MEDICAL_UNIVERSITY,
				UniversityType.POLYTECHNICAL_UNIVERSITY, UniversityType.UNIVERSAL_UNIVERSITY);

		List<UniversityType> expectedUniversitiesTypes = new ArrayList<>(
				Arrays.asList(UniversityType.POLYTECHNICAL_UNIVERSITY, UniversityType.MEDICAL_UNIVERSITY,
						UniversityType.UNIVERSAL_UNIVERSITY));
		List<UniversityType> actualUniversitiestypes = checkUniversitiesTypes(universities, expectedUniversitiesTypes);

		expectedUniversitiesTypes.removeAll(actualUniversitiestypes);

		assertEquals(0, expectedUniversitiesTypes.size());
	}

	private List<UniversityType> checkUniversitiesTypes(Universities universities,
			List<UniversityType> expectedUniversitiestypes) {

		List<UniversityType> universitiesTypes = new ArrayList<>();
		for (UniversityType universityType : universities.getUniversitiesTypes()) {
			switch (universityType) {
			case POLYTECHNICAL_UNIVERSITY:
				universitiesTypes.add(UniversityType.POLYTECHNICAL_UNIVERSITY);
				break;
			case MEDICAL_UNIVERSITY:
				universitiesTypes.add(UniversityType.MEDICAL_UNIVERSITY);
				break;
			case UNIVERSAL_UNIVERSITY:
				universitiesTypes.add(UniversityType.UNIVERSAL_UNIVERSITY);
				break;
			default:
				break;
			}
		}
		return universitiesTypes;
	}
}
