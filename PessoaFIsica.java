public class PessoaFIsica extends Pessoa{
String cpf ;
    public PessoaFIsica(int id, String  nome,
                        String logradouro,
                        String cidade,
                        String estado,
                        int telefone,
                        String email ) {
        super(id,
                nome,
                logradouro,
                cidade,
                estado,
                telefone,
                email);
        this.cpf = cpf;

    }

    public String getCpf(){
        return cpf;
    }
    public String setCpf(String cpf){
      return   this.cpf = cpf;
    }



@Override
    public String toString(){ return "id: " +  id + "nome: " + nome + "Logradouro: " +  "Cidade: " + cidade + "Estado: " + estado + "Telefone: " + telefone + "email: " + email + "Cpf: " + cpf ;}
}
