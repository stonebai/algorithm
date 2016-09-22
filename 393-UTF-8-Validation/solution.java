public class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int i = 0;
        while (i < data.length) {
            if (data[i] < 128) {
                i++;
            } else {
                if (data[i] >= 192 && data[i] <= 223) {
                    if (data.length <= i + 1) {
                        return false;
                    }
                    if (data[i + 1] < 128 || data[i + 1] >= 192) {
                        return false;
                    }
                    i += 2;
                } else if (data[i] >= 224 && data[i] <= 239) {
                    if (data.length <= i + 2) {
                        return false;
                    }
                    if (data[i + 1] < 128 || data[i + 1] >= 192 || data[i + 2] < 128 || data[i + 2] >= 192) {
                        return false;
                    }
                    i += 3;
                } else if (data[i] >= 240 && data[i] <= 247) {
                    if (data.length <= i + 3) {
                        return false;
                    }
                    if (data[i + 1] < 128 || data[i + 1] >= 192 ||
                        data[i + 2] < 128 || data[i + 2] >= 192 ||
                        data[i + 3] < 128 || data[i + 3] >= 192) {
                            return false;
                        }
                    i += 4;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}