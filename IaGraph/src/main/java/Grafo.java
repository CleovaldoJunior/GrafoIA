import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

class Grafo{
    public static void mostraGrafo(Graph<Integer, DefaultEdge> grafo) throws IOException {
        JGraphXAdapter<Integer, DefaultEdge> graphAdapter = new JGraphXAdapter<Integer, DefaultEdge>(grafo);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("src/main/resources/grafo.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static void mostraGrafoValorado(Graph<Integer, String> grafo) throws IOException {
        JGraphXAdapter<Integer, String> graphAdapter = new JGraphXAdapter<Integer, String>(grafo);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("src/main/resources/grafo.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static Graph<Integer, DefaultEdge> criaGrafoRegular() {
        return new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
    }

    public static Graph<Integer, DefaultEdge> criaMultiGrafo(){
        return new Multigraph<Integer, DefaultEdge>(DefaultEdge.class);
    }

    public static Graph<Integer, String > criaGrafoValorado(){
        return new SimpleWeightedGraph<Integer, String>(String.class);
    }

    public static ArrayList<Integer> buscaProfundidade(Graph<Integer, DefaultEdge> grafo, int verInicial){
        GraphIterator<Integer, DefaultEdge> iterator = new DepthFirstIterator<>(grafo,verInicial);
        ArrayList<Integer> path = new ArrayList<>();
        while (iterator.hasNext()) {
            path.add(iterator.next());
        }
        return path;
    }

    public static ArrayList<Integer> buscaLargura(Graph<Integer, DefaultEdge> grafo, int verInicial){
        GraphIterator<Integer, DefaultEdge> it = new BreadthFirstIterator<>(grafo,verInicial);
        ArrayList<Integer> path = new ArrayList<>();
        while (it.hasNext()) {
            path.add(it.next());
        }
        return path;
    }

    public static ArrayList<Integer> buscaProfundidadeValorado(Graph<Integer, String> grafo, int verInicial){
        GraphIterator<Integer, String> iterator = new DepthFirstIterator<>(grafo,verInicial);
        ArrayList<Integer> path = new ArrayList<>();
        while (iterator.hasNext()) {
            path.add(iterator.next());
        }
        return path;
    }

    public static ArrayList<Integer> buscaLarguraValorado(Graph<Integer, String> grafo, int verInicial){
        GraphIterator<Integer, String> it = new BreadthFirstIterator<>(grafo,verInicial);
        ArrayList<Integer> path = new ArrayList<>();
        while (it.hasNext()) {
            path.add(it.next());
        }
        return path;
    }

    public static void addVertice(Graph<Integer, DefaultEdge> grafo, int vertice){
        grafo.addVertex(vertice);
    }

    public static void addVerticeValorado(Graph<Integer, String> grafo, int vertice){
        grafo.addVertex(vertice);
    }


    public static void addAresta(Graph<Integer, DefaultEdge> grafo, int a1, int a2){
        grafo.addEdge(a1,a2);

    }

    public static void addArestaValorada(Graph<Integer, String> grafo, int a1, int a2, String v){
        grafo.addEdge(a1,a2,v);
    }

    public static void removerAresta(Graph<Integer, DefaultEdge> grafo, int a1, Integer a2){
        grafo.removeEdge(a1, a2);
    }

    public static void removeVertice(Graph<Integer, DefaultEdge> grafo, int vertice){
        grafo.removeVertex(vertice);
    }

    public static void removerArestaValor(Graph<Integer, String> grafo, String valor){
        grafo.removeEdge(valor);
    }

    public static void removeVerticeValor(Graph<Integer, String> grafo, int vertice){
        grafo.removeVertex(vertice);
    }

    public static Set<Integer> quantidadeVertices(Graph<Integer, DefaultEdge> grafo){
        return grafo.vertexSet();
    }

    public static Set<DefaultEdge> quantidadeArestas(Graph<Integer, DefaultEdge> grafo){
        return grafo.edgeSet();
    }

    public static Set<Integer> quantidadeVerticesValorado(Graph<Integer, String> grafo){
        return grafo.vertexSet();
    }

    public static Set<String> quantidadeArestasValorado(Graph<Integer, String> grafo){
        return grafo.edgeSet();
    }
}



