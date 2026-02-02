import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class activity1_test {

    ArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add("alpha");
        list.add("beta");
    }

    @Test
    void insertTest() {
        assertEquals(2, list.size(), "Wrong size");

        list.add("gamma");

        assertEquals(3, list.size(), "Wrong size after insert");

        assertEquals("alpha", list.get(0));
        assertEquals("beta", list.get(1));
        assertEquals("gamma", list.get(2));
    }

    @Test
    void replaceTest() {
        list.add("gamma"); 

        list.set(1, "delta");

        assertEquals(3, list.size());

        assertEquals("alpha", list.get(0));
        assertEquals("delta", list.get(1));
        assertEquals("gamma", list.get(2));
    }
}