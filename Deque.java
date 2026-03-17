import java.util.Arrays;

public class Deque {
	private int maxSize;
	private int[] dequeArray;
	private int begin = -1;
	private int end = -1;
	private int nItems = 0;
	
	public Deque(int s){
		maxSize = s;
		dequeArray = new int[maxSize];
	}
	
	public boolean empty() {
		return nItems == 0;
	}
	
	public boolean full() {
		return nItems == maxSize;
	}
	
	//_ _ _ _ _
	//1 _ _ _ _
	
	public void pushFront(int add){
		if(!full()) {
			if(empty()){
				begin = 0;
				end = 0;
			} else {
				begin = (begin - 1 + maxSize) % maxSize;
			}
			
			dequeArray[begin] = add;
			nItems++;
		} else {
			System.out.println("deque penuh");
		}
	}
	
	public void popFront(){
		if(!empty()){
			int temp = dequeArray[begin];
			begin = (begin + 1) % maxSize;
			nItems--;
			if(empty()){
				begin = -1;
				end = -1;
			}
			System.out.println("Menghapus front dengan value: " + temp);
		} else {
            System.out.println("deque kosong");
        }
	}
	
	public void pushBack(int add) {
		if(!full()){
			if(empty()){
				begin = 0;
				end = 0;
			} else {
				end = (end + 1) % maxSize;
			}
			
			dequeArray[end] = add;
			nItems++;
		} else {
			System.out.println("deque penuh");
		}
	}
	
	public void popBack() {
		if(!empty()){
			int temp = dequeArray[end];
			end = (end - 1 + maxSize) % maxSize;
			nItems--;
			if(empty()) {
				end = -1;
				begin = -1;
			}
			System.out.println("Mengahpus back dengan value: " + temp);
		} else {
            System.out.println("deque kosong");
        }
	}
	
	
	public void front() {
		System.out.println("Nilai dari front adalah: " + dequeArray[begin]);
	}
	
	public void back () {
		System.out.println("Nilai dari back adalah: " + dequeArray[end]);
	}

	public void display() {
		int[] tempArray = new int[maxSize];
		
		int count = 0;
		int cur = begin;
		int idx = 0;
		while (count++ < maxSize){
			tempArray[idx++] = count <= nItems ? dequeArray[cur++] : 0;
			if(cur == maxSize) {
				cur = 0;
			}
		}
		
		System.out.println(Arrays.toString(tempArray));
	}
	
	public static void main(String[] args) {
		Deque dq = new Deque(10);
		dq.pushBack(3); // Array State: 3
		dq.pushFront(1); // Array State: 1 3
		dq.pushBack(7); // Array State: 1 3 7
		dq.back(); // Returns 7
		dq.pushFront(2); // Array State: 2 1 3 7
		dq.pushFront(9); // Array State: 9 2 1 3 7
		dq.front(); // Return 9

		System.out.print("The deque is: ");
		dq.display(); // Expect: [9, 2, 1, 3, 7]

		dq.popBack(); // Array State: 9 2 1 3
		dq.back(); // Returns 3
		dq.popFront(); // Array State: 2 1 3
		dq.front(); // Returns 2

		System.out.print("The linked list is: ");
		dq.display(); // Expect: [2, 1, 3]
	}
}
