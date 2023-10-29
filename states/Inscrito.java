package states;

import java.text.MessageFormat;

import main.QuiosqueContext;

public class Inscrito implements State {

    private QuiosqueContext context;

    Inscrito(){
        System.out.println("\nentrou no estado de Inscrito.");
        System.out.println("\n...Imprimindo cartão...\n");
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
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
        imprimirCartão();
        System.out.println("\nRetire seu ingresso impresso pelo quiosque.");
        if (this.context.retirouTicket()){
            changeState(new Finalizado());
        }
    }

    @Override
    public void changeState(State state) {
        this.context.setState(state);
    }

    private void imprimirCartão(){
        
        System.out.println(MessageFormat.format("""
        
        --------------------------------        
        ********************************
        --------------------------------
        INGRESSO PARA MINI-CURSOS IFTECH
        Mini-curso {0} 
        Aluno: {1} 
        Valor: R$ {2}
        --------------------------------        
        ********************************
        --------------------------------

                """, this.context.getMiniCursoSelecionado().getNome(), 
                this.context.getAluno().getNome(),
                this.context.getMiniCursoSelecionado().getPreco()));
    }
    
}
