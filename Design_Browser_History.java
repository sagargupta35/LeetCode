class BrowserHistory {

    private List<String> history;
    private int forwardLimit;
    private int current;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        forwardLimit = 0;
        current = 0;
    }

    public void visit(String url) {
        if(current == history.size()-1){
            current++;
            history.add(url);
        } else{
            history.add(current+1, url);
            current++;
        }
        forwardLimit = current;
    }

    public String back(int steps) {
        current = Math.max(0, current-steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(forwardLimit, current+steps);
        return history.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
