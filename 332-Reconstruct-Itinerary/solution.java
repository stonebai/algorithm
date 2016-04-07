public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets==null && tickets.length==0) return res;
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        buildGraph(tickets, graph);
        res.add("JFK");
        process(graph, res, "JFK");
        return res;
    }
    
    private boolean process(Map<String, List<String>> graph, List<String> res, String from) {
        List<String> tos = graph.get(from);
        if(tos!=null && tos.size()>0) {
            for(int i=0;i<tos.size();i++) {
                String to = tos.remove(i);
                if(tos.size()==0) graph.remove(from);
                res.add(to);
                if(process(graph, res, to)) return true;
                res.remove(res.size()-1);
                tos.add(i, to);
                if(tos.size()==1) graph.put(from, tos);
            }
            return false;
        }
        else {
            if(graph.isEmpty()) return true;
            else return false;
        }
    }
    
    private void buildGraph(String[][] tickets, Map<String, List<String>> graph) {
        for(int i=0;i<tickets.length;i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(graph.containsKey(from)) {
                List<String> list = graph.get(from);
                list.add(to);
                Collections.sort(list);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(to);
                graph.put(from, list);
            }
        }
    }
}