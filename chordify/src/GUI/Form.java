package GUI;

import main.*;
import classes.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class Form {
    boolean majBool, minBool,dimBool, scaleBool, chordBool, chProgressionBool;
    public int noteVal;
    private String noteString;
    Scale scale = new Scale();
    Chord chord = new Chord();
    ChordProgression chProgression = new ChordProgression();
    public Form() {
        majBool = false; minBool = false; dimBool = false; scaleBool = false; chordBool = false; chProgressionBool = false;

        JFrame main = new JFrame("Guitar Helper");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1600,900);
        main.setLayout(new GridLayout(1,2));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4,1));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel row1 = new JPanel();
        row1.setLayout(new GridLayout(1,2));
        JLabel noteText = new JLabel("Enter a note: ",SwingConstants.CENTER);
        noteText.setBorder(new LineBorder(Color.black));
        noteText.setFont(new Font("Arial", Font.PLAIN, 50));
        JTextField noteTextField = new JTextField();
        noteTextField.setBorder(new LineBorder(Color.black));
        noteTextField.setFont(new Font("Arial", Font.PLAIN, 50));
        row1.add(noteText);
        row1.add(noteTextField);
        leftPanel.add(row1);

        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton majButton = new JButton("Major");
        majButton.setBackground(Color.white);
        majButton.setPreferredSize(new Dimension(386,200));
        JButton minButton = new JButton("Minor");
        minButton.setBackground(Color.white);
        minButton.setPreferredSize(new Dimension(386,200));
        row2.add(majButton);
        row2.add(minButton);
        leftPanel.add(row2);

        JPanel row3 = new JPanel();
        row3.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton scaleButton = new JButton("Scale");
        scaleButton.setBackground(Color.white);
        JButton chordButton = new JButton("Chord");
        chordButton.setBackground(Color.white);
        JButton progressionButton = new JButton("Chord progression");
        progressionButton.setBackground(Color.white);
        row3.add(scaleButton);
        row3.add(chordButton);
        row3.add(progressionButton);
        leftPanel.add(row3);

        JPanel row4 = new JPanel();
        row4.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton goButton = new JButton("Go!");
        row4.add(goButton);
        leftPanel.add(row4);



        main.add(leftPanel);
        String columnData[] = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","23","24"};

        String data[][] = {{"E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E"},
                {"B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B"},
                {"G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G"},
                {"D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D"},
                {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A"},
                {"E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E"}};

        JTable fretboard = new JTable(data, columnData);
        fretboard.setRowHeight(40);
        for (int i = 0; i < 24; i++) {
            TableColumn column = fretboard.getColumnModel().getColumn(i);
            column.setPreferredWidth(80);
        }

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rightPanel.setLayout(new CardLayout());
        JScrollPane scrollPane = new JScrollPane(rightPanel);
        main.add(rightPanel);

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightPanel.removeAll();
                noteString = noteTextField.getText();
                boolean noteNegasit = false;
                for (int i = 0; i <= 12; i++) {
                    if (noteString.equals(Main.notes[i])) {
                        noteNegasit = false;
                        noteVal = i;
                        break;
                    }
                    else noteNegasit = true;
                }
                if(noteNegasit) JOptionPane.showMessageDialog(main,"Error: invalid note!");

                ActionListener soundButton = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        JButton source = (JButton) e.getSource();
                        for (int i = 0; i<=12; i++) {
                            if(Main.notes[i].equals(source.getText())){
                                System.out.println("Se redă sunetul pentru i = " + i);
                                playsound.playSound(i);
                            }
                        }
                    }
                };

                if(scaleBool && !chordBool && !chProgressionBool){
                    if((majBool) && (minBool)) {
                        JOptionPane.showMessageDialog(main, "Error: both major and minor selected!");
                    }
                    else if(!majBool && !minBool) {
                        JOptionPane.showMessageDialog(main, "Error: neither major nor minor selected!");
                    }
                    else{
                        JPanel scalePanel = new JPanel();
                        scalePanel.setLayout(new GridLayout(2,1));
                        if(majBool) scale.setMaj(noteVal);
                        else scale.setMin(noteVal);
                        JPanel scaleNotes = new JPanel();
                        scalePanel.add(scaleNotes);
                        scaleNotes.setLayout(new GridLayout(1,8));
                        JLabel scalenotesText = new JLabel("Notes: ");
                        scaleNotes.add(scalenotesText);
                        JButton tonic = new JButton(scale.scale[0]);
                        tonic.addActionListener(soundButton);
                        scaleNotes.add(tonic);
                        JButton second = new JButton(scale.scale[1]);
                        second.addActionListener(soundButton);
                        scaleNotes.add(second);
                        JButton third = new JButton(scale.scale[2]);
                        third.addActionListener(soundButton);
                        scaleNotes.add(third);
                        JButton fourth = new JButton(scale.scale[3]);
                        fourth.addActionListener(soundButton);
                        scaleNotes.add(fourth);
                        JButton fifth = new JButton(scale.scale[4]);
                        fifth.addActionListener(soundButton);
                        scaleNotes.add(fifth);
                        JButton sixth = new JButton(scale.scale[5]);
                        sixth.addActionListener(soundButton);
                        scaleNotes.add(sixth);
                        JButton seventh = new JButton(scale.scale[6]);
                        seventh.addActionListener(soundButton);
                        scaleNotes.add(seventh);
                        rightPanel.add(scalePanel);

                        scalePanel.removeAll();
                        scalePanel.add(scaleNotes);
                        scalePanel.add(fretboard);
                        fretboard.setDefaultRenderer(Object.class, new CustomCellRenderer(scale.scale));

                        rightPanel.removeAll();
                        rightPanel.add(scalePanel);
                        ((CardLayout) rightPanel.getLayout()).show(rightPanel, "scalePanel");

                        main.revalidate();
                        main.repaint();
                    }
                }
                if(chordBool && !scaleBool && !chProgressionBool){
                    if((majBool) && (minBool)) {
                        JOptionPane.showMessageDialog(main, "Error: both major and minor selected!");
                    }
                    else if(!majBool && !minBool) {
                        JOptionPane.showMessageDialog(main, "Error: neither major nor minor selected!");
                    }
                    else {
                        JPanel chordPanel = new JPanel();
                        chordPanel.setLayout(new GridLayout(2,1));
                        JPanel chordNotes = new JPanel();
                        chordPanel.add(chordNotes);
                        chordNotes.setLayout(new GridLayout(1,5));
                        JLabel chnotesText = new JLabel("Notes: ");
                        chordNotes.add(chnotesText);

                        if(majBool) chord.setMaj(noteVal);
                        else chord.setMin(noteVal);

                        JButton tonic = new JButton(scale.scale[0]);
                        tonic.addActionListener(soundButton);
                        chordNotes.add(tonic);
                        JButton third = new JButton(scale.scale[2]);
                        third.addActionListener(soundButton);
                        chordNotes.add(third);
                        JButton fifth = new JButton(scale.scale[4]);
                        fifth.addActionListener(soundButton);
                        chordNotes.add(fifth);
                        rightPanel.add(chordPanel);

                        chordPanel.removeAll();
                        chordPanel.add(chordNotes);
                        chordPanel.add(fretboard);
                        fretboard.setDefaultRenderer(Object.class, new CustomCellRenderer(chord.chord));

                        rightPanel.removeAll();
                        rightPanel.add(chordPanel);
                        ((CardLayout) rightPanel.getLayout()).show(rightPanel, "chordPanel");

                        main.revalidate();
                        main.repaint();
                    }
                }
                if(chProgressionBool && !scaleBool && !chordBool){
                    if((majBool) && (minBool)) {
                        JOptionPane.showMessageDialog(main, "Error: both major and minor selected!");
                    }
                    else if(!majBool && !minBool) {
                        JOptionPane.showMessageDialog(main, "Error: neither major nor minor selected!");
                    }
                    else {
                        JPanel chProgressionPanel = new JPanel();
                        chProgressionPanel.setLayout(new GridLayout(14,1));

                        if(majBool == true) chProgression.setMaj(noteVal);
                        else chProgression.setMin(noteVal);

                        JLabel I = new JLabel(chProgression.progression[0]);
                        JLabel II = new JLabel(chProgression.progression[1]);
                        JLabel III = new JLabel(chProgression.progression[2]);
                        JLabel IV = new JLabel(chProgression.progression[3]);
                        JLabel V = new JLabel(chProgression.progression[4]);
                        JLabel VI = new JLabel(chProgression.progression[5]);
                        JLabel VII = new JLabel(chProgression.progression[6]);
                        chProgressionPanel.add(I);
                        chProgressionPanel.add(II);
                        chProgressionPanel.add(III);
                        chProgressionPanel.add(IV);
                        chProgressionPanel.add(V);
                        chProgressionPanel.add(VI);
                        chProgressionPanel.add(VII);
                        rightPanel.add(chProgressionPanel);

                        chProgressionPanel.removeAll();

                        rightPanel.removeAll();
                        rightPanel.add(chProgressionPanel);
                        ((CardLayout) rightPanel.getLayout()).show(rightPanel, "chProgressionPanel");

                        main.revalidate();
                        main.repaint();
                    }
                }
            }
        });

        majButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(majButton.getBackground() == Color.white) majButton.setBackground(Color.gray);
                else majButton.setBackground(Color.white);
                if(!majBool) majBool = true;
                else majBool = false;
            }
        });

        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(minButton.getBackground() == Color.white) minButton.setBackground(Color.gray);
                else minButton.setBackground(Color.white);
                if(!minBool) minBool = true;
                else minBool = false;
            }
        });

        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(scaleButton.getBackground() == Color.white) scaleButton.setBackground(Color.gray);
                else scaleButton.setBackground(Color.white);
                if(!scaleBool) scaleBool = true;
                else scaleBool = false;
            }
        });
        chordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chordButton.getBackground() == Color.white) chordButton.setBackground(Color.gray);
                else chordButton.setBackground(Color.white);
                if(!chordBool) chordBool = true;
                else chordBool = false;
            }
        });
        progressionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(progressionButton.getBackground() == Color.white) progressionButton.setBackground(Color.gray);
                else progressionButton.setBackground(Color.white);
                if(!chProgressionBool) chProgressionBool = true;
                else chProgressionBool = false;
            }
        });

        main.setVisible(true);
    }
}
