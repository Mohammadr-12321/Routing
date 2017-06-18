
public class Vertex {
    private String name;
    private int weight;
    private int index;
    public Vertex(String name){
        setName(name);
    }
    public Vertex(String name,int wieght){
        setName(name);
        setWeight(weight);
    }
    public Vertex(String name,int weight,int index){
        setName(name);
        setWeight(weight);
        setIndex(index);
    }
    public Vertex(int index){
        setIndex(index);
    }
    public void setName(String name){
        this.name=name;
    }
    public void setWeight(int weight){
        this.weight=weight;
    }
    public void setIndex(int index){
        this.index=index;
    }
    public String getName(){
        return name;
    }
    public int getWeight(){
        return weight;
    }
    public int getIndex(){
        return index;
    }
}
