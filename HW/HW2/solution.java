package HW2;

public class solution{

    public int search(int n, int[] versions){

        int left = 1;
        int right = n -1 ;
        int midy = 0;

        while(left < right){
            midy = left + (right - left) /2;

            if(isBadVersion(versions[midy])){
                right = midy;
            }else{
                left = midy +1;
            }

        }

        return left + 1;

    }

    public boolean isBadVersion(int version) {
        return version > 5;
    }

    public static void main(String[] args) {
        solution solution = new solution();
        int n = 10;
        int[] versions = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int firstBadVersion = solution.search(n, versions);
        System.out.println(firstBadVersion);
    }
    
}