
    public class Node{
        Node next;
        Vertex vertex;
        public Node(Vertex vertex){
            this.vertex=new Vertex(vertex.getName(),vertex.getWeight(),vertex.getIndex());
        }
        public boolean isEqual(Vertex vertex){
            return (this.vertex.getIndex()==vertex.getIndex() && 
                    this.vertex.getWeight()==vertex.getWeight()&&
                    this.vertex.getName().equalsIgnoreCase(vertex.getName()));
        }
    }