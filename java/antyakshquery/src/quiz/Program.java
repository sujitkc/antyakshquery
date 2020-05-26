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
		List<String> names = new ArrayList<String>();
		String[] n = {
				"Arjun S Bharadwaj",
				"Varun Singh",
				"Saumya Tayal",
				"Ajay Tiwari",
				"S Anvith",
				"Bakori Niravkumar Govindbhai",
				"Heena Sharma",
				"Koduru Sindhuja",
				"Chillal Kashinath Basanna",
				"Soumit Das",
				"Joydeep",
				"N. L. Prathyusha",
				"Surabhi Taluja",
				"Ankit Narang",
				"Duggineni V Krishna Chaitanya",
				"Satya Prakash",
				"Nallu Naveen",
				"Ananth",
				"Paras Mittal",
				"Sanganabasav S Kollur ",
				"Anusha Modwal",
				"Sanju Haragapure",
				"Shah Nikita Rajan",
				"Prashant Ruwali",
				"Pavithra",
				"Abhijit Bagchi",
				"Deepthi M",
				"Prashant Jhaba",
				"Anumula Kavya Sree",
				"Subin Thomas",
				"Abhijith",
				"Shrimant Chakrabarti",
				"Joshi Dnyanesh Madhav",
				"Shreyas N",
				"Annu Singh",
				"Divya Maharshi",
				"Pereira Hammond Alphonse",
				"Shah Ankitkumar ",
				"Nitesh",
				"Anshul Karasi",
				"Amit Tomar",
				"Ankur Ashok Rathi",
				"Uday Bhan Singh",
				"Harsha N Bhushan",
				"Sagar Sanjay Sabale",
				"Garisa Venkata Sowmya",
				"Patwari Abhijeet Bapurao",
				"Sumit Kumar Dutta",
				"Paspulati Leelaram",
				"Ruchita Jain",
				"Jain Manish Balchand",
				"P Saipriya",
				"Kirubakaran S",
				"Divya Rawat",
				"Rajat Bansal",
				"Rajaram Rahul Ramchandra",
				"Patil Vivek Madhavrao",
				"Saraiya Chirag Manoj",
				"Rakesh Rajpurohit",
				"Pankaj Kumar Agrawal",
				"Dipesh Joshi",
				"Siddhesh Dosi",
				"Venu Gopal Peddi",
				"Bhuvanesh Kumar Srivastava",
				"Ankesh Kumar Sengar",
				"Harsha K C",
				"Kanchan",
				"Chavvakula Rose Rani",
				"Kunal Yadav",
				"Khamar Bhargav Harishkumar",
				"Pillalamarri B V Ramana",
				"Tuli Kundu",
				"Apoorwa Mishra",
				"Naveen Pai",
				"Devesh Singh Rawat",
				"Priyanka Shukla",
				"Monika Sharma",
				"Dawalatabad Mohd Nauman Abdul Razzak",
				"Nandyala Ravi Kishore",
				"Sutirtha Bhaumik",
				"Gopal Shukla",
				"Ankita Sharma",
				"Ashutosh Trivedi",
				"Abhishek Bhol",
				"Koppisetti Rakesh Kumar",
				"Piyush Kaushik",
				"Prasun P",
				"Kaushik Ranjan",
				"Neetika Panwar",
				"Pawan Kumar Rajpoot",
				"Ashish Garg",
				"Balmukund Agrawal",
				"Parush Agarwal",
				"Bhardwaj Ramkumar",
				"Charan Shetty",
				"Kanduluru Kishore",
				"Nisha Basia",
				"Ashutosh Vyas",
				"Komal Gupta",
				"Gollahalli Venkata Sai Krishna",
				"Shivam Upadhyay",
				"Prakash Vijay Kharche",
				"Ankur Kumar",
				"Zadbuke Apurva Jagdish",
				"Prashant Prabhakar Nagansure",
				"Mohnish Bhatt",
				"Nikhil Agrawal",
				"Amrutha M",
				"Rahul R",
				"Allu Pramod Reddy",
				"Lahankar Pushkaraj Jayant",
				"Ashish Kumar Gupta",
				"Shefali Singla",
				"Muhammed Hunaif P",
				"Midthur Ayesha Siddiqa",
				"Michael Peter",
				"Nikita ",
				"Brij Mohan",
				"Robin Sharma",
				"Sandipan Saha",
				"Yash Thadani",
				"Shubham Karodiya",
				"Srinivas R Vaidya",
				"Patil Sanjivani Rajiv",
				"Chavan Laxmikant Abasaheb",
				"Mitta Hari Krishna",
				"Natti Bhuvana Sai",
				"Priyamvadha",
				"Venkatesh Vishwarup",
				"Kumudini Kakwani",
				"Sadariya Ankit Pravinbhai",
				"Thangella Venkat Reddy",
				"Parul Gupta",
				"C Sai Bhaskar Krishna",
				"Mitesh Gupta",
				"Allada Dhanunjaya Prasad",
				"Ankesh Sharma",
				"Vishesh Jain",
				"Anupam Azad",
				"Shivam Agarwal",
				"Mayur Patidar",
				"R Prashanthkumar Reddy",
				"Ankit Sharma",
				"Ankit Gumber",
				"Sunkari Raja Shekhar Reddy",
				"Sumit Singh Chauhan",
				"Gaurav Chugh"
		};
		List<String> namesFromFile = Program.getNamesFromFile();
		if(namesFromFile.equals(null)) {
			for(String name : n) {
				names.add(name);
			}			
		}
		else {
			names = namesFromFile;
		}
		Program.frame = new ClassRoomFrame(names);
		Program.frame.setVisible(true);
	}
	
	private static  List<String> getNamesFromFile() {
		File file = new File("data/attendance.csv");
		JFileChooser chooser = new JFileChooser(".");
		int retval = chooser.showOpenDialog(Program.frame);
		if(retval == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile().getAbsoluteFile();
		}
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not Found.");
			return null;
		}
		try {
			List<String> names = new ArrayList<String>();
			String line = null;
			while((line = reader.readLine()) != null) {
				names.add(line);
			}
			reader.close();
			return names;
		} catch (IOException e) {
			return null;
		}
	}
}