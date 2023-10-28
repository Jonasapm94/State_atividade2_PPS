public class Identificado implements State {

    private QuiosqueContext context;

    
    public Identificado(){
        System.out.println("Matrícula válida. Aluno identificado");
        System.out.println("Entrou no estado de Identificado");
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState() {
        this.context.setState(new Processando());
    }

    @Override
    public void executeStateActions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeStateActions'");
    }
    
}
