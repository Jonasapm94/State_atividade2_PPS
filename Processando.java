public class Processando implements State {
    
    private QuiosqueContext context;
    private MiniCurso cursoSelecionado;
    private CreditCard card;

    public Processando(){
        System.out.println("entrou no estado de Processando.");
        
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
        this.cursoSelecionado = this.context.getMiniCursoSelecionado();
        System.out.println("Insira um cartão de crédito válido.");
        this.card = new CreditCard("12345678", "Jonas A", "111", 300);
        if (this.card.isValid()){
            if (this.card.buySomethingReturnBool(cursoSelecionado.getPreco())){
                System.out.println("Compra realizada!");
                changeState();
            } else {
                System.out.println("Cartão informado não possui limite para compra.");
            }
        } else {
            System.out.println("Cartão inválido. Insira outro cartão.");
        }

    }
    
}
