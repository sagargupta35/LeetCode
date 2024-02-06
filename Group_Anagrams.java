class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        int n = arr.length;
        int empty = 0;
        for(int i = 0; i<n; i++){
            int [] f = new int [26];
            String s = arr[i];
            if(s.length() == 0){
                empty++;
                continue;
            }
            for(int j = 0; j<arr[i].length(); j++){
                f[s.charAt(j)-'a']++;
            }
            StringBuilder sbr = new StringBuilder();
            for(int j = 0; j<26; j++){
                if(f[j] != 0){
                    sbr.append((char)(j+'a'));
                    sbr.append(f[j]);
                }
            }
            map.merge(sbr.toString(), new ArrayList<>(List.of(s)), (old, val) -> {
                old.add(s);
                return old;
            });
        }
        List<List<String>> res = new ArrayList<>(map.values());
        if(empty != 0){
            List<String> em = new ArrayList<>();
            while (empty-- > 0){
                em.add("");
            }
            res.add(em);
        }
        return res;
    }
}
