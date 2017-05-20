package ua.training.entrance_examination.model.document;

import java.util.Objects;

public class Document {
	private StudentSpeciality studentSpecialty;

	public Document(StudentSpeciality studentSpecialty) {
		this.studentSpecialty = Objects.requireNonNull(studentSpecialty);
	}

	public StudentSpeciality getStudentSpecialty() {
		return studentSpecialty;
	}

	@Override
	public String toString() {
		return "Document [studentSpecialty=" + studentSpecialty + "]";
	}
}
