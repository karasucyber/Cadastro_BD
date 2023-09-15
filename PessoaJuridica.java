public class PessoaJuridica  extends Pessoa{
    String cnpj;
    String RazaoSocial;
    PessoaJuridica(int id, String nome, String logradouro,String cidade, String estado, int telefone, String email, String cnpj,String RazaoSocial ){
        super(id, nome, logradouro,cidade,estado,telefone,email);
        this.cnpj = cnpj;
        this.RazaoSocial =  RazaoSocial;
    }

    public String getCnpj(){
        return  cnpj;
    }

    public String setCnpj(String cnpj){
        return  this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public String setRazaoSocial(String RazaoSocial){
        return  this.RazaoSocial ;

    }

    @Override
    public String toString(){ return "id: " +  id + "nome: " + nome + "Logradouro: " +  "Cidade: " + cidade + "Estado: " + estado + "Telefone: " + Telefone + "email: " + email + "Cpf: " + cnpj + " razao social " + RazaoSocial;}
}

