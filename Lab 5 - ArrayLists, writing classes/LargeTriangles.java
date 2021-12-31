import java.util.*;
public class LargeTriangles {

    public static ArrayList<MyTriangle> findTriangles(ArrayList<MyTriangle>triangles, double thresholdArea){
        //area = (height*base)/2
        double area;
        ArrayList<Double> arealist = new ArrayList<Double>();
        ArrayList<MyTriangle> newtriangles = new ArrayList<MyTriangle>();

        //calculate the area, test against the threshold, add to list if <thresh
        for(int i = 0; i < triangles.size(); i++){
            MyTriangle temp = triangles.get(i);
            double base = temp.base;
            double height = temp.height;
            area = (height*base)/2;
            if(area < thresholdArea){
                newtriangles.add(temp);
            }
        }
        return(newtriangles);
    }

    public static void main(String [] args){

        // Creating the 10 triangles
        ArrayList<MyTriangle> triarrlist = new ArrayList<MyTriangle>();
        ArrayList<MyTriangle> newtriangles = new ArrayList<MyTriangle>();

        MyTriangle triangle1 = new MyTriangle();
        triangle1.base = 10.0;
        triangle1.height = 10.2;
        triarrlist.add(triangle1);
        MyTriangle triangle2 = new MyTriangle();
        triangle2.base = 2.0;
        triangle2.height = 4.0;
        triarrlist.add(triangle2);
        MyTriangle triangle3 = new MyTriangle();
        triangle3.base = 4.5;
        triangle3.height = 10.0;
        triarrlist.add(triangle3);
        MyTriangle triangle4 = new MyTriangle();
        triangle4.base = 20.0;
        triangle4.height = 20.0;
        triarrlist.add(triangle4);
        MyTriangle triangle5 = new MyTriangle();
        triangle5.base = 15.0;
        triangle5.height = 10.0;
        triarrlist.add(triangle5);
        MyTriangle triangle6 = new MyTriangle();
        triangle6.base = 2.5;
        triangle6.height = 4.5;
        triarrlist.add(triangle6);
        MyTriangle triangle7 = new MyTriangle();
        triangle7.base = 10.0;
        triangle7.height = 20.0;
        triarrlist.add(triangle7);
        MyTriangle triangle8 = new MyTriangle();
        triangle8.base = 5.5;
        triangle8.height = 9.0;
        triarrlist.add(triangle8);
        MyTriangle triangle9 = new MyTriangle();
        triangle9.base = 1.0;
        triangle9.height = 4.5;
        triarrlist.add(triangle9);
        MyTriangle triangle10 = new MyTriangle();
        triangle10.base = 5.0;
        triangle10.height = 8.0;
        triarrlist.add(triangle10);

        //testing findTriangles
        System.out.print("Enter a threshold area: ");
        Scanner scan = new Scanner(System.in);
        double threshold = scan.nextDouble();
        newtriangles = findTriangles(triarrlist, threshold);
        // have it print like: T1 - Height: a Base: b
        for(int i = 0; i < newtriangles.size(); i++){
            MyTriangle temp = newtriangles.get(i);
            double base = temp.base;
            double height = temp.height;
            System.out.println("T" + i + " - Height: " + height + " Base: " + base);
        }
    }

}
