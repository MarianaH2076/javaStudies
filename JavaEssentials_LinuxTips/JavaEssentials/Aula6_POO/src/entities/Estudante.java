package entities;

public class Estudante {

    private String name;
    private String stack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String estudar(){
        return "Estou estudando na linux tips agora";
    }

    public void dormir(){

    }

}
