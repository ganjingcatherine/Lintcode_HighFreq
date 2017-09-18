/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
     
    private char[] buf4 = new char[4];
    private int buf4Size = 4;
    private int buf4Idx = 4;
    
    public int read(char[] buf, int n) {
        int k = 0;

        while (k < n) {
            if (buf4Idx >= buf4Size) {
                buf4Size = read4(buf4);
                buf4Idx = 0;
                if (buf4Size == 0) {
                    return k;
                }
            }
        
            buf[k++] = buf4[buf4Idx++];
        }
        
        return k;
    }
}
