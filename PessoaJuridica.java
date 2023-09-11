public class PessoaJuridica  extends Pessoa{
    String cnpj;
    PessoaJuridica(int id, String nome, String logradouro,String cidade, String estado, int telefone, String email, String cnpj ){
        super(id, nome, logradouro,cidade,estado,telefone,email);
        this.cnpj = cnpj;
    }

    @Override
    public String toString(){ return "id: " +  id + "nome: " + nome + "Logradouro: " +  "Cidade: " + cidade + "Estado: " + estado + "Telefone: " + telefone + "email: " + email + "Cpf: " + cnpj ;}
}

