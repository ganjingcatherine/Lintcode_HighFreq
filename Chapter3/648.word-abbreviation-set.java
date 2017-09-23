public class ValidWordAbbr {
    /*
    * @param dictionary: a list of words
    */
    
    private Map<String, Integer> dict;
    private Map<String, Integer> abbr;
    
    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<>();
        abbr = new HashMap<>();
        
        for (String word : dictionary) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
            
            String a = getAbbr(word);
            abbr.put(a, abbr.getOrDefault(a, 0) + 1);
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        return dict.get(word) == abbr.get(getAbbr(word));
    }
    
    private String getAbbr(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */