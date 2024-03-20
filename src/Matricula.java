import java.time.LocalDate;

public class Matricula {

	private Aluno aluno;
	private Curso curso;
	private LocalDate Datamatricula;
	
	
	public Matricula(Aluno aluno, Curso curso, LocalDate datamatricula) {
		this.aluno = aluno;
		this.curso = curso;
		Datamatricula = datamatricula;
	}
	
	
	
}
