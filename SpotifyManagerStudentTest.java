import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

public class SpotifyManagerStudentTest {

    private SpotifyManager manager;
    private File tempFile;
    private String testData;

    @Before
    public void setUp() throws IOException {
        manager = new SpotifyManager();

        testData =
            "# USER\n" +
            "username: mitski\n" +
            "password: bb\n" +
            "playlist: Be The Cowboy\n" +
            "song: Nobody - Mitski\n" +
            "song: Geyser - Mitski\n" +
            "# USER\n" +
            "username: fan\n" +
            "password: 1234\n" +
            "playlist: Puberty 2\n" +
            "song: Your Best American Girl - Mitski\n" +
            "song: Happy - Mitski\n";

        tempFile = File.createTempFile("student_test_users", ".txt");
        PrintWriter writer = new PrintWriter(tempFile);
        writer.print(testData.replace("\n", System.lineSeparator()));
        writer.close();
    }

    @Test
    public void testLoadUsersFromFile() throws Exception {
        manager.loadUsersFromFile(tempFile.getAbsolutePath());

        User mitski = manager.findUser("mitski", "bb");
        assertNotNull(mitski);
        assertEquals("bb", mitski.getPass());

        User fan = manager.findUser("fan", "1234");
        assertNotNull(fan);
        assertEquals("1234", fan.getPass());
    }
}