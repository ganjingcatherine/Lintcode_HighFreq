/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // if a knows b, then a is not celebrity
        // if a !knows b, then b is not celebrity
        
        int cand = 0;
        for (int i = 1; i < n; i++) {
            if (knows(cand, i)) {
                cand = i;
            }
        }
        
        // Check if the last remaining is celebrity
        // all the other n - 1 people know him/her
        for (int i = 0; i < n; i++) {
            if (i != cand && !knows(i, cand)) {
                return -1;
            }
        }
        
        // but he/she does not know any of them.
        for (int i = 0; i < n; i++) {
            if (i != cand && knows(cand, i)) {
                return -1;
            }
        }
        
        return cand;
    }
}