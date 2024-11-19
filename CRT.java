public class CRT {

    static int  crt(int[]m, int[]a , int k){
        int x = 1;

        while(true){
            int j;
            for(j = 0; j<k; j++){
                if(x%m[j] != a[j]){
                    break;
                }
            }

            if(j == k) return x;
            
            x++;

        }
    }
    public static void main(String[]args){
        int m[] = {3,4,5};
        int a[] = {2,3,1};

        int k = m.length;
        
        System.out.println(crt(m,a ,k));

    }
}
