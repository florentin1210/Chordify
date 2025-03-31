package classes;
import java.lang.String;
public class ChordProgression {
    public String[] progression = new String[7];
    public void setMaj(int noteVal){
        Chord I = new Chord();
        progression[0] = I.toStringSetMaj(noteVal);
        Chord II = new Chord();
        progression[1] = II.toStringSetMin(noteVal +2);
        Chord III = new Chord();
        progression[2] = III.toStringSetMin(noteVal +4);
        Chord IV = new Chord();
        progression[3] = IV.toStringSetMaj(noteVal +5);
        Chord V = new Chord();
        progression[4] = V.toStringSetMaj(noteVal +7);
        Chord VI = new Chord();
        progression[5] = VI.toStringSetMin(noteVal +9);
        Chord VII = new Chord();
        progression[6] = VII.toStringSetDim(noteVal +11);
    }
    public void setMin(int noteVal){
        Chord I = new Chord();
        progression[0] = I.toStringSetMaj(noteVal);
        Chord II = new Chord();
        progression[1] = II.toStringSetMin(noteVal +2);
        Chord III = new Chord();
        progression[2] = III.toStringSetMin(noteVal +3);
        Chord IV = new Chord();
        progression[3] = IV.toStringSetMaj(noteVal +5);
        Chord V = new Chord();
        progression[4] = V.toStringSetMaj(noteVal +7);
        Chord VI = new Chord();
        progression[5] = VI.toStringSetMin(noteVal +8);
        Chord VII = new Chord();
        progression[6] = VII.toStringSetDim(noteVal +10 );
    }
}
