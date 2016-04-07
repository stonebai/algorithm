public class NumArray {
    
    class SegNode {
        public int left;
        public int right;
        public int value;
        public SegNode lc;
        public SegNode rc;
        
        public SegNode(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    
    private SegNode buildSeg(int[] nums, int i, int j) {
        if(i==j) return new SegNode(i, j, nums[i]);
        int mid = i + (j-i) / 2;
        SegNode left = buildSeg(nums, i, mid);
        SegNode right = buildSeg(nums, mid+1, j);
        SegNode root = new SegNode(i, j, left.value + right.value);
        root.lc = left;
        root.rc = right;
        return root;
    }
    
    private void updateSeg(SegNode root, int[] nums, int i, int val) {
        if(i>=root.left && i<=root.right) {
            root.value += val - nums[i];
            if(root.lc!=null) {
                updateSeg(root.lc, nums, i, val);
            }
            if(root.rc!=null) {
                updateSeg(root.rc, nums, i, val);
            }
        }
    }
    
    private int resSeg(SegNode root, int i, int j) {
        if(i<=root.left && j>=root.right) {
            return root.value;
        }
        int mid = root.left + (root.right - root.left) / 2;
        if(i>mid && i<=root.right && root.rc!=null) {
            return resSeg(root.rc, i, j);
        }
        if(j<mid && j>=root.left && root.lc!=null) {
            return resSeg(root.lc, i, j);
        }
        int left=0, right=0;
        if(root.lc!=null) left = resSeg(root.lc, i, j);
        if(root.rc!=null) right = resSeg(root.rc, i, j);
        return left + right;
    }
    
    private SegNode root;
    private int[] nums;

    public NumArray(int[] nums) {
        if(nums==null || nums.length==0) return;
        this.nums = nums;
        root = buildSeg(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        if(root!=null && nums!=null) {
            updateSeg(root, nums, i, val);
            nums[i] = val;   
        }
    }

    public int sumRange(int i, int j) {
        if(root!=null) return resSeg(root, i, j);
        else return 0;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);