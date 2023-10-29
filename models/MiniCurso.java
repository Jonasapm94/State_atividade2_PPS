package models;
import java.util.ArrayList;
import java.util.List;

public class MiniCurso {

    private String nome;
    private float preco;
    private int vagas;
    private List<Aluno> matriculados = new ArrayList<Aluno>();

    public String getNome(){
        return this.nome;
    }

    public float getPreco(){
        return this.preco;
    }

    public int getVagas(){
        return this.vagas;
    }

    public List<Aluno> getMatriculados(){
        return this.matriculados;
    }

    public MiniCurso(String nome, float preco, int vagas){
        this.nome = nome;
        this.preco = preco;
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
