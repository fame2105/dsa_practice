package design.patterns.structural.composite;

public abstract class SongComponent {
    public void add(SongComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(int ComponentIndex) {
        throw new UnsupportedOperationException();
    }

    public SongComponent getComponent(int componentIndex) {
        throw new UnsupportedOperationException();
    }

    public SongComponent getSongName(int componentIndex) {
        throw new UnsupportedOperationException();
    }

    public String getBandName() {
        throw new UnsupportedOperationException();
    }

    public int getReleaseYear() {
        throw new UnsupportedOperationException();
    }

    // When this is called by a class object that extends
    // SongComponent it will print out information
    // specific to the Song or SongGroup

    public void displaySongInfo() {
        throw new UnsupportedOperationException();
    }

}
