import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SongStudentTest {

    private Song song;

    @Before
    public void setUp() {
        song = new Song("Nobody", "Mitski");
    }

    @Test
    public void testGetSongName() {
        assertEquals("Nobody", song.getSongName());
    }

    @Test
    public void testGetArtist() {
        assertEquals("Mitski", song.getArtist());
    }

    @Test
    public void testToString() {
        assertEquals("Nobody - Mitski", song.toString());
    }
}