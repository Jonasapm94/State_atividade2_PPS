import java.util.ArrayList;
import java.util.List;

public class MiniCurso {

    private String nome;
    private double preco;
    private int vagas;
    private List<Aluno> matriculados = new ArrayList<Aluno>();

    public String getNome(){
        return this.nome;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getVagas(){
        return this.vagas;
    }

    MiniCurso(String nome, double d, int vagas){
        this.nome = nome;
        this.preco = d;
        this.vagas = vagas;
    }

    public void matricularAluno(Aluno aluno){
        if (vagas > 0){
            this.matriculados.add(aluno);
            vagas--;
            System.out.println("Matrícula no curso "+ this.nome + " reservada. Aguardando pagamento.");
        } else {
            System.out.println("Não foi possível realizar matrícula no curso "+ this.nome + ". Vagas esgotadas.");
        }
    }

    public void retirarMatricula(Aluno aluno){
        this.matriculados.remove(aluno);
    }
}
