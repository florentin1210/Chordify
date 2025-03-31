package classes;
import main.Main;
import java.lang.String;

public class Scale{
    public static String[] scale = new String[7];
    private static int M = 2;
    private static int m = 1;
    public static void setMaj(int valnote){
        scale[0] = Main.notes[valnote];
        scale[1] = Main.notes[valnote+M];
        scale[2] = Main.notes[valnote+M+M];
        scale[3] = Main.notes[valnote+M+M+m];
        scale[4] = Main.notes[valnote+M+M+m+M];
        scale[5] = Main.notes[valnote+M+M+m+M+M];
        scale[6] = Main.notes[valnote+M+M+m+M+M+M];
    }
    public static void setMin(int valnote){
        scale[0] = Main.notes[valnote];
        scale[1] = Main.notes[valnote+M];
        scale[2] = Main.notes[valnote+M+m];
        scale[3] = Main.notes[valnote+M+m+M];
        scale[4] = Main.notes[valnote+M+m+M+M];
        scale[5] = Main.notes[valnote+M+m+M+M+m];
        scale[6] = Main.notes[valnote+M+m+M+M+m+M];
    }
}
