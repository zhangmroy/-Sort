public class Sort {

    public static void main(String[] args) {
        int []num = new int[]{52,0,-1,7,8,2};
        int []a = new int[]{1,3,9};
        int []b = new int[]{2,4,6};
//        insetSort(num);
//        bubbleSort(num);
//        quickSort(num);
        selectionSort(num);
        for (int i:num)
        System.out.println(i);
        int []res = mSortSub(a,b);
        for (int i:res)
            System.out.println(i);
    }

    public static int qSortSub(int[] num, int low, int high){
        int flag = low;
        while (low != high){
            if (flag==low){
                if (num[flag] > num[high]) {
                    swap(num, flag, high);
                    low++;
                    flag = high;
                }
                else high--;
                continue;
            }
            if (flag==high){
                if (num[flag] < num[low]){
                    swap(num, flag, low);
                    high--;
                    flag = low;
                }
                else low++;
            }
        }
        return flag;
    }

    public static int[] mSortSub(int []a,int []b){
        int []res = new int[a.length+b.length];

        int flagA = 0;
        int flagB = 0;
        int flagRes = 0;
        while (flagRes<res.length && flagA<a.length && flagB<b.length){
            res[flagRes++] = a[flagA]<b[flagB]?a[flagA++]:b[flagB++];
        }
        while (flagA<a.length)res[flagRes++]=a[flagA++];
        while (flagB<b.length)res[flagRes++]=b[flagB++];

        return res;
    }

    public static void swap(int []num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    //from left to right . the smaller one moves to left side
    //o(n^2)
    public static void bubbleSort(int []num){
        int len = num.length;

        for (int i=0;i<len;i++){
            for (int j=len-1;j>i;j--){
                if (num[j] < num[j-1])swap(num,j,j-1);
            }
        }
    }

    //from left to right to insert
    //o(n^2)
    public static void insetSort(int []num){
        int len  = num.length;

        for (int i=0;i<len;i++){
            //scan the list and insert
            for (int j=0;j<i;j++){
                if (num[i] < num[j]){
                    //move the following nums
                    swap(num,i,j);
                }
            }
        }
    }


    //quick sort o(nlogn)
    //sortPart is used to sort part of arrays
    public static void quickSort(int []num){
        qSort(num,0,num.length-1);
    }

    public static void qSort(int[] num,int start ,int end){
        if (start == end)return;
        else {
            int mid = qSortSub(num,start,end);
            if (mid!=start)qSort(num,start,mid-1);
            if (mid!=end)qSort(num,mid+1,end);
        }
    }


    //selection sort
    //o(n^2)
    public static void selectionSort(int []num){
        int len = num.length;

        for (int i=0;i<len;i++){
            int min = i;
            for (int j=i;j<len;j++)
                if (num[min] > num[j])min=j;

            swap(num,min,i);
        }
    }

    //merge sort
    //o(n log(n))
    public static void mergeSort(int []num){
        //TODO
    }

    public static int[] mSort(int[] num, int low, int mid, int high){
        //TODO
        return new int[]{1};
    }
}

