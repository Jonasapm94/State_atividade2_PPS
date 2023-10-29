public class Inscrito implements State {

    private QuiosqueContext context;

    Inscrito(){
        System.out.println("entrou no estado de Inscrito.");
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeState'");
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

    public void _executeStateActions(){
        
    }
    
}
