import java.util.*;
import static java.lang.System.out;


public class threeSum{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] x={1,3,4,5,7,8,9,10,11};
        int i,j,cnt=0;
        int target;
        ArrayList<Node> twoSum = new ArrayList<Node>();
        ArrayList<Node> output = new ArrayList<Node>();
        Solution s = new Solution();
        
        int n=x.length;
        int a,b,c;

        System.out.println("input target");
        target = scanner.nextInt();

        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                Node A = new Node();
                A.setMemA(i);
                A.setMemB(j);
                A.setSum(x[i],x[j]);
                twoSum.add(A);
            }
        }
        for(i=0;i<(n*(n-1)/2);i++)
        {
            Node A = new Node();
           int M;
            A = twoSum.get(i);
            c=A.getSum();
            M = target - c;
           if(s.search(x,M)!=-1 && s.search(x,M)>A.getmemA() && s.search(x,M)>A.getmemB())
           {
               A.setMemC(M);
               output.add(A);
               cnt++;
           }
        }
        for(i=0;i<cnt;i++)
        {
            Node A = new Node();
            A = output.get(i);
            a=A.getmemA();
            b=A.getmemB();
            c=A.getmemC();
            System.out.println("memA : "+x[a]+" , memB : "+x[b]+" , memC : " + c);
        }
    }

}

class Node{
    public int memberA,memberB,memberC;
    public int sum;
    public void setMemA(int value)
    {
        this.memberA = value;
    }
    public void setMemB(int value)
    {
        this.memberB = value;
    }
    public void setMemC(int value)
    {
        this.memberC = value;
    }
    public void setSum(int a,int b)
    {
        this.sum = a+b;
    }
    public int getmemA()
    {
        return this.memberA;
    }
    public int getmemB()
    {
        return this.memberB;
    }
    public int getmemC()
    {
        return this.memberC;
    }
    public int getSum()
    {
        return this.sum;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        
        int start,end,index=0;
        start=0;
        end=nums.length-1;
       while(start<=end)
       {
           index=(start+end)/2;
           if(target==nums[index])
           {
               return index;
           }
           else if(target<nums[index])
           {
               end=index-1;
               continue;
           }
           else if(target>nums[index])
           {
               start=index+1;
           }
       }
        return -1;
    }
}