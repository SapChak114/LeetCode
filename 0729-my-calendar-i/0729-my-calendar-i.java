class TreeNode {
    TreeNode left;
    TreeNode right;
    int start;
    int end;

    public TreeNode(int start, int end) {
        this.left = null;
        this.right = null;
        this.start = start;
        this.end = end;
    }
}

class Tree {
    TreeNode root;

    public Tree(int start, int end) {
        root = new TreeNode(start, end);
    }

    public boolean insert(int start, int end) {
        TreeNode curr = root;
        while (true) {
            if (start >= curr.end) {
                if (curr.right == null) {
                    curr.right = new TreeNode(start, end);
                    return true;
                }
                curr = curr.right;
            } else if (end <= curr.start) {
                if (curr.left == null) {
                    curr.left = new TreeNode(start, end);
                    return true;
                }
                curr = curr.left;
            } else {
                return false;
            }
        }
    }
}
class MyCalendar {
    Tree root;
    public MyCalendar() {
        this.root = null;
    }
    
    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Tree(startTime, endTime);
            return true;
        }
        return root.insert(startTime, endTime);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */