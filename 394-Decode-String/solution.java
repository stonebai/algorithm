public class Solution {
    
    static class Node {
        String str;
        int index;
        
        Node(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        int num = 0;
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = num * 10 - '0' + chs[i];
            } else if (chs[i] == ']') {
                break;
            } else if (chs[i] == '[') {
                Node node = dfs(chs, i + 1);
                sb.append(repeat(node.str, num));
                num = 0;
                i = node.index;
            } else {
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }
    
    private Node dfs(char[] chs, int i) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (i < chs.length) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = num * 10 - '0' + chs[i];
            } else if (chs[i] == ']') {
                return new Node(sb.toString(), i);
            } else if (chs[i] == '[') {
                Node node = dfs(chs, i + 1);
                sb.append(repeat(node.str, num));
                num = 0;
                i = node.index;
            } else {
                sb.append(chs[i]);
            }
            i++;
        }
        return new Node(sb.toString(), i + 1);
    }
    
    private String repeat(String str, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < k;i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}