/**
* Date: 05/19/18
*
*
*
*/

//Solution from discuss 
public class Solution {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		int num = 0;
		int sign = 1;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				num = 10 * num + (int)(c - '0');
			}
			else if (c == '+') {
				res += sign * num;
				num = 0;
				sign = 1;
			}
			else if (c == '-') {
				res += sign * num;
				num = 0;
				sign = -1;
			}
			else if (c == '(') {
				stack.push(res);
				stack.push(sign);
				sign = 1;
				res = 0;
			}
			else if (c == ')') {
				res += sign * num;
				num = 0;
				res *= stack.pop();
				res += stack.pop();
			}
		}
		if (num != 0) res += sign * num;
		return res;
	}
}
