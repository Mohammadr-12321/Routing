
public class Stack {
    
    Node topOfStack;
    public Stack(){
        topOfStack=null;
    }
    public void push(Vertex vertex){
        Node p=new Node(vertex);
        if(topOfStack==null)
            topOfStack=p;
        else{
            p.next=topOfStack;
            topOfStack=p;
        }
    }
    public Node pop(){
        if(topOfStack==null)
            return null;
        else{
            Node q=topOfStack;
            topOfStack=topOfStack.next;
            return q;
        }
    }
    
    public boolean thereIsInStack(Vertex vertex){
        Node t=topOfStack;
        boolean found=false;
        while(t!=null && !found){
            if(t.isEqual(vertex))
                found=true;
            else
                t=t.next;
        }
        return found;
    }
    public LinkedList saveInLinkedList(){
        LinkedList list=new LinkedList();
        Node t=topOfStack;
        while(t!=null){
            Node v=new Node(t.vertex);
            list.insertInFirst(v.vertex);
            t=t.next;
        }
        return list;
    }
    public void printStack(){
        Node t=topOfStack;
        while(t!=null){
            System.out.print("-->>"+t.vertex.getName());
            t=t.next;
        }
    }
}
