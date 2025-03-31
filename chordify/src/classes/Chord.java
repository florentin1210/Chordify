package classes;
import main.Main;
import java.lang.String;
public class Chord {
    public String[] chord = new String[3];
    public void setMaj(int valnota){
        chord[0] = Main.notes[valnota];
        chord[1] = Main.notes[valnota + 4];
        chord[2] = Main.notes[valnota + 7];
    }
    public String toStringSetMaj(int valnota){
        chord[0] = Main.notes[valnota];
        chord[1] = Main.notes[valnota + 4];
        chord[2] = Main.notes[valnota + 7];
        return chord[0] + chord[1] + chord[2];
    }
    public void setMin(int valnota){
        chord[0] = Main.notes[valnota];
        chord[1] = Main.notes[valnota + 3];
        chord[2] = Main.notes[valnota + 7];
    }
    public String toStringSetMin(int valnota){
        chord[0] = Main.notes[valnota];
        chord[1] = Main.notes[valnota + 3];
        chord[2] = Main.notes[valnota + 7];
        return chord[0] + chord[1] + chord[2];

    }
    public void setDim(int valnota){
        chord[0] = Main.notes[valnota];
        chord[1] = Main.notes[valnota + 3];
        chord[2] = Main.notes[valnota + 6];
    }
    public String toStringSetDim(int valnota){
        chord[0] = Main.notes[valnota];
        chord[1] = Main.notes[valnota + 3];
        chord[2] = Main.notes[valnota + 6];
        return chord[0] + chord[1] + chord[2];
    }
    public String toString(){
        return chord[0] + chord[1] + chord[2];
    }
}
