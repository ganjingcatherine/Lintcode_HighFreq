public class LoadBalancer {
    
    private Map<Integer, Integer> idxMap;   // Key: server_id, Value: idx in array
    private List<Integer> servers;          // array of server_id
    private Random rand;                    // random generator
    private int n;                          // current idx of the servers
    
    public LoadBalancer() {
        idxMap = new HashMap<>();
        servers = new ArrayList<>();
        rand = new Random();
        n = 0;
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        servers.add(server_id);
        idxMap.put(server_id, n++);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        int lastItem = servers.get(n - 1);
        int removeIdx = idxMap.get(server_id);
        
        idxMap.put(lastItem, removeIdx);
        servers.set(removeIdx, lastItem);
        
        // remove the last
        servers.remove(n - 1);
        idxMap.remove(server_id);
        
        n--;
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        int idx = rand.nextInt(n);
        return servers.get(idx);
    }
}