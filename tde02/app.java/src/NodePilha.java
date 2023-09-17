public class NodePilha {
  private NodePilha Prox;
  private Integer Dados;
  
  public NodePilha(){
    this.Prox = null;
    this.Dados = null;
  }

  public Integer getDados(){
    return this.Dados;
  }

  public void setDados(Integer Dados){
    this.Dados = Dados;
  }

  public NodePilha getProx(){
    return this.Prox;
  }

  public void setProx(NodePilha node){
    this.Prox = node;
  }
}
