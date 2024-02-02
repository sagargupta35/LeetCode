class Solution {
    public List<Integer> sequentialDigits(Integer low, int high) {
        List<Integer> list = new ArrayList<>();
        if(low > 123456789) return list;
        String s = low.toString();
        int len = low.toString().length();
        int st = s.charAt(0)-'0';
        int one = Integer.parseInt("1".repeat(len));
        Integer k = getNextSequential(st, len);
        if(k == null){
            k = getNextSequential(1, len+1);
            len++;
            one *= 10;
            one++;
        }
        if(k != null){
            if (k < low) {
                if (k % 10 == 9) {
                    k = getNextSequential(1, len + 1);
                    len++;
                    one *= 10;
                    one++;
                } else {
                    k += one;
                }
            }
            if(k != null) {
                while (k <= high) {
                    list.add(k);
                    if (k % 10 == 9) {
                        k = getNextSequential(1, len + 1);
                        if (k == null) break;
                        len++;
                        one *= 10;
                        one++;
                    } else {
                        k += one;
                    }
                }
            }
        }
        return list;
    }

    static Integer getNextSequential(int st, int len){
        if(st+len-1 > 9) return null;
        int res = st, temp = st+1;
        for(int i = 1; i<len; i++){
            res *= 10;
            res += temp;
            temp++;
        }
        return res;
    }
}
