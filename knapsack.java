import java.util.Scanner;

class bag{
    int profit;
    int weight;
    int id;
    public bag(int profit,int weight,int id){
        this.profit=profit;
        this.id=id;
        this.weight=weight;
    }
}
public class knapsack {
 
    public static void G_knapsack(bag[] b,int m,int n,double[] x){

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((b[i].profit/b[i].weight)<(b[j].profit/b[j].weight)){
                    bag temp=b[i];
                    b[i]=b[j];
                    b[j]=temp;
                }
            }
        }
       
        for(int i=0;i<n;i++){
            x[i]=0.0;
        }
         int U=m; // weight
        int i;
        for(i=0;i<n;i++){
            if(b[i].weight>U){
                break;
            }
            x[i]=1.0;
            U=U-b[i].weight;

        }
        if(i<n){
            x[i]=(double)U/(double)b[i].weight;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter the capacity of bags");
        int capacity = sc.nextInt();
        System.out.println("Enter the number of items");
        int numberOfbags = sc.nextInt();
        double[] x = new double[numberOfbags];
        System.out.println("Enter the weight and profit of items");
        bag[] bags=new bag[numberOfbags];
        for(int i=0;i<numberOfbags;i++){
            System.out.println("enter weight of "+(i+1)+" item");
            int weight=sc.nextInt();
            System.out.println("enter profit of "+(i+1)+" item");
            int profit=sc.nextInt();
            bags[i]= new bag(profit, weight,i);
        }
        G_knapsack(bags,capacity,numberOfbags,x);
        System.out.println("bag loaded:");
        for (int i = 0; i < numberOfbags; i++) {
            if (x[i] != 0) {
                System.out.println("item " + (bags[i].id+1));
            }
        }
    }
}

