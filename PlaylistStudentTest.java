import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlaylistStudentTest {

    private Playlist playlist;

    @Before
    public void setUp() {
        playlist = new Playlist("My Playlist");
        playlist.addSong(new Song("Song A", "Artist 1"));
        playlist.addSong(new Song("Song B", "Artist 2"));
        playlist.addSong(new Song("Song C", "Artist 3"));
    }

    @Test
    public void testGetName() {
        assertEquals("My Playlist", playlist.getName());
    }

    @Test
    public void testGetSize() {
        assertEquals(3, playlist.getSize());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(playlist.isEmpty());
        Playlist empty = new Playlist("Empty");
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testAddSong() {
        playlist.addSong(new Song("Song D", "Artist 4"));
        assertEquals(4, playlist.getSize());
    }

    @Test
    public void testRemoveSong() {
        Song song = new Song("Song A", "Artist 1");
        assertTrue(playlist.removeSong(song));
        assertEquals(2, playlist.getSize());
    }

    @Test
    public void testNextSong() {
        assertEquals("Song A", playlist.nextSong().getSongName());
        assertEquals("Song B", playlist.nextSong().getSongName());
    }

    @Test
    public void testGetCurrentSong() {
        playlist.nextSong();
        assertEquals("Song A", playlist.getCurrentSong().getSongName());
    }
}