public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<String>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                long l1 = Long.parseLong(s1 + s2);
                long l2 = Long.parseLong(s2 + s1);
                if (l1 > l2) {
                    return -1;
                } else if (l1 < l2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        if (list.size() > 0 && list.get(0).equals("0")) {
            return "0";
        }
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}