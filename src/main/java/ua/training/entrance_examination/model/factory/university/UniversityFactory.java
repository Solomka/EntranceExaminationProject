package ua.training.entrance_examination.model.factory.university;

import ua.training.entrance_examination.model.university.University;
import ua.training.entrance_examination.model.university.UniversityType;

public interface UniversityFactory {
	
	University createUniversity(UniversityType universityType);
}
