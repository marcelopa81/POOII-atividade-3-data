
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
	
	private int numeroMatricula;
	private String nome;
	private LocalDate dataNascimento;

	
	public Aluno(int numeroMatricula, String nome, LocalDate dataNascimento) {
		this.numeroMatricula = numeroMatricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}


	public int getNumeroMatricula() {
		return numeroMatricula;
	}


	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	@Override
	public String toString() {
		return "Aluno [numeroMatricula=" + numeroMatricula + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ "]";
	}
	
	 public int calcularIdade() {
	        LocalDate dataAtual = LocalDate.now();
	        return Period.between(dataNascimento, dataAtual).getYears();
	    }
		

}
