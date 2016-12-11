package Oct2016.GeeksForGeeks.graph;

import assistant.Graph;
import assistant.GraphAssistant;
import assistant.Vertex;

import java.util.*;

/**
 * Created by ritesh on 12/9/16.
 */
public class BipartiteGraph {

    public static void main(String args[]) {

        final Graph graph = new Graph();

        isBipatiteGraph(graph);
    }

    // different appraoch
    public static boolean isBipatiteGraph(final Graph graph) {

        for(final Vertex vertex : graph.getVertices()) {

            vertex.setColor("WHITE");
        }

        final GraphAssistant graphAssistant = new GraphAssistant(graph);

        final Queue<Vertex> queue = new ArrayDeque<>();

        final List<Vertex> uSet = new ArrayList<>();
        final List<Vertex> vSet = new ArrayList<>();

        final Vertex source = graph.getVertices().get(0);

        queue.add(source);
        uSet.add(source);

        while(!queue.isEmpty()) {

            final Vertex vertex = queue.remove();
            vertex.setColor("RED");
            uSet.add(vertex);

            final boolean vset = doesParentLieInSet(vSet,vertex);

            List<Vertex> neightbors = graphAssistant.getNeightbors(vertex.getValue());

            for(final Vertex neightbor : neightbors) {

                if(!vset) {

                    if(doesTheNodeAlreadyExistInSet(vSet,neightbor)) {
                        return false;
                    }
                    neightbor.setColor("BLUE");
                    queue.add(neightbor);
                    vSet.add(neightbor);
                }else{

                    if(doesTheNodeAlreadyExistInSet(uSet,neightbor)) {
                        return false;
                    }

                    neightbor.setColor("RED");
                    queue.add(neightbor);
                    uSet.add(neightbor);
                }
            }
        }

        return true;
    }

    private static boolean doesParentLieInSet(final List<Vertex> set, final Vertex vertex) {

        for(final Vertex setVertex: set) {

            if(setVertex.equals(vertex.getParent())) {
                return true;
            }
        }

        return false;
    }

    private static boolean doesTheNodeAlreadyExistInSet(final List<Vertex> set, final Vertex vertex) {

        for(final Vertex setVertex: set) {

            if(setVertex.equals(vertex)) {
                return true;
            }
        }

        return false;
    }
}
