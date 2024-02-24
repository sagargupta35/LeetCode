class Solution {
    static class Graph{
        NavigableMap<Integer, List<Integer>> [] edges;
        int vertices;
        public Graph(int [][] edges, int vertices){
            this.edges = new TreeMap [vertices];
            for(var arr : edges){
                if(this.edges[arr[0]] == null) this.edges[arr[0]] = new TreeMap<>();
                if(this.edges[arr[1]] == null) this.edges[arr[1]] = new TreeMap<>();
                this.edges[arr[0]].merge(arr[2], new ArrayList<>(List.of(arr[1])), (old, val) -> {
                    old.add(arr[1]);
                    return old;
                });
                this.edges[arr[1]].merge(arr[2], new ArrayList<>(List.of(arr[0])), (old, val) -> {
                    old.add(arr[0]);
                    return old;
                });
            }
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Graph graph = new Graph(meetings, n);
        Integer [] visited = new Integer[n];
        findAllPeople(graph, firstPerson, visited, 0);
        findAllPeople(graph, 0, visited, 0);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(visited[i] != null) res.add(i);
        }
        return res;
    }

    public static void findAllPeople(Graph graph, int cur, Integer [] visited, int time) {
        if(visited[cur] != null && visited[cur] <= time) return;
        visited[cur] = time;
        if(graph.edges[cur] != null) {
            for (var entry : graph.edges[cur].entrySet()) {
                for (var person : entry.getValue()) {
                    if(entry.getKey() >= time) findAllPeople(graph, person, visited, entry.getKey());
                }
            }
        }
    }
}
