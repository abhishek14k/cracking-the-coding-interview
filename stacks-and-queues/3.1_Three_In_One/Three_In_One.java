/*
Problem Statement:
Three in One: Describe how you could use a single array to implement three stacks.
*/

public class Three_In_One {

    public static class ThreeStackArray {
        private int numStack = 3;
        private int stackSize;
        private int[] values;   //stores the elements of all 3 stacks
        private int[] sizes;    //keeps track of the number of values in each stack

        public ThreeStackArray(int stackSize) {
            this.stackSize = stackSize;
            values = new int [stackSize * numStack];
            sizes = new int[numStack];
        }
		
		//Method to return top element of that stack
        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackSize;
            int size = sizes[stackNum];
            return offset - size -1;
        }
    }

    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String err) {
            super(err);
        }
    }

    public static class FullStackException extends RuntimeException {
        public FullStackException(String err) {
            super(err);
        }
    }

    public static void main(String[] args) {

        ThreeStackArray stack = new ThreeStackArray(5);
//        stack.push(0,1);
//        stack.push(0,1);
//        stack.push(0,1);
//        stack.push(0,1);
//        stack.push(0,1);
//        stack.pop(0);
//        stack.push(0,1);
    }
}
