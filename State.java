public interface State {
    public void setContext(QuiosqueContext context);
    public void changeState();
    public void executeStateActions();
    
}
