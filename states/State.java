package states;

import main.QuiosqueContext;

public interface State {
    public void setContext(QuiosqueContext context);
    public void changeState(State state);
    public void executeStateActions();
    
}
