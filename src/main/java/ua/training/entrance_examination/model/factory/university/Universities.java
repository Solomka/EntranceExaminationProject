package ua.training.entrance_examination.model.factory.university;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ua.training.entrance_examination.model.university.University;
import ua.training.entrance_examination.model.university.UniversityType;

public class Universities {

	private UniversityFactory universityFactory;
	private Map<UniversityType, University> universities;

	public Universities() {
		this.universityFactory = new UniversityFactoryImpl();
		this.universities = new HashMap<>();

		addUniversities();
	}

	private void addUniversities() {
		universities.put(UniversityType.MEDICAL, universityFactory.createUniversity(UniversityType.MEDICAL));
		universities.put(UniversityType.UNIVERSAL, universityFactory.createUniversity(UniversityType.UNIVERSAL));
		universities.put(UniversityType.POLUTECHNICAL,
				universityFactory.createUniversity(UniversityType.POLUTECHNICAL));
	}

	public University getUniversityByType(UniversityType universityType) {
		return universities.get(universityType);
	}

	public Set<University> getUniversities() {
		return (Set<University>) universities.values();
	}
	public Set<UniversityType> getUniversitiesTypes() {
		return universities.keySet();
	}

	

}
