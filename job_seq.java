import java.util.ArrayList;

class Job{
    int id;
    int profit;
    int deadline;
    public Job(int id,int profit,int deadline){
        this.id=id;
        this.profit=profit;
        this.deadline=deadline;
    }
}
public class job_seq {
    
    public static void JS(int n ,Job[] a,int t){
        
        for(int i=0;i<n;i++){
            for(int k=i+1;k<n;k++){
                if(a[i].profit<a[k].profit){
                    Job temp=a[i];
                    a[i]=a[k];
                    a[k]=temp;
                }
            }
        }
        
        boolean[] result=new boolean[t];
         int[] job= new int[t];

        for(int i=0;i<n;i++){
            for(int j=Math.min(t-1,a[i].deadline-1);j>=0;j--){

                if (result[j] == false) {
                    result[j] = true;
                    job[j] = a[i].id;
                    break;
                }
            }
        }

        for (int jb : job)
      System.out.print((jb+1)+ " ");
      System.out.println();
    }

    public static void main(String args[]) {
        
        Job[] jobs=new Job[6];
        int n=6;
      // Function call
      System.out.println("Following is maximum profit sequence of Jobs: ");
      jobs[0] = new Job(0,20,3);
      jobs[1] = new Job(1,15,1);
      jobs[2] = new Job(2,10,1);
      jobs[3] = new Job(3,7,3);
      jobs[4] = new Job(4,5,1);
      jobs[5] = new Job(5,3,3);

      int t=3;
      // Calling function
      JS(n, jobs, t);
   }
}
