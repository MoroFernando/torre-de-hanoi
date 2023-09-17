import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
    System.out.println("");
    System.out.println("\u001B[34m##########################################################################");
    System.out.println("# TDE 02 - Estrutura de Dados - ALUNOS: \u001B[33mFERNANDO MORO \u001B[34me\u001B[33m GABRIEL HORTMANN\u001B[34m #");
    System.out.println("##########################################################################\u001B[0m");
    System.out.println("");

    Scanner scanner = new Scanner(System.in);

    System.out.print("Para começar o jogo insira o tamanho das PILHAS a serem criadas: \u001B[32m");
    int tamanhoPilhas = scanner.nextInt();
    System.out.println("\u001B[0m");

    Pilha pilha01 = new Pilha(tamanhoPilhas);
    Pilha pilha02 = new Pilha(tamanhoPilhas);
    Pilha pilha03 = new Pilha(tamanhoPilhas);

    pilha01.PreencheComValoresAleatorios();

    System.out.println("\u001B[34m---> Jodo TORRE DE HANOI iniciado: \u001B[0m");
    System.out.println("");
    System.out.println("\u001B[33mOBJETIVO: \u001B[0m");
    System.out.println("\u001B[33m Ordene os números da pilha de forma a ficarem em ordem decrescente(Maior no TOPO)\u001B[0m");
    System.out.println("");
    Thread.sleep(1000);

    boolean fimDeJogo = false;
    int contadorMovimentos = 0;
    while(fimDeJogo != true){

      int escolha = 0;
      int pop = 0;
      int push = 0;

      System.out.println("\u001B[34m------- PILHA 01 -------\u001B[0m");
      System.out.println("");
      pilha01.imprime();

      System.out.println("\u001B[34m------- PILHA 02 -------\u001B[0m");
      System.out.println("");
      pilha02.imprime();

      System.out.println("\u001B[34m------- PILHA 03 -------\u001B[0m");
      System.out.println("");
      pilha03.imprime();

      // CONFERE CONDIÇÕES DE VITÓRIA
      if(pilha01.pilhaCheia()){
        if(pilha01.pilhaOrdenada() == true){
          System.out.println("\u001B[33mPilha 01 ordenada");
          System.out.println("");
          System.out.println("Jogadas feitas: " + contadorMovimentos);
          System.out.println("Fim de jogo! Obrigado por jogar.\u001B[0m");
          System.out.println("");
          fimDeJogo = true;
          break;
        } 
      } 
      else if(pilha02.pilhaCheia()){
        if(pilha02.pilhaOrdenada() == true){
          System.out.println("\u001B[33mPilha 02 ordenada");
          System.out.println("");
          System.out.println("Jogadas feitas: " + contadorMovimentos);
          System.out.println("Fim de jogo! Obrigado por jogar.\u001B[0m");
          System.out.println("");
          fimDeJogo = true;
          break;
        }      
      } 
      else if(pilha03.pilhaCheia()){
        if(pilha03.pilhaOrdenada() == true){
          System.out.println("\u001B[33mPilha 03 ordenada");
          System.out.println("");
          System.out.println("Jogadas feitas: " + contadorMovimentos);
          System.out.println("Fim de jogo! Obrigado por jogar.\u001B[0m");
          System.out.println("");
          fimDeJogo = true;
          break;
        } 
      }

      System.out.println("Digite \u001B[32m\"1\"\u001B[0m para MOVIMENTAR, \u001B[32m\"2\"\u001B[0m para SOLUÇAO AUTOMÁTICA ou \u001B[32m\"0\"\u001B[0m para SAIR \u001B[32m");
      escolha = scanner.nextInt();
      System.out.println("");

      if(escolha == 1){
        contadorMovimentos++;
        System.out.println("--> MOVIMENTAR <--");
        System.out.println("\u001B[0m");
        boolean escolhaPop = true;
        boolean escolhaPush = true;
        int valorPop = 0;

        while(escolhaPop){
          System.out.print("Digite o número da PILHA que deseja \u001B[32mRETIRAR\u001B[0m o valor: \u001B[32m");
          pop = scanner.nextInt();
          System.out.println("\u001B[0m");

          if((pop == 1 && pilha01.pilhaVazia()) || (pop == 2 && pilha02.pilhaVazia()) || (pop == 2 && pilha02.pilhaVazia())){
            System.out.println("\u001B[31mEsta pilha está VAZIA, escolha uma pilha que possua valores...\u001B[0m");
            Thread.sleep(1000);
            System.out.println("");
          }
          else if(pop != 1 && pop != 2 && pop != 3){
            System.out.println("\u001B[31mEsta pilha não existe\u001B[0m");
            Thread.sleep(1000);
            System.out.println("");
          }
          else{
            escolhaPop = false;

            switch(pop){
              case 1:
                valorPop = pilha01.pop();
                break;
              case 2:
                valorPop = pilha02.pop();
                break;
              case 3:
                valorPop = pilha03.pop();
                break;
            }

            while(escolhaPush){
              System.out.print("Digite o número da PILHA que deseja \u001B[32mINSERIR\u001B[0m o valor: \u001B[32m");
              push = scanner.nextInt();
              System.out.println("\u001B[0m");

              if(push != 1 && push != 2 && push != 3){
                System.out.println("\u001B[31mEsta pilha não existe\u001B[0m");
                Thread.sleep(1000);
                System.out.println("");
              }
              else{
                escolhaPush = false;
                switch(push){
                  case 1:
                    pilha01.push(valorPop);
                    break;
                  case 2:
                    pilha02.push(valorPop);
                    break;
                  case 3:
                    pilha03.push(valorPop);
                    break;
                }

                System.out.println("Valor movido com sucesso!");
                System.out.println("");
              }

            }


          }
        }

      }
      else if(escolha == 2){
        System.out.println("--> SOLUÇÃO AUTOMÁTICA <--");
        System.out.println("");

        
      }
      else if(escolha == 0){
        System.out.println("\u001B[33mFim de jogo! Obrigado por jogar.\u001B[0m");
        System.out.println("");
        fimDeJogo = true;
        break;
      }
      else{
        System.out.println("\u001B[31m* digite uma opção válida...*\u001B[0m");
        Thread.sleep(1000);
        System.out.println("");
        continue;
      }
  }
  }
}