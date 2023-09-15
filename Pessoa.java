abstract class  Pessoa {
    int id;
String nome;
String logradouro;
String cidade;
String estado;
int Telefone;
String email;


public  Pessoa(int id, String nome, String logradouro,String cidade,String estado, int Telefone,String email){
 this.id = id;
 this.nome = nome;
 this.logradouro = logradouro;
 this.cidade = cidade;
 this.estado = estado;
 this.Telefone = Telefone;
 this.email = email;
}

public int getId(){ return id; }
public void setId(int id){ this.id = id; }

public String getNome(){ return nome ; }

public void setNome(String nome){ this.nome = nome; }

 public String getlogradouro(){return  logradouro;}
 public void setlogradouro(String logradouro){this.logradouro = logradouro; }

public String getCidade(){return cidade;}
 public void setCidade(String cidade ){ this.cidade = cidade; };

public String getEstado(){ return  estado;};
public void setEstado(String estado){ this.estado = estado;} ;
public int getTelefone( ){return Telefone; }
 public void setTelefone(int Telefone){ this.Telefone = Telefone;}

 public String getEmail(){ return  email;}
public void  setEmail(String email){
 this.email = email;
}



}
