package classes;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class playsound {

    public static void playSound(int noteVal) {
        String filePaths[] = {"A.aiff", "A#.aiff","B.aiff","C.aiff","C#.aiff","D.aiff","D#.aiff","E.aiff","F.aiff","F#.aiff","G.aiff","G#.aiff"};
        String filePath = "D:\\OOP\\chordify\\src\\sounds\\" + filePaths[noteVal];
        File audioFile = new File(filePath);

        if (!audioFile.exists()) {
            System.out.println("Fișierul audio nu a fost găsit!");
            return;
        }

        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(audioFile);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
        Clip clip = null;

        try {
            clip = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        try {
            clip.open(ais);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Se începe redarea sunetului...");
        clip.start();
        System.out.println("Sunetul a fost redat.");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        clip.close();
    }
}