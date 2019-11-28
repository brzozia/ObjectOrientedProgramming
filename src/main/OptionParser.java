package main;

public class OptionParser {

    public static MoveDirection[] parse(String[] shortDir)  {
        MoveDirection[] longDir = new MoveDirection[shortDir.length];

           for (int i = 0; i < shortDir.length; i++) {
               switch (shortDir[i]) {
                   case "f":
                   case "forward":
                       longDir[i] = MoveDirection.FORWARD;
                       break;
                   case "b":
                   case "backward":
                       longDir[i] = MoveDirection.BACKWARD;
                       break;
                   case "l":
                   case "left":
                       longDir[i] = MoveDirection.LEFT;
                       break;
                   case "r":
                   case "right":
                       longDir[i] = MoveDirection.RIGHT;
                       break;
                   default:
                       throw new IllegalArgumentException(shortDir[i] + " is not legal move specification");
               }
           }
        return longDir;
    }
}
