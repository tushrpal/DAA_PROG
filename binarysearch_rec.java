import java.util.Scanner;

public class binarysearch_rec {
    int binsearch(int a[],int l,int h,int x){
        int n=a.length;
        if(l==h){
            if(x==a[l]){
                return l;
            }else
            return 0;
        }else{
         int mid=l+(h-1)/2;
         if(x==a[mid])
         return mid;
         else if(x<a[mid])
         return binsearch(a, l, mid-1, x);
         else
         return binsearch(a, mid+1, h, x);
           }}

    public static void main(String[] args) {
        binarysearch_rec bs= new binarysearch_rec();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of values will be entered");
        int n=sc.nextInt();
        
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
        }
        
        System.out.println("enter the value to search");
        int x=sc.nextInt();
        
        int l=0,h=n-1;
        int chk= bs.binsearch(arr,l,h,x);
        if (chk==0) {
            System.out.println("not found");
        }else
        System.out.println("found at index: "+chk );
        
    }
}
