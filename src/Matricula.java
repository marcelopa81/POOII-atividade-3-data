
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;



public class Matricula {

	private Scanner scanner;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;
    private ArrayList<Matricula> matriculas;
	
	
    public Matricula() {
        scanner = new Scanner(System.in);
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

	public void executar() {
        boolean continuar = true;
        while (continuar) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarCurso();
                    break;
                case 3:
                    realizarMatricula();
                    break;
                    
                case 4:
                    realizarMatricula();
                    break;
                    
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
    
    private void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Cadastrar curso");
        System.out.println("3. Realizar matrícula");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void cadastrarAluno() {
        System.out.println("\n--- Cadastro de Aluno ---");
        System.out.print("Digite o número de matrícula do aluno: ");
        int numeroMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento do aluno (Formato: YYYY-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        Aluno aluno = new Aluno(numeroMatricula, nome, dataNascimento);
        alunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso.");
    }
    private void cadastrarCurso() {
        System.out.println("\n--- Cadastro de Curso ---");
        System.out.print("Digite o nome do curso: ");
        String nomeCurso = scanner.next();
        System.out.print("Digite o código do curso: ");
        int codigoCurso = scanner.nextInt();
        System.out.print("Digite a data de início do curso no formato (yyyy-mm-dd): ");
        String dataInicioCursoStr = scanner.next();
        LocalDate dataInicioCurso = LocalDate.parse(dataInicioCursoStr);

        Curso curso = new Curso(codigoCurso, nomeCurso, dataInicioCurso);
        cursos.add(curso);
        System.out.println("Curso cadastrado com sucesso.");
    }

    private void realizarMatricula() {
    	System.out.println("\n--- Realizar Matrícula ---");

        if (alunos.isEmpty() || cursos.isEmpty()) {
            System.out.println("Não há alunos ou cursos cadastrados. Por favor, cadastre pelo menos um aluno e um curso.");
            return;
        }

        System.out.println("Lista de alunos:");
        listarAlunos();

        System.out.print("Digite o número de matrícula do aluno: ");
        int numeroMatriculaAluno = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Aluno alunoSelecionado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getNumeroMatricula() == numeroMatriculaAluno) {
                alunoSelecionado = aluno;
                break;
            }
        }

        if (alunoSelecionado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        // Verifica se o aluno tem mais de 18 anos
        int idadeAluno = alunoSelecionado.calcularIdade();
        if (idadeAluno < 18) {
            System.out.println("O aluno selecionado não tem 18 anos ou mais. Não é possível realizar a matrícula.");
            return;
        }

        System.out.println("Lista de cursos:");
        listarCursos();

        System.out.print("Digite o código do curso: ");
        int codigoCurso = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Curso cursoSelecionado = null;
        for (Curso curso : cursos) {
            if (curso.getCodigoCurso() == codigoCurso) {
                cursoSelecionado = curso;
                break;
            }
        }

        if (cursoSelecionado == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        // Realiza a matrícula
        LocalDate dataMatricula = LocalDate.now();
        Matricula matricula = new Matricula();
        matriculas.add(matricula);

        System.out.println("Matrícula realizada com sucesso.");
    }

    private void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("Número de matrícula: " + aluno.getNumeroMatricula() + ", Nome: " + aluno.getNome());
            }
        }
    }

    private void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            for (Curso curso : cursos) {
                System.out.println("Código do curso: " + curso.getCodigoCurso() + ", Nome do curso: " + curso.getNomeCurso());
            }
        }
    }

	
}
