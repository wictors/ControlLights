package program.openLab;

public abstract class Connection {

    public abstract boolean onLights();
    public abstract boolean offLights();
    public abstract boolean setColorLights(String[] lights, int duration);
}
