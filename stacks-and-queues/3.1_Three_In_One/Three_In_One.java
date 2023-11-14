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

        public void push(int stackNum, int value) throws FullStackException {
            if(isFull(stackNum)) {
                throw new FullStackException("The stack is full");
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum){
            if(isEmpty(stackNum)) {
                throw new EmptyStackException("The stack is empty!");
            }
            int top_index = indexOfTop(stackNum);
            int value = values[top_index];
            sizes[stackNum]--;
            return value;
        }

        public int peek(int numStack) {
            if(isEmpty(numStack)) {
                throw new EmptyStackException("The stack is empty!");
            }
            return values[indexOfTop(numStack)];
        }

        //Method to return top element of that stack
        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackSize;
            int size = sizes[stackNum];
            return offset + size -1;
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackSize;
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
        stack.push(0,1);
        stack.push(0,1);
        stack.push(0,1);
        stack.push(0,1);
        stack.push(0,1);
        System.out.println("Stack :"+stack);
        stack.pop(0);
        stack.push(0,1);
    }
}
