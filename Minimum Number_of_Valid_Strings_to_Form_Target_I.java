static class Link{
        Link [] links = new Link[26];
        void addNode(char c){
            c -= 'a';
            if(links[c] == null) links[c] = new Link();
        }
        Link getNode(char c){
            return links[c-'a'];
        }
    }

    public int minValidStrings(String[] words, String target) {
        Link root = new Link();
        for(String word: words){
            Link cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur.addNode(word.charAt(i));
                cur = cur.getNode(word.charAt(i));
            }
        }
        int [] dp = new int [target.length()];
        Arrays.fill(dp, -1);
        int cost = getCost(target, 0, root, dp);
        if(cost == Integer.MAX_VALUE) return -1;
        return cost;
    }

    static int getCost(String s, int st, Link root, int [] dp){
        if(st >= s.length()) return 0;
        if(dp[st] != -1) return dp[st];
        Link cur = root.getNode(s.charAt(st));
        int cost = Integer.MAX_VALUE;
        int i = 1;
        while (st + i <= s.length() && cur != null){
            int next = getCost(s, st+i, root,dp);
            if(next != Integer.MAX_VALUE){
                cost = Math.min(cost, next+1);
            }
            if(st + i == s.length()) break;
            cur = cur.getNode(s.charAt(st+i));
            i++;
        }
        return dp[st] = cost;
    }
