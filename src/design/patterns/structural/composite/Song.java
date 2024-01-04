package design.patterns.structural.composite;

// Song is a single leaf Object that represents a single song and is contained within a SongGroup(Composite Object)
public class Song extends SongComponent {
    private String songName;
    private String bandName;
    private int releaseYear;

    public Song(String songName, String bandName, int releaseYear) {
        this.songName = songName;
        this.bandName = bandName;
        this.releaseYear = releaseYear;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public String getBandName() {
        return bandName;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void displaySongInfo() {
        System.out.println("Song " + getSongName() + " was recorded by " + getBandName() + " in " + getReleaseYear());
    }
}
