import java.util.regex.Pattern;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pt = Pattern.compile("([0-9]*)\\s(.*)");
        var matcher = pt.matcher("");
        for(String str: cpdomains){
            matcher = pt.matcher(str);
            int freq = 0;
            String temp = "";
            if(matcher.lookingAt()){
                freq = Integer.parseInt(matcher.group(1));
                temp = matcher.group(2);
            }
            int i = 0;
            while (i >= 0 && i < temp.length()){
                map.merge(temp.substring(i), freq, Integer::sum);
                i = temp.indexOf('.', i);
                if(i != -1) i++;
            }
        }
        List<String> list = new ArrayList<>();
        for(var entry: map.entrySet()){
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return  list;
    }
}
