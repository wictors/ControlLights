package program.openLab;

// May be replaced with interface.
public abstract class Connection {

    public abstract boolean onLights();
    public abstract boolean offLights();
    public abstract boolean setColorLights(String[] lights, int duration);
}
