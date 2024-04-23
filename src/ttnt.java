import java.util.*;

// Lớp để biểu diễn một đỉnh trong đồ thị
class Vertex {
    int h ;
    String label; // Tên của đỉnh
    LinkedList<Edge> edges; // Danh sách liên kết các cạnh kề với đỉnh

    public Vertex(String label,int h) {
        this.label = label;
        this.edges = new LinkedList<>();
        this.h=h ;
    }

    // Phương thức để thêm một cạnh vào danh sách cạnh kề của đỉnh
    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}

// Lớp để biểu diễn một cạnh trong đồ thị
class Edge {
    String destination; // Đỉnh đích của cạnh
    int weight; // Trọng số của cạnh

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Lớp để biểu diễn đồ thị bằng danh sách liên kết đơn
class Graph {
    String name ;
    Map<String, Vertex> vertices; // Danh sách các đỉnh trong đồ thị

    public Graph(String name ) {
        this.name = name ;
        this.vertices = new HashMap<>();
    }

    // Phương thức để thêm một đỉnh vào đồ thị
    public void addVertex(String label,int h) {
        vertices.put(label, new Vertex(label,h));
    }

    // Phương thức để thêm một cạnh vào đồ thị
    public void addEdge(String source, String destination, int weight) {
        Vertex sourceVertex = vertices.get(source);
        Vertex destinationVertex = vertices.get(destination);
        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.addEdge(new Edge(destination, weight));
        }
    }

    // Phương thức để hiển thị đồ thị
    public void display( String Graph ) {
        for (String vertexLabel : vertices.keySet()) {
            Vertex vertex = vertices.get(vertexLabel);
            System.out.print(vertex.label + ": ");
            for (Edge edge : vertex.edges) {
                System.out.print(edge.destination + "(" + edge.weight + "), ");
            }
            System.out.println();
        }
    }
    public  boolean check(String a, List<Vertex> b){
        for(Vertex i : b){
            if(i.label.equals(a)) return true ;
            break;
        }
        return false;
    }
    public  void  HillClimbing(Graph graph, Vertex StartGrade, Vertex EndGrade ){
//        List<Vertex> Mo = new ArrayList<>();

        Vertex Mo =StartGrade ;
        Vertex Dich = EndGrade ;
        List<Vertex> Dong = new ArrayList<>();
//        List<Vertex> Dich = new ArrayList<>();
//        List<Vertex> Child = new ArrayList<>();

        while (Mo!=null){
            Vertex S= Mo;
            Dong.add(S);
            if(S==Dich){
                break;
            }
            if(S.edges.size()!=0){
                for (Edge e: S.edges){
                    if(check(e.destination,Dong)){



                    }

                }

            }
        }
    }
}


// Lớp chứa phương thức main để thử nghiệm
public class ttnt {
    public static void main(String[] args) {
        List<Graph> GraphList = new ArrayList<>();        // Tạo một đồ thị mới
        Graph graph = new Graph("o");
        GraphList.add(graph);

        // Thêm các đỉnh vào đồ thị
        graph.addVertex("A",1);
        graph.addVertex("B",2);
        graph.addVertex("C",3);
        graph.addVertex("D",4);
        graph.addVertex("E",5);
        graph.addVertex("F",6);
        graph.addVertex("G",7);
        graph.addVertex("H",0);

        // Thêm các cạnh vào đồ thị
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "F", 4);
        graph.addEdge("A", "C", 5);
        graph.addEdge("A", "D", 4);
        graph.addEdge("F", "E", 3);
        graph.addEdge("F", "G", 2);
        graph.addEdge("C", "E", 4);
        graph.addEdge("E", "G", 5);
        graph.addEdge("D", "E", 6);
        graph.addEdge("H", "G", 3);
        graph.addEdge("B", "H", 12);

        // Hiển thị đồ thị
        for(int i=0 ; i <=GraphList.size()-1; i++ ){
            if(GraphList.get(i).name=="o"){
                System.out.println("Đồ thị:");
                GraphList.get(i).display(graph.name);
            }
        }


    }
}
