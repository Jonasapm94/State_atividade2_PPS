import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoRepository {
    private List<Aluno> alunos;
    //mock
    private Aluno alunoTeste1 = new Aluno("20202370008");
    private Aluno alunoTeste2 = new Aluno("20202370010");

    AlunoRepository(){
        alunos = new ArrayList<Aluno>();
        alunos.add(alunoTeste1);
        alunos.add(alunoTeste2);
        System.out.println(alunos.toString());
    }

    public void add(Aluno aluno){
        if (!alunos.stream().anyMatch(a -> a.getMatricula().equals(aluno.getMatricula()))){
            alunos.add(aluno);
        };
    }

    public List<Aluno> getAlunos(){
        return alunos;
    }

    public Aluno getAlunoByMatricula(String matricula){
        List<Aluno> alunos = this.alunos.stream().filter(a -> a.getMatricula().equals(matricula)).collect(Collectors.toList());
        if (alunos.size() > 0){
            return alunos.get(0);
        } else {
            return null;
        }
    }
    
}
