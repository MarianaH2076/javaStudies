class ContaPoupanca implements Conta{


    @Override
    public void consultarSaldo() {
        System.out.println("O saldo de sua conta é 0");
    }

    @Override
    public void fazerPix() {
        System.out.println("Deu ruim :(");
    }
}
