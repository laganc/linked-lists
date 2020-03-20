/*
 * Name: Lagan
 * Student Number: V00905230
 */

public class IntegerLinkedList implements IntegerList{

	IntegerNode head;
	IntegerNode tail;
	int count;

	public IntegerLinkedList(){
		head = null;
		tail = null;
		count = 0;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x){
		IntegerNode n = new IntegerNode(x);
		if(head == null){
			head = n;
			tail = n;
			count++;
		}
		else{
			n.next = head;
			head = n;
			count++;
		}
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */
	public void addBack (int x){
		IntegerNode n = new IntegerNode(x);
		if(head == null){
			head = n;
			tail = n;
			count++;
		}
		else{ 
            IntegerNode temp = head; 
            while(temp.next != null){ 
                temp = temp.next; 
            } 
            temp.next = n;
            tail = n;
            count++;
        }
	}

	/*
	 * PURPOSE:
	 *   Add the element x at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for addAt are
	 *   0, 1, 2, 3.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos <= l.size()
	 *
	 * Examples:
	 *
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 * If l is {1} and l.addAt(9,0) returns, then l is {9,1}.
	 * If l is {1,2} and l.addAt(9,1) returns, then l is {1,9,2}
	 * If l is {1,2} and l.addAt(9,2) returns, then l is {1,2,9}
	 */
	public void addAt (int x, int pos){
		IntegerNode n = new IntegerNode(x);
		IntegerNode temp = head;
		IntegerNode prev = null;

		if(pos == 0){
			this.addFront(x);
		}

		else if(pos == 1){
			n.next = head.next;
			head.next = n;
			count++;
		}

		else if(pos == this.size()){
			this.addBack(x);
		}

		else if (pos > 0 && pos < this.size()){
			for(int i = 0; i < pos; i++){
				prev = temp;
				temp = temp.next;
			}
			n.next = temp;
			prev.next = n;
			count++;
		}
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size(){
		return count;
	}

	/*
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int get (int pos){
		IntegerNode temp = head;
		int index = 0;

		while(index < pos){
			index++;
			temp = temp.next;
		}
	    return temp.value;
	}

	/*
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear(){
		IntegerNode temp = head;

		while(temp.next != null){
			temp = temp.next;
		}
		head = temp;
		temp = head;
		this.removeAt(0);
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Remove all instances of value from the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value){
		IntegerNode temp = head;

		while(head != null && head.value == value){
        	head = head.next;
        	count --;
    	}

    	if(head == null){
        	return;
    	}

    	while (temp.next != null){
        	if(temp.next.value == value){
            	temp.next = temp.next.next;
            	count --;
        	} 
        	else{
            	temp = temp.next;
        	}
    	}
	}

	/*
	 * PURPOSE:
	 *   Remove the element at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for removeAt are
	 *   0, 1, 2.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *
	 * If l is {1} and l.removeAt(0) returns, then l is {}.
	 * If l is {1,2,3} and l.removeAt(1) returns, then l is {1,3}
	 * If l is {1,2,3} and l.removeAt(2) returns, then l is {1,2}
	 */
	public void removeAt (int pos){
		IntegerNode temp = head; 
		IntegerNode temp1 = head;

		if (head == null){
            return;
		}

        if (pos == 0 && head != null){ 
            head = temp.next;
            
        	if(this.size() == 1){
            	head = null;
            	count = 0;
            }
        } 

        for (int i=1; temp != null && i < pos; i++){
            temp = temp.next; 
        }
  
        if(temp.next == null){
            return; 
        }

        temp.next = temp.next.next; 
        count--;

        System.out.println(this.toString());
	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		IntegerNode p = head;
		String s = "{";
		if(this.size() != 0){
			while (p != null){
				s += p.value;
				if (p.next != null)
					s+= ",";
				p = p.next;
			}
			s+= "}";
			return s;
		}
		else {
			return "{}";
		}
	}
}
