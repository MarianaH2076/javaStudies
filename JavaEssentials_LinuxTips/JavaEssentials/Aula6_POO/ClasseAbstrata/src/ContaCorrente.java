class ContaCorrente extends Conta{


    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo é de 1234");
    }

    @Override
    public void fazerPix() {
        System.out.println("Digite o valor que deseja transferir");
    }
}
