import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void menu(int escolha){
        if(escolha == 0){
            System.out.println("1 -> Grafo Regular" +
                    "\n2 -> Árvore" +
                    "\n3 -> Grafo Completo" +
                    "\n4 -> Multigrafo" +
                    "\n5 -> Grafo Bipratido" +
                    "\n6 -> Grafo Rotulado" +
                    "\n7 -> Grafo Valorado" +
                    "\n0 -> Sair\n");
        }
        else if(escolha == 1){
            System.out.println();
            System.out.println("1 -> Adicionar Vertice" +
                    "\n2 -> Remover Vertice" +
                    "\n3 -> Adicionar Aresta" +
                    "\n4 -> Remover Aresta" +
                    "\n5 -> Mostra Vertices"+
                    "\n6 -> Mostra Arestas"+
                    "\n7 -> Mostrar Grafo"+
                    "\n0 -> Sair\n");
        }

    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Graph<Integer, DefaultEdge> g = null;
        System.out.println("Digite qual tipo de grafo você deseja criar:\n");
        menu(0);
        int input = sc.nextInt();
        while(input != 0) {
            if (input == 1) {
                g = Grafo.criaGrafoRegular();
                System.out.println("\n[Grafo regular criado]");
            }
            if(g != null){
                input = -1;
                while(input != 0){
                    if(input == 1){
                        System.out.println("\n[Digite o vertice a ser adicionado]");
                        int vertice = sc.nextInt();
                        Grafo.addVertice(g, vertice);
                    }else if(input == 2){
                        System.out.println("\n[Digite o vertice a ser removido]");
                        int vertice = sc.nextInt();
                        Grafo.removeVertice(g, vertice);
                    }else if(input == 3){
                        System.out.println("\n[Digite o primeiro vertice da aresta]");
                        int vertice1 = sc.nextInt();
                        System.out.println("\n[Digite o segundo vertice da aresta]");
                        int vertice2 = sc.nextInt();
                        Grafo.addAresta(g, vertice1, vertice2);
                    }else if(input == 4){
                        System.out.println("\n[Digite o primeiro vertice]");
                        int vertice1 = sc.nextInt();
                        System.out.println("\n[Digite o segundo vertice]");
                        int vertice2 = sc.nextInt();
                        Grafo.removerAresta(g, vertice1, vertice2);
                    }else if (input == 5){
                        System.out.println(Grafo.quantidadeVertices(g));
                    }else if (input == 6){
                        System.out.println(Grafo.quantidadeArestas(g));
                    }else if (input == 7){
                        Grafo.mostraGrafo(g);
                    }else if (input == 8){
                        System.out.println("[Grafo apagado com sucesso]");
                        g = null;
                        break;
                    }
                    menu(1);
                    input = sc.nextInt();
                }
                g = null;
                menu(0);
            }
            else{
                menu(0);
            }

            input = sc.nextInt();
        }
    }
}

