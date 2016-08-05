import java.util.Arrays;

/**
 * @author malloneec
 * @since 8/5/16
 */
public class CodingMergeSort {
    private int[] initial;
    public static void main(String[] args){
        CodingMergeSort demo = new CodingMergeSort();
        demo.run(args);
    }

    public void run(String[] args){
        fillArray();
        int[] finalSorted=mergeSort(initial);
        for(int i=0; i<finalSorted.length; i++){
            System.out.print(finalSorted[i]+", ");
            if((i+1)%20==0){
                System.out.print("\n");
            }
        }
    }

    private static int[] breakArray(int[] a){
        int[] first;
        int[] second;
        if(a.length>1) {
            first = Arrays.copyOfRange(a, 0, a.length / 2);
            if (first.length > 1) {
                first = breakArray(first);
            }
            second = Arrays.copyOfRange(a, a.length / 2, a.length);
            if (second.length > 1) {
                second = breakArray(second);
            }
            return mergeArrays(first, second);
        }else{
            return a;
        }
    }

    private static int[] mergeSort(int[] a){
        if(a.length>1){
            int[] result = breakArray(a);
            return result;
        }else{
            return a;
        }

    }

    private static int[] mergeArrays(int[] a, int[] b){
        int[] sorted = new int[a.length+b.length];
        int i=0;
        int j=0;
        int x=0;
        while((i < a.length) || (j < b.length)){
            if(i<a.length){
                if(j>=b.length){
                    sorted[x]=a[i];
                    i++;
                }else{
                    if(a[i] <= b[j]){
                        sorted[x]=a[i];
                        i++;
                    }else{
                        sorted[x]=b[j];
                        j++;
                    }
                }
            }else{
                sorted[x]=b[j];
                j++;
            }
            x++;
        }
        return sorted;
    }

    private void fillArray(){
        initial = new int[100];
        for(int i =0; i<initial.length; i++){
            initial[i]=(int)(Math.random()*100);
        }
    }
}
