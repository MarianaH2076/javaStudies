package entities;

public class PessoaDesenvolvedora {

    private String name;
    private String stack;
    private Double salario;

    public PessoaDesenvolvedora(String name, String stack, Double salario) {
        this.name = name;
        this.stack = stack;
        this.salario = salario;
    }

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void codar() {
        System.out.println("Bora codar!");
    }

}
