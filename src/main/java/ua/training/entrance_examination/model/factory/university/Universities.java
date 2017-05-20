package ua.training.entrance_examination.model.factory.university;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ua.training.entrance_examination.model.university.University;
import ua.training.entrance_examination.model.university.UniversityType;

public class Universities {

	private UniversityFactory universityFactory;
	private Map<UniversityType, University> universities;

	public Universities(UniversityType... universitiesTypes) {
		this.universityFactory = new UniversityFactoryImpl();
		this.universities = new HashMap<>();

		addUniversities(universitiesTypes);
	}

	private void addUniversities(UniversityType... universitiesTypes) {
		for (UniversityType universityType : universitiesTypes) {
			universities.put(universityType, universityFactory.createUniversity(universityType));
		}

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

	public int size() {
		return universities.size();
	}

	public int getUniversityAcceptedDocumentsNumber(UniversityType universityType) {
		return getUniversityByType(universityType).getNumberOfAcceptedDocuments();
	}

}
