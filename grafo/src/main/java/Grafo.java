import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

class Grafo{

    public static void mostraGrafo(Graph<Integer,DefaultEdge> g){

    }

    public static Graph<Integer, DefaultEdge> criaGrafoDirecionadoSemPeso() {
        return new SimpleDirectedGraph<>(DefaultEdge.class);
    }
    public static void buscaProfundidade(Graph<Integer, DefaultEdge> grafo){
        GraphIterator<Integer, DefaultEdge> iterator = new DepthFirstIterator<>(grafo);
        while (iterator.hasNext()) {
            System.out.println( iterator.next());
        }
    }

    public static void buscaLargura(Graph<Integer, DefaultEdge> grafo){
        GraphIterator<Integer, DefaultEdge> it = new BreadthFirstIterator<>(grafo);
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
}



