class Solution {
   
	public int largestRectangleArea(int[] arr) {
		int area = Integer.MIN_VALUE;
		int height = arr.length;
		int[] next = nextSmallerElement(arr, height);
		int[] prev = prevSmallerElement(arr, height);

		for(int i = 0;i<height;i++) {
			int l = arr[i];
			if(next[i]==-1) {
				next[i] = height;
			}
			int b = next[i] - prev[i] - 1;
			int newArea = l*b;
			area = Integer.max(area, newArea);
		}
		return area;
	}


	private static int[] prevSmallerElement(int[] arr, int height) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int[] ans = new int[arr.length];

		for(int i = 0; i< arr.length; i++)
		{
			int curr = arr[i];
			while(stack.peek()!= -1 && arr[stack.peek()]>=curr) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}


	private static int[] nextSmallerElement(int[] arr, int height) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int[] ans = new int[arr.length];

		for(int i = arr.length-1;i>=0;i--)
		{
			int curr = arr[i];
			while(stack.peek()!= -1 && arr[stack.peek()]>=curr) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}
}