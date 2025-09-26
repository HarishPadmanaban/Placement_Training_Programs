public class BitwiseAnd {
    public static void main(String[] args) {
        int l = 5;
        int r = 7;
        //System.out.println(computeBitwiseAnd(l,r));
        System.out.println(optimizedSolution(l,r));
    }

    private static int optimizedSolution(int l, int r) {
        int count = 0;
        while(l!=r)
        {
            l>>=1;
            r>>=1;
            count++;
        }
        return r<<count;
    }

    private static int computeBitwiseAnd(int l, int r) {
        int answer = 0;
        int shift = 1;
        for(int i=0;i<32;i++)
        {
            if(((l&1)&(r&1))==1)
            {
                answer |= shift;
            }
            else if(((l&1)&(r&1))==0 && ((l&1)!=0 || (r&1)!=0)){
                answer = 0;
            }
            l>>=1;
            r>>=1;
            shift<<=1;
        }
        return answer;
    }
}
