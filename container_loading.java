import java.util.Scanner;

class Container {
    int id;
    int weight;
    
    public Container(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}

public class container_loading{


    static void sort(Container[] a,int n){
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i].weight>a[j].weight){
                    Container temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    
    public static void containerLoading(Container[] c, int capacity, int numberOfContainers, int[] x) {
      
         
        int n = numberOfContainers;
        sort(c,n); 
       
        for (int i = 0; i < n && c[i].weight <= capacity; i++) {
            
            x[c[i].id] = 1;
            capacity -= c[i].weight; 
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter the capacity of container");
        int capacity = sc.nextInt();
        System.out.println("Enter the number of container");
        int numberOfContainers = sc.nextInt();
        int[] x = new int[numberOfContainers];
        System.out.println("Enter the weight of containers");
        Container[] containers= new Container[numberOfContainers];
        for(int i=0;i<numberOfContainers;i++){
            int weight=sc.nextInt();
            containers[i]= new Container(i, weight);
        }
        

        containerLoading(containers, capacity, numberOfContainers, x);

        System.out.println("Containers loaded:");
        for (int i = 0; i < numberOfContainers; i++) {
            if (x[i] == 1) {
                System.out.println("Container " + (i+1));
            }
        }
    }
}
