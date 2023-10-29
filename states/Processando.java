package states;

import main.QuiosqueContext;
import models.MiniCurso;

public class Processando implements State {
    
    private QuiosqueContext context;
    private MiniCurso cursoSelecionado;

    public Processando(){
        System.out.println("\nentrou no estado de Processando.");
    }

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

    public void _executeStateActions() {
        this.cursoSelecionado = this.context.getMiniCursoSelecionado();
        System.out.println("Insira um cartão de crédito válido.");
        if (this.context.getCreditCard().isValid()){
            if (this.context.getCreditCard().buySomethingReturnBool(cursoSelecionado.getPreco())){
                System.out.println("Compra realizada!");
                changeState(new Inscrito());
            } else {
                System.out.println("Cartão informado não possui limite para compra.");
                this.context.cleanContext();
                changeState(new EmEspera());
            }
        } else {
            System.out.println("Cartão inválido. Não autorizado.");
            this.context.cleanContext();
            changeState(new EmEspera());
        }

    }
    
}
