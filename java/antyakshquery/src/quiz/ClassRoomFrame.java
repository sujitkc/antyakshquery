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
	/**
	 * 
	 */
	private static final long serialVersionUID = -8576258744602858081L;
	List<String> mNames;
	Random mRandom = new Random();
	JLabel mNameLabel1 = new JLabel("Sujit Kumar Chakrabarti");
	JButton mNextButton = new JButton("Next");
	public ClassRoomFrame(List<String> names) {
		this.mNames = names;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(20 * this.getLongestStringLength(), 150);
		this.setTitle("Antyakhs-Query");
		JPanel labelPanel = new JPanel();
		

		this.mNextButton.addActionListener(this);

		this.mNameLabel1.setForeground(new Color(255, 0, 0));
		this.mNameLabel1.setFont(new Font("SansSerif", Font.BOLD, 40));
		this.mNameLabel1.setAlignmentX(CENTER_ALIGNMENT);
		this.mNameLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		labelPanel.add(Box.createRigidArea(new Dimension(0,5)));
		labelPanel.add(this.mNameLabel1);
		labelPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		this.getContentPane().add(BorderLayout.CENTER, labelPanel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(this.mNextButton);
		buttonPanel.add(Box.createHorizontalGlue());
		this.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}
	
	private int getLongestStringLength() {
		int max = 0;
		for(String name : this.mNames) {
			if(name.length() > max) {
				max = name.length();
			}
		}
		return max;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.mNextButton.equals(e.getSource())) {
			String name1 = "";
//			String name2 = "";
//			while(name1.equals(name2)) {
			int index = Math.abs(this.mRandom.nextInt() % this.mNames.size());
			name1 = this.mNames.get(index);
//				index = Math.abs(this.mRandom.nextInt() % this.mNames.size());
//				name2 = this.mNames.get(index);
//			}
			this.mNameLabel1.setText(name1);
//			this.mNameLabel2.setText(name2);
		}

	}
}
