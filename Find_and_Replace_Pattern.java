import java.util.*;
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int n = pattern.length();
        for(int i = 0; i<n; i++){
            char c = pattern.charAt(i);
            List<Integer> local = map.get(c);
            if(local == null){
                local = new ArrayList<>(pattern.length());
                local.add(i);
                map.put(c, local);
            } else{
                local.add(i);
            }
        }
        List<String> list = new ArrayList<>();
        Collection<List<Integer>> set = map.values();
        for(String test: words){
            if(isMatch(test, set, n)) list.add(test);
        }
        return list;
    }

    public static boolean isMatch(String test, 
            Collection<List<Integer>> set, int n){
        boolean flag = true;
        if(test.length() != n) return false;
        Set<Character> set2 = new HashSet<>();
        for(var list: set){
            char c = test.charAt(list.get(0));
            int n1 = list.size();
            if(!set2.contains(c)) {
                set2.add(c);
                for (int i = 1; i < n1; i++) {
                    if(test.charAt(list.get(i)) != c){
                        flag = false;
                        break;
                    }
                }
            } else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
