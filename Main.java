public class Main{
    public static void main (String args[]){
        System.out.println("teste tudo\n\n");

        State initialState = new EmEspera();
        QuiosqueContext quiosque = new QuiosqueContext(initialState);

        quiosque.start();

    }
}