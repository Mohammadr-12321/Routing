
import java.util.Scanner;


public class Test {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
    
        System.out.println("Routing project");
//        Graph map=createYourMap();
        map romani=new map();
        menue(romani.map);
       
    }
    public static Graph createYourMap(){
        System.out.println("Please Enter number of cities :");
        int numberOfCities=scan.nextInt();
        while(numberOfCities<=0){
            System.out.println("You Entered wrong number.please enter again :");
            numberOfCities=scan.nextInt();
        }
        Graph map=new Graph(numberOfCities);
        return map;
    }
    public static void menue(Graph map){
        boolean exit=false;
        while(!exit){
            System.out.println("\n1.find shortes path with Dijkstra Algorithm\n"
                              +"2.find All Path between two cities\n"
                              +"3.retrun to main menue");
            int selection=scan.nextInt();
            switch(selection){
                case 1:findShortestPath(map);break;
                case 2:findAllPathBetweenTwoCities(map);break;
                case 3:exit=true;break;
                default:break;
            }
        }
    }
    public static void findShortestPath(Graph map){
        System.out.println("Please Enter Source :");
        String source=scan.next();
        while(Graph.getVertex(source)==null){
            System.out.println("not found .Enter again :");
            source=scan.next();
        }
        Vertex s=Graph.getVertex(source);
        map.dijkstra(s);
    }
    public static void findAllPathBetweenTwoCities(Graph map){
        System.out.println("Please Enter source : ");
        String source=scan.next();
        while(Graph.getVertex(source)==null){
            System.out.println("not found.Enter again :");
            source=scan.next();
        }
        Vertex s=Graph.getVertex(source);
        System.out.println("Please Enter destination :");
        String destination=scan.next();
        while(Graph.getVertex(destination)==null){
            System.out.println("not found.Enter again :");
            destination=scan.next();
        }
        Vertex d=Graph.getVertex(destination);
        map.allPathBetweenTwoNodes(s, d);
    }
}
