package states;
import main.QuiosqueContext;
import models.Aluno;

public class EmEspera implements State {

    private QuiosqueContext context;

    public void setAluno(Aluno aluno){
        this.context.setAluno(aluno);
    }

    public EmEspera(){
        System.out.println("\nEntrou no estado de Em Espera");
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState(State state) {
        this.context.setState(state);
    }

    public Aluno getAlunoByMatricula(String matricula) {
        Aluno aluno = this.context.getAlunoRepository().getAlunoByMatricula(matricula);
        if (aluno!= null){
            return aluno;
        }
        return null;
    }

    @Override
    public void executeStateActions(){
        //método criado para melhorar a visualização do console e simular pausas no processamento do quiosque.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        _executeStateActions();
    }

    public void _executeStateActions() {
        System.out.println("Digite sua matrícula");
        String matricula = this.context.getMatricula();
        System.out.println("Matrícula informada: " + matricula);
        setAluno(getAlunoByMatricula(matricula));
        if (context.hasAluno()){
            changeState(new Identificado());
        } else {
            System.out.println("Aluno de matrícula " + matricula + " não encontrado no repositório. Acesso negado.");
        }

    }
}
