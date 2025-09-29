package Heap;

import java.util.*;

public class HeapExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7,10,12,13,16,17,23,18,22));
        System.out.println(list);
        ArrayList<Integer> newList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("1.Insert\n2.Delete\n3.Form\n4.Sort\n5.Exit");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    insert(list);
                    System.out.println(list);
                    break;
                case 2:
                    delete(list);
                    System.out.println(list);
                    break;
                case 3:
                    formHeap(newList);
                    System.out.println(newList);
                    break;
                case 4:
                    ArrayList<Integer> al = new ArrayList<>(list);
                    System.out.println(sort(al));
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while(ch!=3);
    }

    private static void formHeap(ArrayList<Integer> newList) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("Enter number to add : ");
            int num = sc.nextInt();
            newList.addLast(num);
            checkValid(newList,newList.size());
            System.out.println(newList);
            System.out.println("Do you want to enter more(1/0):");
            ch = sc.nextInt();
        }while(ch==1);
    }

    private static void delete(ArrayList<Integer> list) {
        int num = list.removeLast();
        int f = list.getFirst();
        list.set(0,num);
        checkValidForDelete(list,list.size(),0);
    }

    private static List<Integer> sort(ArrayList<Integer> list)
    {
        ArrayList<Integer> res = new ArrayList<>();
        while(!list.isEmpty()){
            int num = list.removeLast();
            if(list.isEmpty()){
                return res;
            }
            int f = list.getFirst();
            res.add(f);
            list.set(0,num);
            checkValidForDelete(list,list.size(),0);
        }
        return res;
    }

    private static void checkValidForDelete(ArrayList<Integer> list, int size,int ind) {
        if(((ind+1)*2)>=size)
        {
            return;
        }
        int left = (ind+1)*2;
        int right = ((ind+1)*2)+1;
        if(list.get(ind)>list.get(left-1) && list.get(left-1)<list.get(right-1)){
            swap(list,ind,left-1);
            checkValidForDelete(list,size,left-1);
        }
        if(list.get(ind)>list.get(right-1)&& list.get(left-1)>list.get(right-1))
        {
            swap(list,ind,right-1);
            checkValidForDelete(list,size,right-1);
        }
    }

    private static void insert(ArrayList<Integer> list) {
        System.out.println("Enter number to insert :");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        list.addLast(num);
        checkValid(list,list.size());
    }

    private static void checkValid(ArrayList<Integer> list,int ind) {
        if(ind<=1)
        {
            return;
        }
        int parent = ind/2;
        if(list.get(parent-1)>list.get(ind-1))
        {
            swap(list,parent-1,ind-1);
            checkValid(list,parent);
        }
    }

    private static void swap(ArrayList<Integer> list, int s, int d) {
        int temp = list.get(s);
        list.set(s,list.get(d));
        list.set(d,temp);
    }
}
