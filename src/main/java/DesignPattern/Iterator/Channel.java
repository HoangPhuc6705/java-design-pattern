package DesignPattern.Iterator;

public class Channel {
    private double frequency;
    private String type;

    public Channel(double frequency, String type) {
        this.frequency = frequency;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "frequency=" + frequency +
                ", type='" + type + '\'' +
                '}';
    }

    public double getFrequency() {
        return frequency;
    }

    public String getType() {
        return type;
    }
}
