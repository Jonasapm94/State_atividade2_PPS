public class Identificado implements State {

    private Aluno aluno;

    public Identificado(Aluno aluno){
        this.aluno = aluno;
    }
    
    public Identificado(){
        System.out.println("Matrícula válida. Aluno identificado");
        System.out.println("entrou no estado de Identificado");
    }

    @Override
    public void setContext(QuiosqueContext context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContext'");
    }

    @Override
    public void changeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeState'");
    }
    
}
