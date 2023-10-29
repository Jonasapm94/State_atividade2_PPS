package states;
import main.QuiosqueContext;

public class Finalizado implements State {

    private QuiosqueContext context;

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState(State state) {
        this.context.setState(state);
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

    private void _executeStateActions() {
        System.out.println("""
                
        -----------------
        COMPRA FINALIZADA
        -----------------
                """);
        this.context.cleanContext();
        changeState(new EmEspera());
    }


    
}
