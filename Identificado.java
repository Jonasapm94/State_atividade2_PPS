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
        System.out.println(this.context.getMiniCursoRepository().toString());
        int i = 0;
        MiniCurso curso = this.context.getMiniCursoRepository().getMiniCursoByIndex(i);
        if (curso != null){
            System.out.println("Usuário escolheu curso "+ curso.getNome());
            this.context.setMiniCursoSelecionado(curso);
            changeState();
        } else {
            System.out.println("Curso inexistente. Tente novamente.");
        }
    }
    
}
