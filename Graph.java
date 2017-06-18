import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    Scanner scan=new Scanner(System.in);
    static int numberOfVertices;
    static int adjacencyMatrix[][];
    static Vertex []v;
    Stack stack=new Stack();
    
    public Graph(int numOfVertices){        
        setNumberOfVertex(numOfVertices);
        readVertices();
        adjacencyMatrix=new int [numberOfVertices][numberOfVertices];
        createGraph();
    }
    public Graph(){
        setNumberOfVertex(20);
        InitializeVertex();
        InitializeMatrixAdjacency();
    }
    public void InitializeVertex(){
        v=new Vertex[20];
        for(int i=0;i<20;i++){
            v[i]=new Vertex(i);
        }
        v[0].setName("Oradea");
        v[1].setName("Zerind");
        v[2].setName("Arad");
        v[3].setName("Timisoara");
        v[4].setName("Lugoj");
        v[5].setName("Mehadia");
        v[6].setName("Drobeta");
        v[7].setName("Sibiu");
        v[8].setName("Rimincu");
        v[9].setName("Craiova");
        v[10].setName("Fagaras");
        v[11].setName("Pitesti");
        v[12].setName("Bucharest");
        v[13].setName("Giurgiu");
        v[14].setName("Neamt");
        v[15].setName("Iasi");
        v[16].setName("Vaslui");
        v[17].setName("Urziceni");
        v[18].setName("Hirsova");
        v[19].setName("Eforie");
    }
    public void InitializeMatrixAdjacency(){
        adjacencyMatrix=new int[20][20];
       adjacencyMatrix[0][1]=71;
       adjacencyMatrix[0][7]=151;
       
       adjacencyMatrix[1][0]=71;
       adjacencyMatrix[1][2]=75;
       
       adjacencyMatrix[2][1]=75;
       adjacencyMatrix[2][3]=118;
       adjacencyMatrix[2][7]=140;
       
       adjacencyMatrix[3][2]=118;
       adjacencyMatrix[3][4]=111;
       
       adjacencyMatrix[4][3]=111;
       adjacencyMatrix[4][5]=70;
       
       adjacencyMatrix[5][4]=70;
       adjacencyMatrix[5][6]=75;
       
       adjacencyMatrix[6][5]=75;
       adjacencyMatrix[6][9]=120;
       
       adjacencyMatrix[7][0]=151;
       adjacencyMatrix[7][2]=140;
       adjacencyMatrix[7][8]=80;
       adjacencyMatrix[7][10]=99;
       
       adjacencyMatrix[8][7]=80;
       adjacencyMatrix[8][9]=146;
       adjacencyMatrix[8][11]=97;
       
       adjacencyMatrix[9][6]=120;
       adjacencyMatrix[9][8]=146;
       adjacencyMatrix[9][11]=138;
       
       adjacencyMatrix[10][7]=99;
       adjacencyMatrix[10][12]=211;
       
       adjacencyMatrix[11][8]=97;
       adjacencyMatrix[11][9]=138;
       adjacencyMatrix[11][12]=101;
       
       adjacencyMatrix[12][10]=211;
       adjacencyMatrix[12][11]=101;
       adjacencyMatrix[12][13]=90;
       adjacencyMatrix[12][17]=85;
       
       adjacencyMatrix[13][12]=90;
       
       adjacencyMatrix[14][15]=87;
       
       adjacencyMatrix[15][14]=87;
       adjacencyMatrix[15][16]=92;
       
       adjacencyMatrix[16][15]=92;
       adjacencyMatrix[16][17]=142;
       
       adjacencyMatrix[17][12]=85;
       adjacencyMatrix[17][16]=142;
       adjacencyMatrix[17][18]=98;
       
       adjacencyMatrix[18][17]=98;
       adjacencyMatrix[18][19]=86;
       
       adjacencyMatrix[19][18]=86;
       
    }
    public void setNumberOfVertex(int numberOfVertex){
        this.numberOfVertices=numberOfVertex;
    }
    public int getNumberOfVertex(){
        return numberOfVertices;
    }
    public static Vertex getVertex(String name){
        for(int i=0;i<numberOfVertices;i++){
            if(name.equalsIgnoreCase(v[i].getName()))
                return v[i];
        }
        System.out.print("there is not this city !!!!!\n");
        return null;
    }
    public void readVertices(){
        v=new Vertex[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++){
            System.out.print("Enter city name : ");
            String name=scan.next();
            v[i]=new Vertex(name);
            v[i].setIndex(i);
        }
    }
    public void createGraph(){
        for(int i=0;i<numberOfVertices-1;i++){
            v[i].setIndex(i);
            for(int j=1;j<numberOfVertices;j++){
                if(i!=j && j>i){ // distance any vertex from itself is always 0
                    System.out.print("distance from "+v[i].getName()+" to "+v[j].getName()+" : ");
                    adjacencyMatrix[i][j]=scan.nextInt();
                    adjacencyMatrix[j][i]=adjacencyMatrix[i][j]; // graph is undirected
                }
            }
        }
    }
    public void printShortestPath(int []parent,int d){
        
        if(parent[d]==-1) // destination is source vertex
            return ;
        printShortestPath(parent,parent[d]);
        System.out.print("--->>"+v[d].getName());
    }
    
    public void dijkstra(Vertex source){
        
        int []parent=new int [numberOfVertices]; // to store shortest path
        PriorityQueue pq=new PriorityQueue(numberOfVertices);
        int []distance=new int[numberOfVertices];
        boolean []added_To=new boolean[numberOfVertices];
        int s=source.getIndex();
        //**************************************************
        parent[s]=-1;
        for(int i=0;i<numberOfVertices;i++){
            if(i!=s){
                distance[i]=Integer.MAX_VALUE;
                pq.Enqueue(new Vertex(v[i].getName(),distance[i],i));
                added_To[i]=true;
            }
            else{
                distance[i]=0;
                
            }
        }
        //****************************************************
        for(int i=0;i<numberOfVertices;i++){
            if(adjacencyMatrix[s][i]!=0){
                if(distance[s]+adjacencyMatrix[s][i]<distance[i]){
                    int old=distance[i];
                    distance[i]=distance[s]+adjacencyMatrix[s][i];
                    parent[i]=s;
                    pq.remove(new Vertex(v[i].getName(),old,i));
                    pq.Enqueue(new Vertex(v[i].getName(),distance[i],i));
                }
            }
        }
        //****************************************************
        while(pq.peek()!=null){
            Vertex vertex=pq.delQueue();
            int j=vertex.getIndex();
            for(int i=0;i<numberOfVertices;i++){
                if(adjacencyMatrix[j][i]!=0 && added_To[i]==true){
                    if(distance[j]+adjacencyMatrix[j][i]<distance[i]){
                        int old=distance[i];
                        parent[i]=j;
                        distance[i]=distance[j]+adjacencyMatrix[j][i];
                        pq.remove(new Vertex(v[i].getName(),old,i));
                        pq.Enqueue(new Vertex(v[i].getName(),distance[i],i)); 
                    }
                }
            }
        }
        //******************************************************
        for(int i=0;i<numberOfVertices;i++){
            if(i!=s){
                System.out.println("distance  from "+source.getName()+" to "+v[i].getName()+" : "+distance[i]);
                System.out.print("path : "+source.getName());
                printShortestPath(parent, i);
                System.out.println("\n-------------------------------");
            }
        }
        
        
    }
    public void calculateAllPathBetweenTwoNodes(Vertex source,Vertex destination,int index,ArrayList listPath){
        stack.push(source);
        if(source==destination){
            listPath.add(index,stack.saveInLinkedList());
            index++;
        }
        else{
            for(int i=0;i<numberOfVertices;i++){
                if(adjacencyMatrix[i][source.getIndex()]!=0 && !stack.thereIsInStack(v[i]))
                    calculateAllPathBetweenTwoNodes(v[i], destination,index,listPath);
            }
        }
        stack.pop();
    }
    public void allPathBetweenTwoNodes(Vertex source,Vertex desVertex){
        ArrayList<LinkedList> listPath=new ArrayList<LinkedList>();
        int index=0;
        calculateAllPathBetweenTwoNodes(source, desVertex, index, listPath);
        for(int i=0;i<listPath.size();i++)
            listPath.get(i).calculateTotalDistance();
        mergeSort(listPath);
        for(int i=0;i<listPath.size();i++){
            listPath.get(i).print();
            System.out.println("distance : "+listPath.get(i).totalDistance);
        }
    }
    
    // recursive method for merge sort 
    public static ArrayList<LinkedList> mergeSort(ArrayList<LinkedList> listPath){
        ArrayList<LinkedList> left=new ArrayList<LinkedList>();
        ArrayList<LinkedList> right=new ArrayList<LinkedList>();
        
        int middle;
        if(listPath.size()==1){
            return listPath;
        }
        else{
            middle=listPath.size()/2;
            //copy the left half of listPath to the left
            for(int i=0;i<middle;i++){
                left.add(listPath.get(i));
            }
            //copy the right half of listPath to the right
            for(int i=middle;i<listPath.size();i++){
                right.add(listPath.get(i));
            }
            
            //sort the left and rigt
            left=mergeSort(left);
            right=mergeSort(right);
            //merge the result 
            merge(left,right,listPath);
        }
        return listPath;
    }
    public static void merge(ArrayList<LinkedList> left,ArrayList<LinkedList> right,ArrayList<LinkedList> listPath){
        int leftIndex=0; // index of left sub array 
        int rightIndex=0; //index of right sub array
        int listPathIndex=0; //index of listPath
        
        while(leftIndex<left.size() && rightIndex<right.size()){
            if(left.get(leftIndex).totalDistance<right.get(rightIndex).totalDistance){
                listPath.set(listPathIndex,left.get(leftIndex));
                leftIndex++;
            }
            else{
                listPath.set(listPathIndex,right.get(rightIndex));
                rightIndex++;
            }
            listPathIndex++;
        }
        ArrayList<LinkedList> rest;
        int restIndex;
        if(leftIndex>=left.size()){
            // the left array list has been finished
            rest=right;
            restIndex=rightIndex;
        }
        else{
            // the right array list has been finished
            rest=left;
            restIndex=leftIndex;
        }
        // set the listPath with rest list
        for(int i=restIndex;i<rest.size();i++){
            listPath.set(listPathIndex,rest.get(i));
            listPathIndex++;
        }
    }
}
