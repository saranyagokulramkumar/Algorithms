import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodeAndDecodeString_LC271_test {

    static EncodeAndDecodeString_LC271 codec;
    @BeforeAll
    public static void init(){
        codec = new EncodeAndDecodeString_LC271();
    }
    @Test
    public void testEncode(){

        List<String> input = Arrays.asList("hello", "world", "leetcode", "encoding");
        String encoded = codec.encode(input);
        assertEquals("5/:hello5/:world8/:leetcode8/:encoding", encoded);

        input = Arrays.asList("");
        encoded = codec.encode(input);
        assertEquals("0/:", encoded);

        // Test with special characters
        input = Arrays.asList("test!@#", "special_chars_123", "delimit/:er");
        encoded = codec.encode(input);
        assertEquals("7/:test!@#17/:special_chars_12311/:delimit/:er", encoded);
    }

    @Test
    public void testDecode(){
        // Test normal encoded string
        String encoded = "5/:hello5/:world8/:leetcode8/:encoding";
        List<String> expected = Arrays.asList("hello", "world", "leetcode", "encoding");
        List<String> decoded = codec.decode(encoded);
        assertEquals(expected, decoded);

        // Test with empty string
        encoded = "0/:";
        expected = Arrays.asList("");
        decoded = codec.decode(encoded);
        assertEquals(expected, decoded);

        // Test with special characters
        encoded = "7/:test!@#17/:special_chars_12311/:delimit/:er";
        expected = Arrays.asList("test!@#", "special_chars_123", "delimit/:er");
        decoded = codec.decode(encoded);
        assertEquals(expected, decoded);
    }

    @Test
    public void testRoundTrip() {
        // Test normal list of strings
        List<String> input = Arrays.asList("hello", "world", "leetcode", "encoding");
        String encoded = codec.encode(input);
        List<String> decoded = codec.decode(encoded);
        assertEquals(input, decoded);

        // Test with empty string
        input = Arrays.asList("");
        encoded = codec.encode(input);
        decoded = codec.decode(encoded);
        assertEquals(input, decoded);

        // Test with special characters
        input = Arrays.asList("test!@#", "special_chars_123");
        encoded = codec.encode(input);
        decoded = codec.decode(encoded);
        assertEquals(input, decoded);

        // Test with empty list
        input = new ArrayList<>();
        encoded = codec.encode(input);
        decoded = codec.decode(encoded);
        assertEquals(input, decoded);
    }
}
