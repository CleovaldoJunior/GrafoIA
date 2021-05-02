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
    public static void mostraGrafo(Graph<String, DefaultEdge> grafo) throws IOException {
        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<String, DefaultEdge>(grafo);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("src/main/resources/grafo.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static void mostraGrafoValorado(Graph<String, String> grafo) throws IOException {
        JGraphXAdapter<String, String> graphAdapter = new JGraphXAdapter<String, String>(grafo);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("src/main/resources/grafo.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static Graph<String, DefaultEdge> criaGrafoRegular() {
        return new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    }

    public static Graph<String, DefaultEdge> criaMultiGrafo(){
        return new Multigraph<String, DefaultEdge>(DefaultEdge.class);
    }

    public static Graph<String, String > criaGrafoValorado(){
        return new SimpleWeightedGraph<String, String>(String.class);
    }

    public static ArrayList<String> buscaProfundidade(Graph<String, DefaultEdge> grafo, String verInicial){
        GraphIterator<String, DefaultEdge> iterator = new DepthFirstIterator<>(grafo,verInicial);
        ArrayList<String> path = new ArrayList<>();
        while (iterator.hasNext()) {
            path.add(iterator.next());
        }
        return path;
    }

    public static ArrayList<String> buscaLargura(Graph<String, DefaultEdge> grafo, String verInicial){
        GraphIterator<String, DefaultEdge> it = new BreadthFirstIterator<>(grafo,verInicial);
        ArrayList<String> path = new ArrayList<>();
        while (it.hasNext()) {
            path.add(it.next());
        }
        return path;
    }

    public static ArrayList<String> buscaProfundidadeValorado(Graph<String, String> grafo, String verInicial){
        GraphIterator<String, String> iterator = new DepthFirstIterator<>(grafo,verInicial);
        ArrayList<String> path = new ArrayList<>();
        while (iterator.hasNext()) {
            path.add(iterator.next());
        }
        return path;
    }

    public static ArrayList<String> buscaLarguraValorado(Graph<String, String> grafo, String verInicial){
        GraphIterator<String, String> it = new BreadthFirstIterator<>(grafo,verInicial);
        ArrayList<String> path = new ArrayList<>();
        while (it.hasNext()) {
            path.add(it.next());
        }
        return path;
    }

    public static void addVertice(Graph<String, DefaultEdge> grafo, String vertice){
        grafo.addVertex(vertice);
    }

    public static void addVerticeValorado(Graph<String, String> grafo, String vertice){
        grafo.addVertex(vertice);
    }


    public static void addAresta(Graph<String, DefaultEdge> grafo, String a1, String a2){
        grafo.addEdge(a1,a2);

    }

    public static void addArestaValorada(Graph<String, String> grafo, String a1, String a2, String v){
        grafo.addEdge(a1,a2,v);
    }

    public static void removerAresta(Graph<String, DefaultEdge> grafo, String a1, String a2){
        grafo.removeEdge(a1, a2);
    }

    public static void removeVertice(Graph<String, DefaultEdge> grafo, String vertice){
        grafo.removeVertex(vertice);
    }

    public static void removerArestaValor(Graph<String, String> grafo, String valor){
        grafo.removeEdge(valor);
    }

    public static void removeVerticeValor(Graph<String, String> grafo, String vertice){
        grafo.removeVertex(vertice);
    }

    public static Set<String> quantidadeVertices(Graph<String, DefaultEdge> grafo){
        return grafo.vertexSet();
    }

    public static Set<DefaultEdge> quantidadeArestas(Graph<String, DefaultEdge> grafo){
        return grafo.edgeSet();
    }

    public static Set<String> quantidadeVerticesValorado(Graph<String, String> grafo){
        return grafo.vertexSet();
    }

    public static Set<String> quantidadeArestasValorado(Graph<String, String> grafo){
        return grafo.edgeSet();
    }
}



