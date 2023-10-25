public class EmEspera implements State {

    private QuiosqueContext context;
    private Aluno aluno;

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    public EmEspera(){
        System.out.println("usuário insere a matrícula 20202370008");
        
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState() {
        // if (this.aluno != null){
        // }
        this.context.setState(new Identificado());
    }
    
}
