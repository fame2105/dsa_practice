package design.patterns.structural.composite;

import java.util.ArrayList;
// A composite object will hold other compositeObjects as well single(Leaf) objects

// SongGroup is a composite Object that represents a collection songs and is contained within another SongGroup(Composite Object)
public class SongGroup extends SongComponent {

    ArrayList<SongComponent> songComponents = new ArrayList<>();

    private String groupName;
    private String groupDescription;

    public SongGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public void add(SongComponent songComponent) {
        songComponents.add(songComponent);
    }

    @Override
    public void remove(int componentIndex) {
        songComponents.remove(componentIndex);
    }

    @Override
    public void displaySongInfo() {

        System.out.println("Song Group : " + getGroupName() + " " + getGroupDescription() + " contains following Songs " + "=> \n");

        for(SongComponent songInfo : songComponents) {
            songInfo.displaySongInfo();
        }
    }
}
