package quiz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class ClassRoomFrame extends JFrame implements ActionListener {
  List<String> participants;
  List<String> topics;
  static Random random = new Random();
  JLabel lparticipant = new JLabel("Sujit Kumar Chakrabarti");
  JLabel ltopic = new JLabel("Software Engineering");
  JButton btnnext = new JButton("Next");
  public ClassRoomFrame(List<String> participants, List<String> topics) {
    this.participants = participants;
    this.topics = topics;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(20 * this.getLongestStringLength(), 250);
    this.setTitle("Antyakhs-Query");
    JPanel labelPanel = new JPanel();
    

    this.btnnext.addActionListener(this);

    this.lparticipant.setForeground(new Color(255, 0, 0));
    this.lparticipant.setFont(new Font("SansSerif", Font.BOLD, 40));
    this.lparticipant.setAlignmentX(CENTER_ALIGNMENT);
    this.lparticipant.setBorder(BorderFactory.createLineBorder(Color.black));

    this.ltopic.setForeground(Color.BLUE);
    this.ltopic.setFont(new Font("SansSerif", Font.BOLD, 40));
    this.ltopic.setAlignmentX(CENTER_ALIGNMENT);
    this.ltopic.setBorder(BorderFactory.createLineBorder(Color.black));


    labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
    labelPanel.add(Box.createRigidArea(new Dimension(0,5)));
    labelPanel.add(this.lparticipant);
    labelPanel.add(this.ltopic);
    labelPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    this.getContentPane().add(BorderLayout.CENTER, labelPanel);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
    buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonPanel.add(Box.createHorizontalGlue());
    buttonPanel.add(this.btnnext);
    buttonPanel.add(Box.createHorizontalGlue());
    this.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
  }
  
  private int getLongestStringLength() {
    int max = 0;
    for(String name : this.participants) {
      if(name.length() > max) {
        max = name.length();
      }
    }
    return max;
  }

  private static String chooseNext(List<String> list) {
      int index = Math.abs(ClassRoomFrame.random.nextInt() % list.size());
      return list.get(index);
  }

  private String nextParticipant() {
      return ClassRoomFrame.chooseNext(this.participants);
  }

  private String nextTopic() {
      return ClassRoomFrame.chooseNext(this.topics);
  }

  public void actionPerformed(ActionEvent e) {
    if(this.btnnext.equals(e.getSource())) {
      if(this.topics.isEmpty()) {
        System.out.println("All topics done!");
        System.exit(0);
      }
      String participant = "";
      this.lparticipant.setText(this.nextParticipant());

      String topic = this.nextTopic();
      this.ltopic.setText(topic);
      this.topics.remove(topic);
    }
  }
}
