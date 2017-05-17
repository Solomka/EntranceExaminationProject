package ua.training.entrance_examination.model.document;

public enum StudentSpeciality {

	BIOLOGIST(1), MATHEMATICIAN(2);

	private int value;

	StudentSpeciality(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static StudentSpeciality getStudentSpecialtyByValue(int value) {
		for (final StudentSpeciality studentSpeciality : StudentSpeciality.values()) {
			if (studentSpeciality.getValue() == value) {
				return studentSpeciality;
			}
		}
		throw new IllegalArgumentException("StudentSpecility with such value doesn't exist");
	}

}
