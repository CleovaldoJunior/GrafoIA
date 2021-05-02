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
    private static JPanel panelInicio;
    private static JPanel panelGrafoVertice;
    private static JPanel panelGrafoAresta;
    private static JPanel panelGrafoMix;
    private static JPanel panelGrafo;

    private static JButton gSimples = null;
    private static JButton gMulti = null;
    private static JButton gValorado;
    private static JFrame frameInicio;
    private static JFrame frameGrafo;
    private static Graph<String, DefaultEdge> g;
    private static Graph<String, String> gValor;
    private static JButton mostraGrafo;

    private static JLabel displayVertices;
    private static JButton addVertice;
    private static JButton removeVertice;
    private static JTextField verticeInputRemove;
    private static JTextField verticeInput;
    private static JButton bQuantidadeVertice;

    private static JLabel displayAresta;
    private static JButton addAresta;
    private static JButton removeAresta;
    private static JTextField arestaValorInputRemove;
    private static JTextField arestaInput1Remove;
    private static JTextField arestaInput2Remove;
    private static JTextField arestaInput1;
    private static JTextField arestaInput2;
    private static JTextField arestaValorInput;
    private static JButton bQuantidadeAresta;
    private static JButton voltar;
    private static JButton buscaLargura;
    private static JButton buscaProfundidade;
    private static JTextField buscaLarguraInput;
    private static JTextField buscaProfundidadeInput;

    private static JLabel displayMix;

    public static void add_aresta_panel(int v){
        if(v == 0){
            panelGrafoAresta.add(arestaValorInputRemove);
            panelGrafoAresta.add(arestaValorInput);
            panelGrafoAresta.add(addAresta);
            panelGrafoAresta.add(arestaInput1);
            panelGrafoAresta.add(arestaInput2);
            panelGrafoAresta.add(removeAresta);
            panelGrafoAresta.add(arestaInput1Remove);
            panelGrafoAresta.add(arestaInput2Remove);
            panelGrafoAresta.add(displayAresta);
            panelGrafoAresta.remove(arestaValorInputRemove);
            panelGrafoAresta.remove(arestaValorInput);
        }else if(v==1){
            panelGrafoAresta.add(arestaInput1Remove);
            panelGrafoAresta.add(arestaInput2Remove);
            panelGrafoAresta.add(addAresta);
            panelGrafoAresta.add(arestaInput1);
            panelGrafoAresta.add(arestaInput2);
            panelGrafoAresta.add(arestaValorInput);
            panelGrafoAresta.add(removeAresta);
            panelGrafoAresta.add(arestaValorInputRemove);
            panelGrafoAresta.add(displayAresta);
            panelGrafoAresta.remove(arestaInput1Remove);
            panelGrafoAresta.remove(arestaInput2Remove);
        }
    }

    public void janela() {
        frameInicio = new JFrame("Grafo Generator");
        frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicio.setSize(600, 200);

        frameGrafo = new JFrame("Grafo");
        frameGrafo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGrafo.setSize(600, 200);

        panelInicio = new JPanel();
        panelGrafoVertice = new JPanel(new GridLayout(9, 0,0,0));
        panelGrafoAresta = new JPanel(new GridLayout(9, 0,0,0));
        panelGrafoMix = new JPanel(new GridLayout(9, 0,0,0));
        panelGrafo = new JPanel(new GridLayout(1, 0,2,1));

        gSimples = new JButton("Criar Grafo Simples");
        gMulti = new JButton("Criar MultiGrafo");
        gValorado = new JButton("Criar Grafo Valorado");

        gSimples.addActionListener(this);
        gMulti.addActionListener(this);
        gValorado.addActionListener(this);

        verticeInput = new JTextField();
        verticeInputRemove = new JTextField();
        addVertice = new JButton("Adicionar Vertice");
        removeVertice = new JButton("Remover vertice");
        displayVertices = new JLabel();
        addVertice.addActionListener(this);
        removeVertice.addActionListener(this);

        arestaInput1 = new JTextField();
        arestaInput2 = new JTextField();
        arestaValorInput = new JTextField();
        arestaInput1Remove = new JTextField();
        arestaInput2Remove = new JTextField();
        arestaValorInputRemove = new JTextField();
        addAresta = new JButton("Adicionar Aresta");
        removeAresta = new JButton("Remover Aresta");
        displayAresta = new JLabel();
        addAresta.addActionListener(this);
        removeAresta.addActionListener(this);

        displayMix = new JLabel();
        mostraGrafo = new JButton("Mostra Grafo");
        bQuantidadeAresta = new JButton("Mostrar Arestas");
        bQuantidadeVertice = new JButton("Mostrar Vertices");
        voltar = new JButton("Voltar");
        buscaLargura = new JButton("Busca em Largura");
        buscaProfundidade = new JButton("Busca em Profundidade");
        buscaProfundidadeInput = new JTextField();
        buscaLarguraInput = new JTextField();
        buscaProfundidade.addActionListener(this);
        buscaLargura.addActionListener(this);
        mostraGrafo.addActionListener(this);
        bQuantidadeVertice.addActionListener(this);
        bQuantidadeAresta.addActionListener(this);
        voltar.addActionListener(this);

        panelGrafoMix.add(mostraGrafo);
        panelGrafoMix.add(bQuantidadeAresta);
        panelGrafoMix.add(bQuantidadeVertice);
        panelGrafoMix.add(buscaProfundidade);
        panelGrafoMix.add(buscaProfundidadeInput);
        panelGrafoMix.add(buscaLargura);
        panelGrafoMix.add(buscaLarguraInput);
        panelGrafoMix.add(voltar);
        panelGrafoMix.add(displayMix);


        panelInicio.add(gSimples);
        panelInicio.add(gMulti);
        panelInicio.add(gValorado);

        panelGrafoVertice.add(addVertice);
        panelGrafoVertice.add(verticeInput);
        panelGrafoVertice.add(removeVertice);
        panelGrafoVertice.add(verticeInputRemove);
        panelGrafoVertice.add(displayVertices);

        panelGrafo.add(panelGrafoVertice);
        panelGrafo.add(panelGrafoAresta);
        panelGrafo.add(panelGrafoMix);

        frameInicio.getContentPane().add(panelInicio, SwingConstants.CENTER);
        frameGrafo.getContentPane().add(panelGrafo, SwingConstants.CENTER);

        frameGrafo.setVisible(false);
        frameInicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gSimples){
            add_aresta_panel(0);
            g = Grafo.criaGrafoRegular();
            frameInicio.setVisible(false);
            frameGrafo.setVisible(true);
        }else if(e.getSource() == gMulti){
            add_aresta_panel(0);
            g = Grafo.criaMultiGrafo();
            frameInicio.setVisible(false);
            frameGrafo.setVisible(true);
        }else if(e.getSource() == gValorado){
            add_aresta_panel(1);
            gValor = Grafo.criaGrafoValorado();
            frameInicio.setVisible(false);
            frameGrafo.setVisible(true);
        }else if(e.getSource() == addVertice){
            String vertInput = verticeInput.getText();
            if (vertInput.equals("")){
                displayVertices.setText("Campo em branco inválido");
            }else{
                try{
                    if(gValor != null && g == null){
                        Grafo.addVerticeValorado(gValor, vertInput);
                    }else if(g != null && gValor == null)
                        Grafo.addVertice(g, vertInput);
                    displayVertices.setText("Vertice "+vertInput+" adicionado!");
                }catch(Exception ex){
                    displayVertices.setText(ex.getMessage());
                }
            }

        }else if(e.getSource() == addAresta){
            String areInput1 = arestaInput1.getText();
            String areInput2 = arestaInput2.getText();
            String valor = arestaValorInput.getText();
            if (areInput1.equals("") | areInput2.equals("")){
                displayAresta.setText("Campo em branco inválido");
            }else{
                try{
                    if(gValor != null && g == null){
                        if(!valor.equals("")){
                            Grafo.addArestaValorada(gValor,areInput1, areInput2, valor);
                            displayAresta.setText("Aresta "+valor+ " adicionada!");
                        }else{
                            displayAresta.setText("Campo em branco inválido");
                        }
                    }else if(g != null && gValor == null){
                        Grafo.addAresta(g,areInput1, areInput2);
                        displayAresta.setText("Aresta "+areInput1+"->"+areInput2+" adicionada!");
                    }
                }catch(Exception ex){
                    displayAresta.setText(ex.getMessage());
                }
            }

        }else if(e.getSource() == mostraGrafo){
            try {
                if(gValor != null && g == null){
                    Grafo.mostraGrafoValorado(gValor);
                }else if(g != null && gValor == null){
                    Grafo.mostraGrafo(g);
                }

            } catch (Exception ex) {
                displayMix.setText(ex.getMessage());
            }
            MyCanvas m=new MyCanvas();
            JFrame f=new JFrame();
            f.add(m);
            f.setSize(400,400);
            f.setVisible(true);
        }else if(e.getSource() == bQuantidadeAresta){
            if(gValor != null && g == null){
                Set<String> qAre = Grafo.quantidadeArestasValorado(gValor);
                displayMix.setText(qAre.toString());
            }else if(g != null && gValor == null){
                Set<DefaultEdge> qAre = Grafo.quantidadeArestas(g);
                displayMix.setText(qAre.toString());
            }


        }else if(e.getSource() == bQuantidadeVertice){

            if(gValor != null && g == null){
                Set<String> qAre = Grafo.quantidadeVerticesValorado(gValor);
                displayMix.setText(qAre.toString());

            }else if(g != null && gValor == null){
                Set<String> qAre = Grafo.quantidadeVertices(g);
                displayMix.setText(qAre.toString());
            }
        }else if(e.getSource() == voltar){
            g = null;
            gValor = null;
            frameInicio.setVisible(true);
            frameGrafo.setVisible(false);
            displayAresta.setText("");
            displayVertices.setText("");
            displayMix.setText("");
            verticeInput.setText("");
            arestaInput1.setText("");
            arestaInput2.setText("");
            arestaValorInput.setText("");
            arestaValorInputRemove.setText("");
            arestaInput1Remove.setText("");
            arestaInput2Remove.setText("");
            verticeInputRemove.setText("");
            buscaLarguraInput.setText("");
            buscaProfundidadeInput.setText("");

        }else if(e.getSource() == removeAresta){
            String valor = arestaValorInputRemove.getText();
            String inpt1 = arestaInput1Remove.getText();
            String inpt2 = arestaInput2Remove.getText();
            try {
                if (gValor != null && g == null) {
                    Grafo.removerArestaValor(gValor, valor);
                    displayAresta.setText("Aresta "+valor+" removida!");
                } else if (g != null && gValor == null) {
                    Grafo.removerAresta(g, inpt1, inpt2);
                    displayAresta.setText("Aresta "+inpt1+"->"+inpt2+" removida!");
                }
            } catch (Exception ex) {
                displayAresta.setText(ex.getMessage());
            }

        }else if(e.getSource() == removeVertice){
            String vertInput = verticeInputRemove.getText();
            if (vertInput.equals("")){
                displayVertices.setText("Campo em branco inválido");
            }else{
                try{
                    if(gValor != null && g == null){
                        if(Grafo.quantidadeVerticesValorado(gValor).contains(vertInput)){
                            Grafo.removeVerticeValor(gValor, vertInput);
                            displayVertices.setText("Vertice "+vertInput+" removido!");
                        }else{
                            displayVertices.setText("Vertice "+vertInput+" não encontrado");
                        }
                    }else if(g != null && gValor == null)
                        if(Grafo.quantidadeVertices(g).contains(vertInput)){
                            Grafo.removeVertice(g, vertInput);
                            displayVertices.setText("Vertice "+vertInput+" removido!");
                        }else{
                            displayVertices.setText("Vertice "+vertInput+" inexistente");
                        }
                }catch(Exception ex){
                    displayVertices.setText(ex.getMessage());
                }
            }
        }else if(e.getSource() == buscaLargura){
            String inpt = buscaLarguraInput.getText();
            ArrayList<String> array;
            try{
                if(gValor != null && g == null){
                    array = Grafo.buscaLarguraValorado(gValor, inpt);
                    displayMix.setText("Path: "+array);
                }else if(g != null && gValor == null){
                    array = Grafo.buscaLargura(g, inpt);
                    displayMix.setText("Path: "+array);
                }
            }catch(Exception ex){
                displayMix.setText(ex.getMessage());
            }

        }else if(e.getSource() == buscaProfundidade){
            String inpt = buscaProfundidadeInput.getText();
            ArrayList<String> array;
            try{
                if(gValor != null && g == null){
                    array = Grafo.buscaProfundidadeValorado(gValor, inpt);
                    displayMix.setText("Path: "+array);

                }else if(g != null && gValor == null){
                    array = Grafo.buscaProfundidade(g, inpt);
                    displayMix.setText("Path: "+array);
                }
            }catch(Exception ex){
            displayMix.setText(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Main gui = new Main();
        gui.janela();
    }
}