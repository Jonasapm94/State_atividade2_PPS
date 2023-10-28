public class Processando implements State {
    
    private QuiosqueContext context;

    public Processando(){
        System.out.println("entrou no estado de Processando");
        System.out.println("");
    }

    @Override
    public void setContext(QuiosqueContext context) {
        this.context = context;
    }

    @Override
    public void changeState() {
        this.context.setState(new Inscrito());
    }
    
}
