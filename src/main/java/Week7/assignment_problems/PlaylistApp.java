package main.java.Week7.assignment_problems;

import java.util.Arrays;

public class PlaylistApp {

    static class Playlist {
        private final String[] songs;
        private int count;

        Playlist(int capacity) {
            this.songs = new String[capacity];
        }

        void addSong(String title) {
            if (count < songs.length) {
                songs[count++] = title;
            }
        }

        String[] getSongs() {
            return Arrays.copyOf(songs, count);
        }

        int getSongCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Copy: " + Arrays.toString(copy));
        System.out.println("Playlist: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
