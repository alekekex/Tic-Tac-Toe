public class Player {
    private String name;
    private Marker m;
    private boolean isAI;

    public Player(String name, Marker m) {
        this.name = name;
        this.m = m;
        this.isAI = false;
    }

    public Player(Marker m) {
        this.name = "AI";
        this.m = m;
        this.isAI = true;
    }

    public String getName() {
        return this.name;
    }

    public Marker getM() {
        return this.m;
    }

    public boolean isAI() {
        return this.isAI;
    }
}
