class MyCircularQueue {

int[] arr;
int front;
int rear;
int size;

public MyCircularQueue(int n) {
	size = n;
	arr = new int[size];
	front = rear = -1;
}

boolean enQueue(int value){
	//to check whether queue is full
	if( (front == 0 && rear == size-1) || (rear == (front-1) ) ) {
		return false;
	}
	else if(front == -1) //first element to push
	{
		front = rear = 0;

	}
	else if(rear == size-1 && front != 0) {
		rear = 0; //to maintain cyclic nature
	}
	else
	{//normal flow
		rear++;
	}
	//push inside the queue
	arr[rear] = value;

	return true;
}


boolean deQueue(){
	if(front == -1){//to check queue is empty
		return false;
	}
	int ans = arr[front];
	arr[front] = -1;
	if(front == rear) { //single element is present
		front = rear = -1;
	}
	else if(front == size - 1) {
		front = 0; //to maintain cyclic nature
	}
	else
	{//normal flow
		front++;
	}
	return true;
}

public int Front() {
 if(front == -1)
		return -1;
	else
		return arr[front];
}

public int Rear() {
   if(rear == -1) 
       return -1;
    else 
        return arr[rear];
}

public boolean isEmpty() {
 if (rear == -1 && front == -1)
		return true;
	else
		return false;
}

public boolean isFull() {
   if((front == 0 &&  rear == size-1) || (rear == (front-1)%(size-1)))
       return true;
    else 
        return false;
}
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */