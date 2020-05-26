package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Program {
  private static ClassRoomFrame frame;
  public static void main(String[] args) {
    File pfile = new File("../class.txt");
    File tfile = new File("../topics.txt");
    if(args.length != 0 && args[0].equals("-i")) {
      JFileChooser pchooser = new JFileChooser("..");
      int pretval = pchooser.showOpenDialog(Program.frame);
      if(pretval == JFileChooser.APPROVE_OPTION) {
        System.out.println("Chosen participants file = " + pfile);
        pfile = pchooser.getSelectedFile().getAbsoluteFile();
      }
      JFileChooser tchooser = new JFileChooser("..");
      int tretval = tchooser.showOpenDialog(Program.frame);
      if(tretval == JFileChooser.APPROVE_OPTION) {
        System.out.println("Chosen topics file = " + tfile);
        tfile = tchooser.getSelectedFile().getAbsoluteFile();
      }
    }
    else {
      System.out.println("Choosing default file ../class.txt for participants ...");
      System.out.println("Choosing default file ../topics.txt for topics ...");
    } 
    List<String> participants =  Program.getNamesFromFile(pfile);
    if(participants.equals(null)) {
      System.out.println("Empty participant list!");
      System.exit(0);
    }
    List<String> topics = Program.getNamesFromFile(tfile);
    if(topics.equals(null)) {
      System.out.println("Empty topics list!");
      System.exit(0);
    }
    Program.frame = new ClassRoomFrame(participants, topics);
    Program.frame.setVisible(true);
  }
  
  private static  List<String> getNamesFromFile(File file) {
   
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "File not Found.");
      return null;
    }
    try {
      List<String> participants = new ArrayList<String>();
      String line = null;
      while((line = reader.readLine()) != null) {
        participants.add(line);
      }
      reader.close();
      return participants;
    } catch (IOException e) {
      return null;
    }
  }
}
