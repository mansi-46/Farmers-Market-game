import java.util.*;
public class A1Q4 {
    public static class priorityQueue{
        ArrayList<Integer> items;
        public priorityQueue(){
            items = new ArrayList<>();
        }
        public void add(int value){
            items.add(value);
            upHeap(items.size() - 1);
        }
        private void upHeap(int i) {
            if(i == 0){
                return;
            }
            int parent = (i - 1)/2;
            if(items.get(i) > items.get(parent)){
                swap(i,parent);
                upHeap(parent);
            }
        }
        private void swap(int i, int j){
            int ith = items.get(i);
            int jth = items.get(j);
            items.set(i,jth);
            items.set(j,ith);
        }
        public int remove() {
            if(this.size() == 0) { return -1; }
            swap(0,items.size() - 1);
            int value = items.remove(items.size() - 1);
            downHeap(0);
            return value;
        }
        private void downHeap(int i){
            int max = i;
            int leftChild = 2*i+1;
            if(leftChild < items.size() && items.get(leftChild) > items.get(max)) {
                max = leftChild;
            }
            int rightChild = 2*i+2;
            if(rightChild < items.size() && items.get(rightChild) > items.get(max)) {
             max = rightChild;
            }
            if(max != i){
                swap(i, max);
                downHeap(max);
            }
        }
        public int peek() {
            if(this.size() == 0){
                return -1;
            }
            return items.get(0);
        }
        public int size() {
            return items.size();
        }
        public String toString(){
            return items.toString();
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        priorityQueue queue = new priorityQueue();
        int n = in.nextInt();
        int k = in.nextInt();
        if(k<=n && k!=0){
            for(int i = 0; i<n ;i++){
                queue.add(in.nextInt());
            }
        }
        else {
            System.exit(0);
        }
        for (int i = 0; i<k ;i++)
        System.out.print(queue.remove() + " ");
    }
}
