public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new LinkedList<String>();
        
        int len = 0;
        int start = 0;
        for(int i=0;i<words.length;i++) {
            if(len==0) len += words[i].length();
            else len += words[i].length() + 1;
            if(len>maxWidth) {
                len -= words[i].length() + 1;
                StringBuilder sb = new StringBuilder();
                int num = i - start;
                if(num==1) {
                    sb.append(words[start]);
                    addSpaces(sb, maxWidth - len);
                }
                else {
                    int spaces = num - 1 + maxWidth - len;
                    int average = spaces / (num - 1);
                    int external = spaces % (num - 1);
                    sb.append(words[start++]);
                    while(start<i) {
                        if(external>0) {
                            external--;
                            addSpaces(sb, average + 1);
                        }
                        else {
                            addSpaces(sb, average);
                        }
                        sb.append(words[start++]);
                    }
                }
                res.add(sb.toString());
                start = i;
                len = words[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[start++]);
        while(start<words.length) {
            sb.append(' ' + words[start++]);
        }
        addSpaces(sb, maxWidth - len);
        // int num = words.length - start;
        // if(num==1) {
        //     sb.append(words[start]);
        //     addSpaces(sb, maxWidth - len);
        // }
        // else {
        //     int spaces = num - 1 + maxWidth - len;
        //     int average = spaces / (num - 1);
        //     int external = spaces % (num - 1);
        //     sb.append(words[start++]);
        //     while(start<words.length) {
        //         if(external>0) {
        //             external--;
        //             addSpaces(sb, average + 1);
        //         }
        //         else {
        //             addSpaces(sb, average);
        //         }
        //         sb.append(words[start++]);
        //     }
        // }
        res.add(sb.toString());
        return res;
    }
    
    private void addSpaces(StringBuilder sb, int spaces) {
        for(int i=0;i<spaces;i++) {
            sb.append(' ');
        }
    }
}