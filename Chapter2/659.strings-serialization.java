public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        if (strs == null) {
            return "";
        }
        
        // use ":;" to separate strings, use "::" to represent ":"
        StringBuilder ans = new StringBuilder();
        
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                if (c == ':') {         // ":" itself
                    ans.append("::");
                } else {                // ordinary character
                    ans.append(c);
                }
            }
            ans.append(":;");           // ";" separator
        }
        
        return ans.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }

        char[] sc = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < sc.length) {
            if (sc[i] == ':') {
                if (sc[i + 1] == ';') {
                    ans.add(sb.toString());
                    sb = new StringBuilder();
                    i += 2;
                } else {
                    sb.append(":");
                    i += 2;
                }
            } else {
                sb.append(sc[i++]);
            }
        }
        return ans;
    }
}