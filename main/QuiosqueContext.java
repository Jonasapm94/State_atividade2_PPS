package main;

import models.Aluno;
import models.CreditCard;
import models.MiniCurso;
import repositories.AlunoRepository;
import repositories.MiniCursoRepository;
import states.State;

public class QuiosqueContext{
    private State state;
    private Aluno aluno;
    private String matricula;
    private CreditCard card;
    private MiniCurso miniCursoSelecionado;
    private boolean retirouTicket = false;
    private MiniCursoRepository miniCursoRepository = new MiniCursoRepository();

    // repositório de alunos
    private AlunoRepository alunoRepository = new AlunoRepository();

    public QuiosqueContext(State initialState){
        this.state = initialState;
        state.setContext(this);
    }

    public State getState(){
        return this.state;
    }

    public void setState(State state){
        state.setContext(this);
        this.state = state;
    }

    public Aluno getAluno(){
        return this.aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    public void setMiniCursoSelecionado(MiniCurso curso){
        this.miniCursoSelecionado = curso;
    }

    public AlunoRepository getAlunoRepository(){
        return this.alunoRepository;
    }

    public void start(){

        for (int i=0; i< 10; i++){
            state.executeStateActions();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public String getMatricula() {
        //método para pegar a matrícula que o usuário inserir no painel.
        
        //neste momento retornando um valor mock (valores de matrícula que autorizam 
        //passagem para próximo estado são: "20202370008" e "20202370010")
        this.matricula = "20202370008";
        
        return this.matricula;
    }

    public CreditCard getCreditCard(){
        //método para pegar o cartão que o usuário inserir no quiosque.
        //para um cartão ser válido, é necessário que o número tenho 8 dígitos, o cvv 3 e o limite seja maior que zero
        
        //neste momento retornando um valor mock
        CreditCard mockCard = new CreditCard("12345678", "Jonas A", "111", 300);
        this.card = mockCard;
       
        return this.card;
    }

    public boolean retirouTicket(){
        //método que retorna se o usuário retirou o ticket impresso do quiosque. 
        
        //neste momento retornando um valor mock   
        this.retirouTicket = true;

        return this.retirouTicket;
    }

    public boolean hasAluno() {
        if (this.aluno != null){
            return true;
        }
        return false;
    }

    public MiniCursoRepository getMiniCursoRepository(){
        return this.miniCursoRepository;
    }

    public void cleanContext(){
        this.aluno = null;
        this.matricula = null;
        this.card = null;
        this.miniCursoSelecionado = null;
    }

    public MiniCurso getMiniCursoSelecionado(){
        return this.miniCursoSelecionado;
    }

}