
// implement with min heap for high performance
public class PriorityQueue{
    private Vertex[] pq;
    private int number=0; // assume that array index start from 1 
                          // pq[0] unused
    
    public PriorityQueue(int n){
        pq=new Vertex[n+1];
    }
    
    public boolean isEmpty(){
        return (number==0);
    }
    public void Enqueue(Vertex v){
        pq[++number]=v;
        Bottom_upReheapify(number);
    }
    public Vertex delQueue(){
        Vertex max=pq[1];
        exChange(1, number--);
        pq[number+1]=null;
        Top_DownReheapify(1);
        return max;
    }
    private boolean larger(int i, int j){
        return pq[i].getWeight()>pq[j].getWeight();
    }
    public void exChange(int i,int j){
        Vertex temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
    private void Bottom_upReheapify(int k){
        while(k>1 && larger(k/2,k)){
            exChange(k/2,k);
            k=k/2;
        }
    }
    private void Top_DownReheapify(int k){
        while(2*k<=number){
            int j=2*k;
            if(j<number && larger(j,j+1))
                j++;
            if(!larger(k,j))
                break;
            exChange(k,j);
            k=j;
        }
    }
    
    public Vertex peek(){
        return pq[1];
    }
    public void remove(Vertex v){
        PriorityQueue p=new PriorityQueue(pq.length);
        int index = 0;
        for(int i=1;i<=number;i++){
            if(v.getIndex()==pq[i].getIndex() && v.getWeight()==pq[i].getWeight() && v.getName().equalsIgnoreCase(v.getName())){
                index=i;
            }
        }
        for(int i=1;i<index;i++){
            p.Enqueue(pq[i]);
        }
        for(int i=index+1;i<=number;i++){
            p.Enqueue(pq[i]);
        }
        while(peek()!=null){
            delQueue();
        }
        while(p.peek()!=null){
            Enqueue(p.delQueue());
        }
    }
    public void print(){
        for(int i=1;i<=number;i++){
            System.out.print(pq[i].getName()+"   ");
        }
    }
}
