package ua.training.entrance_examination.model.document;

public abstract class Document {
	private StudentSpeciality studentSpecialty;

	public Document(StudentSpeciality studentSpecialty) {
		this.studentSpecialty = studentSpecialty;
	}

	public StudentSpeciality getStudentSpecialty() {
		return studentSpecialty;
	}

	@Override
	public String toString() {
		return "Document [studentSpecialty=" + studentSpecialty + "]";
	}
	
	
}
