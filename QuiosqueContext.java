public class QuiosqueContext{
    private State state;
    private Aluno aluno;
    private String matricula;
    private CreditCard card;

    // repositório de alunos
    private AlunoRepository alunoRepository = new AlunoRepository();

    public QuiosqueContext(State initialState){
        this.state = initialState;
        state.setContext(this);
    }

    public State getState(){
        return this.state;
    }

    public void changeState(){
        this.state.changeState();
    }

    public void setState(State state){
        state.setContext(this);
        this.state = state;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    public AlunoRepository getAlunoRepository(){
        return this.alunoRepository;
    }

    public void start(){

        for (int i=0; i< 10; i++){
            state.executeStateActions();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public String getMatricula() {
        //método para pegar a matrícula que o usuário inserir no painel.
        //neste momento retornando um valor mock
        return "20202370008";
    }

    public boolean hasAluno() {
        if (this.aluno != null){
            return true;
        }
        return false;
    }
}