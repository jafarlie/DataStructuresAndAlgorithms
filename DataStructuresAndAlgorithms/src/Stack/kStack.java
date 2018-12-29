package Stack;

public class kStack {
    int[] arr; // of size n, to store the content of stacks
    int[] top; // Array of size k to store indexes of top elements of stacks
    int[] next; // Array of size n to store next entry in all stacks
    int n, k;
    int free;

    public kStack(int k1, int n1){
        k = k1;
        n = n1;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // initialize all stacks as empty
        for(int i=0; i< k; i++){
            top[i] = -1;
        }
        // initialize all spaces as free
        free = 0;
        for(int i=0; i < n - 1; i++){
            next[i] = i + 1;
        }
        next[n-1] = -1; // -1 is used to indicate end of free list
    }
    // A utility function to check if there is space available
    public boolean isFull(){
        return (free == -1);
    }

    // To check whether stack number 'stackNum' is empty or not
    public boolean isEmpty(int stackNum){
        return top[stackNum] == -1;
    }

    public void push(int item, int sn){
        // overflow check
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        int i = free; // Store index of first free slot
        free = next[i]; // Update index of free slot to index of next slot in free list

        // Update next of top and then top for stack number 'sn'
        next[i] = top[sn];
        top[sn] = i;

        // Put the item in array
        arr[i] = item;
    }

    // To pop an from stack number 'sn' where sn is from 0 to k-1
    public int pop(int sn){
        if(isEmpty(sn)) {
            System.out.println("Stack underflow");
            return Integer.MAX_VALUE;
        }
        // Find index of top item in stack number 'sn'
        int i = top[sn];

        top[sn] = next[i]; // Change top to store next of previous top

        // Attach the previous top to the beginning of free list
        next[i] = free;
        free = i;

        // Return the previous top item
        return arr[i];
    }

    public static void main(String[] args){
        // Let us create 3 stacks in an array of size 10
        int k = 3, n = 10;
        kStack ks = new kStack(k,n);

        ks.push(15, 2);
        ks.push(45, 2);

        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }

}
