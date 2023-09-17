import java.util.Random;

public class Pilha {
  private NodePilha Topo;
  private int Tamanho;

  public Pilha(int Tamanho){
    this.Tamanho = Tamanho;
  }

  public boolean pilhaVazia(){

    if(this.Topo == null){
      return true;
    } else{
      return false;
    }
  }

  public boolean pilhaCheia(){
    NodePilha NodeAtual = Topo;
    int contador = 0;

    while(NodeAtual != null){
      contador++;
      NodeAtual = NodeAtual.getProx();
    }

    if(contador == Tamanho){
      return true;
    } else {
      return false;
    }


  }

  public void insere(int valor){
    NodePilha novoNode = new NodePilha();
    novoNode.setDados(valor);

    if(pilhaVazia() == false){
      novoNode.setProx(this.Topo);
      this.Topo = novoNode;
    } else {
      this.Topo = novoNode;
    }
  }

  public void remove(){

    if(pilhaVazia()){
      return;
    }
    else if(Tamanho == 1){
      Topo = null;
    }
    else{
      Topo = Topo.getProx();
    }

  }

  public void imprime(){
    NodePilha nodeAtual = this.Topo;
    int contador = 0;

    while(contador != Tamanho){
      if(nodeAtual != null){
        System.out.println("-> " + nodeAtual.getDados());
      } else {
        System.out.println("-> ");
      }
      if(nodeAtual != null){
        nodeAtual = nodeAtual.getProx();
      }
      contador++;
    }
    System.out.println("");
  }

  public void PreencheComValoresAleatorios(){
    NodePilha nodeAtual = Topo;
    Random random = new Random();
    int valorSorteado = 0;

    for(int i = 0; i < this.Tamanho; i++){
      valorSorteado = random.nextInt(100) + 1;
      insere(valorSorteado);
      if(nodeAtual != null){
        nodeAtual = nodeAtual.getProx();
      }
    }
  }

  public boolean pilhaOrdenada(){

    NodePilha nodeAtual = this.Topo;
    NodePilha nodeComparado = null;
    boolean pilhaOrdenada = true;

    while(nodeAtual.getProx() != null){
      nodeComparado = nodeAtual.getProx();

      if(nodeAtual.getDados() > nodeComparado.getDados()){
        pilhaOrdenada = false;
        return pilhaOrdenada;
      } else {
        pilhaOrdenada = true;
      }

      nodeAtual = nodeComparado;
    }

    return pilhaOrdenada;
  }

  public int pop(){
    NodePilha NodePop = Topo;
    remove();
    return NodePop.getDados();
  }

  public void push(int valor){
    insere(valor);
  }

  public NodePilha getTopo(){
    return Topo;
  }

  public int getTamanho(){
    return Tamanho;
  }
}
