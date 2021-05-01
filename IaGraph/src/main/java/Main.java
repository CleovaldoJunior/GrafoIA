import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

class Main extends Canvas implements ActionListener {
    private static JButton gSimples;
    private static JButton gMulti;
    private static JButton gValorado;
    private static JFrame frameInicio;
    private static JFrame frameGrafo;
    private static Graph<Integer, DefaultEdge> g;
    private static JButton mostraGrafo;

    private static JLabel quantidadeVertices;
    private static JButton addVertice;
    private static JTextField verticeInput;

    private static JLabel quantidadeAresta;
    private static JButton addAresta;
    private static JTextField arestaInput1;
    private static JTextField arestaInput2;

    public void janela() {
        frameInicio = new JFrame("Grafo Generator");
        frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicio.setSize(1000, 200);

        frameGrafo = new JFrame("Grafo");
        frameGrafo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGrafo.setSize(1000, 200);

        JPanel panelInicio = new JPanel();
        JPanel panelGrafo = new JPanel();

        gSimples = new JButton("Criar Grafo Simples");
        gMulti = new JButton("Criar MultiGrafo");
        gValorado = new JButton("Criar Grafo Valorado");

        mostraGrafo = new JButton("Mostra Grafo");

        gSimples.addActionListener(this);
        gMulti.addActionListener(this);
        gValorado.addActionListener(this);
        mostraGrafo.addActionListener(this);

        verticeInput = new JTextField(10);
        addVertice = new JButton("Adicionar Vertice");
        quantidadeVertices = new JLabel("");
        addVertice.addActionListener(this);

        arestaInput1 = new JTextField(5);
        arestaInput2 = new JTextField(5);
        addAresta = new JButton("Adicionar Aresta");
        quantidadeAresta = new JLabel("");
        addAresta.addActionListener(this);


        panelInicio.add(gSimples);
        panelInicio.add(gMulti);
        panelInicio.add(gValorado);

        panelGrafo.add(verticeInput);
        panelGrafo.add(addVertice);
        panelGrafo.add(quantidadeVertices);

        panelGrafo.add(arestaInput1);
        panelGrafo.add(arestaInput2);
        panelGrafo.add(addAresta);
        panelGrafo.add(quantidadeAresta);

        panelGrafo.add(mostraGrafo);

        frameInicio.getContentPane().add(BorderLayout.NORTH, panelInicio);
        frameGrafo.getContentPane().add(BorderLayout.NORTH, panelGrafo);
        frameGrafo.setVisible(false);
        frameInicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gSimples){
            g = Grafo.criaGrafoRegular();
            frameInicio.setVisible(false);
            frameGrafo.setVisible(true);
        }else if(e.getSource() == gMulti){
            g = Grafo.criaMultiGrafo();
            frameInicio.setVisible(false);
            frameGrafo.setVisible(true);
        }else if(e.getSource() == gValorado){
            g = Grafo.criaGrafoValorado();
            frameInicio.setVisible(false);
            frameGrafo.setVisible(true);
        }else if(e.getSource() == addVertice){
            String vertInput = verticeInput.getText();
            Grafo.addVertice(g, Integer.parseInt(vertInput));
            Set<Integer> qVer = Grafo.quantidadeVertices(g);
            quantidadeVertices.setText(qVer.toString());
        }else if(e.getSource() == addAresta){
            String areInput1 = arestaInput1.getText();
            String areInput2 = arestaInput2.getText();
            Grafo.addAresta(g, Integer.parseInt(areInput1), Integer.parseInt(areInput2));
            Set<DefaultEdge> qAre = Grafo.quantidadeArestas(g);
            quantidadeAresta.setText(qAre.toString());
            Grafo.buscaLargura(g, Integer.parseInt(areInput1));
            System.out.println();
            //Grafo.buscaProfundidade(g, Integer.parseInt(areInput1));
        }else if(e.getSource() == mostraGrafo){
            try {
                Grafo.mostraGrafo(g);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            MyCanvas m=new MyCanvas();
            JFrame f=new JFrame();
            f.add(m);
            f.setSize(400,400);
            f.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Main gui = new Main();
        gui.janela();
    }
}