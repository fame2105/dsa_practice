package design.patterns.structural.composite;

public class DiscJockey {
    SongComponent songList;

    public DiscJockey(SongComponent songList) {
        this.songList = songList;
    }

    // Calls the displaySongInfo() on every Song
    // or SongGroup stored in songList

    public void getSongList(){
        songList.displaySongInfo();
    }

}
