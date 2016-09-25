public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        hourHelper(list, num, new StringBuilder());
        return list;
    }
    
    private void hourHelper(List<String> list, int num, StringBuilder sb) {
        
        for (int i = 0; i <= 11; i++) {
            int d = numOfDigits(i);
            if (num - d >= 0) {
                int len = sb.length();
                sb.append(String.valueOf(i)).append(":");
                minuteHelper(list, num - d, sb);
                sb.setLength(len);
            }
        }
    }
    
    private void minuteHelper(List<String> list, int num, StringBuilder sb) {
        
        for (int i = 0; i <= 59; i++) {
            int d = numOfDigits(i);
            if (num - d == 0) {
                if (i <= 9) {
                    list.add(sb.toString() + "0" + String.valueOf(i));
                }
                else {
                    list.add(sb.toString() + String.valueOf(i));
                }
            }
        }
    }
    
    private int numOfDigits(int i) {
        if (i == 0) return 0;
        
        int sum = 1;
        while ((i & (i - 1)) != 0) {
            sum++;
            i &= (i - 1);
        }
        return sum;
    }
}
