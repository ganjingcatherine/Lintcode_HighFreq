/* Initial Version */
public class MovingAverage {

    private int size;       // sliding window size
    private int idx;        // current index of the array
    private int[] presum;   // prefix sum

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        idx = 1;
        presum = new int[100000];
    }
    
    public double next(int val) {
        presum[idx] = val + presum[idx - 1];

        if (idx <= size) {
            double ans = (double) presum[idx] / idx;
            idx++;
            return ans;
        }
        
        double ans = 0;
        ans = presum[idx] - presum[idx - size];
        idx++;
        return ans / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */


 /* Final Version */
public class MovingAverage {

    private int size;       // sliding window size
    private int idx;        // current index of the array
    private double[] presum;   // prefix sum

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        idx = 0;
        presum = new double[size+1];
    }
    
    private int mod(int idx) {
        return idx % (size + 1);
    }
    
    public double next(int val) {
        idx++;
        
        presum[mod(idx)] = val + presum[mod(idx - 1)];

        if (idx <= size) {
            return presum[mod(idx)] / idx;
        }
        
        return (presum[mod(idx)] - presum[mod(idx - size)]) / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */

