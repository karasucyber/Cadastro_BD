abstract class  Pessoa {
    int id;
String nome;
String logradouro;
String cidade;
String estado;
int telefone;
String email;


public  Pessoa(int id, String nome, String logradouro,String cidade,String estado, int telefone,String email){
 this.id = id;
 this.nome = nome;
 this.logradouro = logradouro;
 this.cidade = cidade;
 this.estado = estado;
 this.telefone = telefone;
 this.email = email;
}

public int getId(){ return id; }
public void setId(int id){ this.id = id; }

public String getNome(){ return nome ; }

public void setNome(){ this.nome = nome; }

 public String getLogradouro(){return  logradouro;}
 public void set(){this.logradouro = logradouro; }

public String getCidade(){return cidade;}
 public void setCidade(String cidade ){ this.cidade = cidade; };

public String getEstado(){ return  estado;};
public void setEstado(String estado){ this.estado = estado;} ;
public int getTelefone( ){return telefone; }
 public void setTelefone(int telefone){ this.telefone = telefone;}

 public String getEmail(){ return  email;}
public void  setEmail(String email){
 this.email = email;
}



}
