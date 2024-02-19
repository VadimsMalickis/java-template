package rvt.exercises;

public class CD implements Packable {
    private String artist;
    private String name;
    private int year;

    public CD(String artist, String name, int year) {
        this.artist = artist;
        this.name = name;
        this.year = year;
    }

    @Override
    public double weight() {
        // kg
        return 0.1;
    }

    public String toString() {
        return this.artist + ": " + this.name + " (" + this.year + ")";
    }

}
