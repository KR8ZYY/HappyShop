package ci553.happyshop.client;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;


public class BackgroundMusicFileLocationTest {

    @Test
    public void testMusicFileLocation() {
        //finds the path where chosen file is supposed to exist
        Path path = Paths.get("AERØHEAD - Fragments.mp3");

        //test part 1 checks if the background music file exists
        assertTrue(Files.exists(path), "The music file should exist in main Happyshop folder");
        System.out.println("Test part 1 has passed successfully");

        //test part 2 checks if it's an actual file and nothing else
        assertTrue(Files.isRegularFile(path), "The path should point to a file and no directory or packages etc");
        System.out.println("Test part 2 has passed successfully");
    }
}