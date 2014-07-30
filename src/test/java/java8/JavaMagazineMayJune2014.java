
package java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ondrej.mihalyi
 */
public class JavaMagazineMayJune2014 {
    
    public JavaMagazineMayJune2014() {
    }

    @Test
    public void testLengthOfLine() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("longest_line.txt"));
        int longest = reader.lines().mapToInt(String::length).max().getAsInt();
        assertEquals("Length of longest line", 8, longest);
    }

    @Test
    public void testLongestLine() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("longest_line.txt"));
        String longestLine = reader.lines().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).orElse("");
        assertEquals("Longest line", "abcdefgh", longestLine);
    }

}
