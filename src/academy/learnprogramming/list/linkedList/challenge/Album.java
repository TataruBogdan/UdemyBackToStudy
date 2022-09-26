package academy.learnprogramming.list.linkedList.challenge;

import java.util.ArrayList;
import java.util.ListIterator;

public class Album {

    private String name;
    private ArrayList<Song> listOfSongs;

    public Album(String name) {
        this.name = name;
        listOfSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getListOfSongs() {
        return listOfSongs;
    }

    // add song in order they are added
    public boolean addSong(Song song){

        if (song != null) {
            //check if the song already exist in album
            if (existSong(song)) {
                return false;
            }
            listOfSongs.add(song);
            return true;
        }
        return false;
    }

    //a song must exist on the album before it can be added to the playlist.
    public boolean existSong(Song song) {
        ListIterator<Song> listIterator = listOfSongs.listIterator();

        while (listIterator.hasNext()){
             int compare = listIterator.next().getTitle().compareToIgnoreCase(song.getTitle());
             if (compare == 0) {
                 return true;
             }
        }
        return false;
    }


}
