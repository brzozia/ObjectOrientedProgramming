package test;

import main.OptionParser;
import main.MoveDirection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTests {

    @Test
    void parseTest() {
        MoveDirection parsed[]={MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD};
        String toParse[] = {"f", "r", "left", "f", "l", "forward", "right", "b"};

        assertArrayEquals(OptionParser.parse(toParse), parsed);
    }
}
