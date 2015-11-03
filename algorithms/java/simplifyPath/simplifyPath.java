package simplifyPath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//todo
public class simplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        String[] fullPath = path.split("/");
        for (String dir : fullPath) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        String res = "";
        for (String dir : stack)
            res = res + "/" + dir;
        if (res.isEmpty())
            return "/";
        else
            return res;
    }

}
