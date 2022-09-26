package academy.learnprogramming.list.linkedList.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/* create a program that implements a playlist for songs.
 * create a song class, which has got title and duration for the song.
 * the program will have an album class containing a list of songs.
 * the actual albums will be stored in an array list.
 * Songs from different albums can be added to the playlist. playlist is actually a linked list.
 * songs that we can add will appear in the list in the order they're added.
 * Once the songs have been added to the playlist, you wanna create a menu of options, to add this functionality.
 * Quit out of the menu, skip forward to the next song, skip backwards to a previous song,
 * replay the current song, list the songs in the playlist as well.
 * Now a song must exist in an album before it can be added to the playlist.
 * the songs are stored in albums in an array list, but the playlist is the link list.
 * song exists in an album before it can be added to the playlist
 * you can only play songs that you wanted, that you've already got in your catalog.
 * Hint:  for this is to replay a song. Consider what happens when we went back and forward, or
 * what happened when we went back and forth from a city before we started tracking the direction.
 * optional extra, provide another menu option to remove the current song from the playlist.
 * hint : listIterator.remove() */
public class Main {

    public static void main(String[] args) {

        LinkedList<Song> songLinkedList = new LinkedList<>();

        Album metallica = new Album("Black Album");

        Song song1 = new Song("Enter Sandman", 5.32);
        Song song2 = new Song("Sad but True", 5.32);
        Song song3 = new Song("Holier Than Thou", 3.48);
        Song song4 = new Song("The Unforgiven", 6.27);
        Song song5 = new Song("Wherever I May Roam", 6.44);
        Song song6 = new Song("Don't Tread on Me", 4.44);
        Song song7 = new Song("Through the Never", 4.04);
        Song song8 = new Song("Some song", 3.12);

        metallica.addSong(song1);
        metallica.addSong(song2);
        metallica.addSong(song3);
        metallica.addSong(song4);
        metallica.addSong(song5);
        metallica.addSong(song6);
        metallica.addSong(song7);

        ArrayList<Song> album = metallica.getListOfSongs();
        for (Song song : album) {
            System.out.println("Song " + song.getTitle() + " duration " + song.getDuration());
        }

        addSong(songLinkedList, song1, metallica);
        addSong(songLinkedList, song2, metallica);
        addSong(songLinkedList, song3, metallica);
        addSong(songLinkedList, song4, metallica);
        addSong(songLinkedList, song5, metallica);
        addSong(songLinkedList, song8, metallica);

        playMenu(songLinkedList);


    }

    private static void playMenu(LinkedList<Song> playlist) {


        Scanner scanner = new Scanner(System.in);

        boolean quit = false;

        boolean goingForward = true;

        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("There are no songs to pe played");
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            printMenu();
        }

        while (!quit) {
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    System.out.println("Quit");
                    quit = true;
                    break;
                case 1:
                    System.out.println("Skip forward to the next song");
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("We reached the and of the playlist");
                    }
                    break;
                case 2:
                    System.out.println("Skip backwards to a previous song");
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start o the list");
                    }
                    break;
                case 3:
                    System.out.println("Replay the current song");

                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing" + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start");
                    }
                    break;
                case 4:
                    System.out.println("list the songs in the playlist");
                    printList(playlist);
                    break;
            }
        }
    }

    public static void printList(LinkedList<Song> linkedList){

        ListIterator<Song> songListIterator = linkedList.listIterator();

        while (songListIterator.hasNext()){
            System.out.println("Song " + songListIterator.next().getTitle());
        }

    }

    public static boolean addSong(LinkedList<Song> linkedList, Song song, Album album) {
        if (song == null || album == null) {
            return false;
        }
        //only if song exist in an album can be added

        if (album.existSong(song)) {
            System.out.println("Song add to playlist");
            return linkedList.add(song);
        } else {
            System.out.println("Cannot add song. Song does not belong to an album");
            return false;
        }
    }

    public static void printMenu() {
        System.out.println("Available options:\npress");
        System.out.println("0 - to quit\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - replay song\n" +
                "4 - list all songs");
    }
}
