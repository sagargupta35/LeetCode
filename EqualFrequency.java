class EqualFrequency {
    public boolean equalFrequency(String word) {
        int len = word.length();
        int[] count = new int[26];
        for (int i = 0; i < len; ++ i) {
            char c = word.charAt(i);
            count[c - 'a'] ++;
        }
        for (int i = 0; i < len; ++ i) {
            char c = word.charAt(i);
            count[c - 'a'] --;
            if (equalCount(count)) {
                return true;
            }
            count[c - 'a'] ++;
        }
        
        return false;
    }
    
    public boolean equalCount(int[] count) {
        int c = 0;
        
        for (int i: count) {
            if (i == 0) {
                continue;
            } else if (c == 0) {
                c = i;
            } else if (c == i) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
