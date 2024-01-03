import java.util.regex.Pattern;
class Solution {
    public String removeOccurrences(String s, String part) {
        Pattern pat = Pattern.compile(".*?"+part+".*?");
        StringBuilder sbr = new StringBuilder(s);
        var matcher = pat.matcher(sbr);
        while(matcher.lookingAt()){
            int j = matcher.end();
            sbr.replace(j-part.length(), j, "");
            matcher = pat.matcher(sbr);
        }
        return sbr.toString();
    }
}
