class MyCircularDeque {
    int [] data ;
    int front;
    int rear;
    int size;

    public MyCircularDeque(int k) {
        data = new int[k];
        front = 0;
        rear = k-1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if(size == data.length)
        {
            return false;
        }
        data[front] = value;
        front = (front+1)%data.length;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == data.length)
        {
            return false;
        }
        data[rear] = value;
        rear = (rear - 1 + data.length)%data.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0)
        {
            return false;
        }
        front = (front-1 + data.length)%data.length;
        int val = data[front];
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0)
        {
            return false;
        }
        rear = (rear+1)%data.length;
        int val = data[rear];
        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0)
        {
            return -1;
        }
        
        int val = data[(front-1 + data.length)%data.length];
        
        return val;
    }
    
    public int getRear() {
        if(size == 0)
        {
            return -1;
        }
        int val = data[(rear + 1 )%data.length];
        return val;
    }
    
    public boolean isEmpty() {
        if(size == 0 )
        {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(size == data.length )
        {
            return true;
        }
        return false;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */