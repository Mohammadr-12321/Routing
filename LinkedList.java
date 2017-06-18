
public class LinkedList {
    Node l;
    int totalDistance;
    public LinkedList(){
        l=null;
        totalDistance=0;
    }
    public void insertInLast(Vertex vertex){
        Node p=new Node(vertex);
        if(l==null){
            l=p;
        }
        else{
            Node t=l;
            Node s=null;
            while(t!=null){
                s=t;
                t=t.next;
            }
            s.next=p;
        }
    }
    public void insertInFirst(Vertex vertex){
        Node p=new Node(vertex);
        if(l==null)
            l=p;
        else{
            p.next=l;
            l=p;
        }
    }
    public void calculateTotalDistance(){
        Node t=l;
        while(t!=null){
            if(t.next!=null)
                totalDistance+=Graph.adjacencyMatrix[Graph.getVertex(t.vertex.getName()).getIndex()]
                                                    [Graph.getVertex(t.next.vertex.getName()).getIndex()];
            t=t.next;
        }
    }
    public void print(){
        Node t=l;
        while(t!=null){
            System.out.print(t.vertex.getName()+" ");
            t=t.next;
        }
    }
}
