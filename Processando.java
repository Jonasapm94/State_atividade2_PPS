public class Processando implements State {
    
    private QuiosqueContext context;
    private MiniCurso cursoSelecionado;
    private CreditCard card;

    public Processando(){
        System.out.println("entrou no estado de Processando.");
        this.cursoSelecionado = this.context.getMiniCursoSelecionado();
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState() {
        this.context.setState(new Inscrito());
    }

    @Override
    public void executeStateActions() {
        System.out.println("Insira um cartão de crédito válido.");
        CreditCard cartão = new CreditCard();
    }
    
}
