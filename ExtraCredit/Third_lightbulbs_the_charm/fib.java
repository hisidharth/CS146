package ExtraCredit.Third_lightbulbs_the_charm;

public class fib{

    public int fibo(int val){

        int p = 0;
        int x = 1;
        int ret = 0;    

        for(int i = 0; i<val; i++ ){

            ret = p+x;
            p =  x;
            x = ret;
        }

        return p;
    }


    
    public static void main(String[] args) {
        fib sol = new fib();
       
        System.out.println(sol.fibo(10));
    }
}
