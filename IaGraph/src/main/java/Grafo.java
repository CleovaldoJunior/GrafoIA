import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.generate.CompleteBipartiteGraphGenerator;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public static Graph<Integer, DefaultEdge> criaGrafoRegular() {
        return new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
    }

    public static Graph<Integer, DefaultEdge> criaMultiGrafo(){
        return new Multigraph<Integer, DefaultEdge>(DefaultEdge.class);
    }

    public static Graph<Integer, DefaultEdge> criaGrafoValorado(){
        return new SimpleWeightedGraph<Integer, DefaultEdge>(DefaultEdge.class);
    }

    public static void buscaProfundidade(Graph<Integer, DefaultEdge> grafo,Integer verInicial){
        GraphIterator<Integer, DefaultEdge> iterator = new DepthFirstIterator<>(grafo,verInicial);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void buscaLargura(Graph<Integer, DefaultEdge> grafo, Integer verInicial){
        GraphIterator<Integer, DefaultEdge> it = new BreadthFirstIterator<>(grafo,verInicial);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void addVertice(Graph<Integer, DefaultEdge> grafo, Integer vertice){
        grafo.addVertex(vertice);
    }

    public static void addAresta(Graph<Integer, DefaultEdge> grafo, Integer a1, Integer a2){
        grafo.addEdge(a1, a2);
    }

    public static void removerAresta(Graph<Integer, DefaultEdge> grafo, Integer a1, Integer a2){
        grafo.removeEdge(a1, a2);
    }

    public static void removeVertice(Graph<Integer, DefaultEdge> grafo, Integer vertice){
        grafo.removeVertex(vertice);
    }

    public static Set<Integer> quantidadeVertices(Graph<Integer, DefaultEdge> grafo){
        return grafo.vertexSet();
    }

    public static Set<DefaultEdge> quantidadeArestas(Graph<Integer, DefaultEdge> grafo){
        return grafo.edgeSet();
    }
}



