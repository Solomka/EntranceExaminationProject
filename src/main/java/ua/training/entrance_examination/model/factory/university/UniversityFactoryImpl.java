package ua.training.entrance_examination.model.factory.university;

import ua.training.entrance_examination.model.university.MedicalUniversity;
import ua.training.entrance_examination.model.university.PolytechnicalUniversity;
import ua.training.entrance_examination.model.university.UniversalUniversity;
import ua.training.entrance_examination.model.university.University;
import ua.training.entrance_examination.model.university.UniversityType;

public class UniversityFactoryImpl implements UniversityFactory {

	@Override
	public University createUniversity(UniversityType universityType) {
		switch (universityType) {
		case MEDICAL:
			return new MedicalUniversity();
		case UNIVERSAL:
			return new UniversalUniversity();
		case POLUTECHNICAL:
			return new PolytechnicalUniversity();
		default:
			throw new IllegalArgumentException("Such UniversityType doesn't exist");
		}
	}

}
