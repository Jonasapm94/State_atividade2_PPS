public class QuiosqueContext{
    private State state;

    public QuiosqueContext(State initialState){
        this.state = initialState;
        state.setContext(this);
    }

    public State getState(){
        return this.state;
    }

    public void changeState(){
        this.state.changeState();
    }

    public void setState(State state){
        state.setContext(this);
        this.state = state;
    }
}