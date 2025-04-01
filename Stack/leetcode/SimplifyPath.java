import java.util.*;

class SimplifyPath{
	public static String simplify(String path){
		Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            if (dir.isEmpty() || dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        return result.length() == 0 ? "/" : result.toString();
	}
	public static void main(String args[]){
		String path = "/home/user/Documents/../Pictures";
		System.out.println(simplify(path));
	}
}