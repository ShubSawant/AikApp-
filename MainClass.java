
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.charset.Charset;
import static javax.swing.JOptionPane.showMessageDialog;

 class SplashScreenDemo {

  String lastfilenamerefernce;
   private JTextField textfield;
   private JLabel options;
   private JTextField textfield1;
   private JTextField textfield2;
   private JTextField textfield3;
   private JTextField textfield4;
   private JTextField textfield5;
   private JLabel statusLabel;
   private JPanel controlPanel;
   final JTextField tf=new JTextField();  
   final JLabel label=new JLabel();

   JFrame f;
   
    JFrame frame;//Creating object of JFrame
    JLabel image=new JLabel(new ImageIcon("C:/Users/2020b/Desktop/study/Java/1a.jpeg"));
     JLabel text=new JLabel("Walchand college of Engineering,Sangli");//Creating object of JLabel and adding image using the ImageIcon class
      JProgressBar progressBar=new JProgressBar();
      JLabel message=new JLabel();

    SplashScreenDemo()//Creating constructor of the class
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
       // prepareGUIforfile();
     
    }

    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);//setting layout to null
        frame.setUndecorated(true);//Turning off Title bar
        frame.setSize(1000,500);//Setting size
        frame.setLocationRelativeTo(null);//Setting location to the center of screen
        frame.getContentPane().setBackground(Color.black);//setting background color
        frame.setVisible(true);//setting visibility
 
    }

    public void addImage(){
        image.setSize(1000,500);//Setting size of the image
        frame.add(image);//Adding image to the frame
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));//Setting font size of text
        text.setBounds(190,0,600,40);//Setting size and location
        text.setForeground(Color.magenta);//Setting foreground color
        frame.add(text);//adding text to the frame
    }
     public void addProgressBar(){
        progressBar.setBounds(0,480,1000,20);//Setting Location and size
        progressBar.setBorderPainted(true);//Setting border painted property
        progressBar.setStringPainted(true);//Setting String painted property
        progressBar.setBackground(Color.BLACK);//setting background color
        progressBar.setForeground(Color.GREEN);//setting foreground color
        progressBar.setValue(0);//setting progress bar current value
        frame.add(progressBar);//adding progress bar to frame
    }
    void prepareGUIforfile()
    {
    f=new JFrame("Dialog for File input");
    tf.setBounds(140,50, 125,40); 
    label.setBounds(200,200,150,20); 
    Button b=new Button("Create file");  
    b.setBounds(160,100,80,30);  

        f.add(b);f.add(tf);  f.add(label);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true); 
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
       b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent ee){  
         String filename1= tf.getText()+".txt";

         if(tf.getText().isEmpty())
         {
                
                showMessageDialog(null, "File name cannot be empty");
				return;

         //   label.setText("File name cannot be Empty");
         
           }
		   else if(!tf.getText().equals("A")||!tf.getText().equals("B")||!tf.getText().equals("C")||!tf.getText().equals("D"))
		   {
			   JOptionPane.showMessageDialog(null,"Wrong option format","Error",JOptionPane.ERROR_MESSAGE); //icon added
				return;
		   }

            else{
          try {
      File myObj = new File(filename1);
      if (myObj.createNewFile()) {
        label.setText("File created: " + myObj.getName());
        lastfilenamerefernce=myObj.getName();
           f.dispose();
                      prepareGUI();
                      showButtonDemo(); 
      } else {
        label.setText("File already exists.");
         Button but2=new Button("Still Continue");
        but2.setBounds(200,230,90,20);
        f.add(but2);
        f.setVisible(true);
         but2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {  File myObj = new File(filename1);
            lastfilenamerefernce=myObj.getName();
            f.dispose();
             prepareGUI();
             showButtonDemo();

         }
      });

      }
    } catch (IOException e) {
      label.setText("An error occurred.");
      e.printStackTrace();
    }
}
    }  
    }); 

    }

     

      void prepareGUI(){
      frame = new JFrame("Java Aiken Application");

      frame.setSize(800,500);
      frame.setLayout(new GridLayout(0,1));
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      textfield = new JTextField();
      options=new JLabel();
  
       textfield1 = new JTextField();
  
      textfield2 = new JTextField();

       textfield3 = new JTextField();

      textfield4 = new JTextField();

       textfield5 = new JTextField();

      
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(350,100);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      frame.add(textfield);
      
    //  frame.add(options);
     frame.add(textfield1);
    
     frame.add(textfield2);
     frame.add(textfield3);
     frame.add(textfield4);
     frame.add(textfield5);

     

      frame.add(statusLabel);
      frame.add(controlPanel);
      frame.setVisible(true);
   }
    void showButtonDemo(){
   
     //JButton okButton = new JButton("Test");
      JButton reset=new JButton("Reset");
      JButton next=new JButton("Next");
      JButton finish=new JButton("Finish");
      
      reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {      
                textfield.setText("");
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                textfield4.setText("");
                textfield5.setText("");
                
                statusLabel.setText("");
                
            }
      });


            next.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
                 



                   
                 String file="C:/Users/2020b/Desktop/study/Java/"+lastfilenamerefernce;
                String question=textfield.getText();
                String optionA="A. "+textfield1.getText();
                String optionB="B. "+textfield2.getText();
                String optionC="C. "+textfield3.getText();
                String optionD="D. "+textfield4.getText();

                String answer="ANSWER: "+textfield5.getText();

                if(question.equals("") || textfield1.getText().equals("") || textfield2.getText().equals("") || textfield3.getText().equals("") || textfield4.getText().equals("") || textfield5.getText().equals(""))

                {
                       // statusLabel.setText("Data not entered correctly");
					   JOptionPane.showMessageDialog(null,"Incomplete input values provided.","Warning",JOptionPane.WARNING_MESSAGE);//Warning displayed
				       return;
                
                }
            else
            {
                
                try
                {
                        FileWriter  writer=new FileWriter(file,true);
                        writer.write("\n"+question+"\n"+optionA+"\n"+optionB+"\n"+optionC+"\n"+optionD+"\n"+answer+"\n");
                        writer.close();
                        statusLabel.setText("File written");textfield.setText("");
                        textfield1.setText("");
                        textfield2.setText("");
                        textfield3.setText("");
                        textfield4.setText("");
                        textfield5.setText("");
                        
                        

                }
                catch(Exception ee)
                {
                        statusLabel.setText("Error while creating file");
                }
            }


         }
      }); 


    /*  okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
          statusLabel.setText(textfield.getText());

         }
      });
*/
      finish.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
                
                 String file="C:/Users/2020b/Desktop/study/Java/"+lastfilenamerefernce;
                String question=textfield.getText();
                String optionA="A. "+textfield1.getText();
                String optionB="B. "+textfield2.getText();
                String optionC="C. "+textfield3.getText();
                String optionD="D. "+textfield4.getText();

                String answer="ANSWER: "+textfield5.getText();

              if(question.equals("") || textfield1.getText().equals("") || textfield2.getText().equals("") || textfield3.getText().equals("") || textfield4.getText().equals("") || textfield5.getText().equals(""))


                {
                       // statusLabel.setText("Data not entered correctly");
					   JOptionPane.showMessageDialog(null,"Incomplete input values provided.","Warning",JOptionPane.WARNING_MESSAGE);//Warning displayed
				      return;
                
                }
            else
            {
                
                try
                {
                        FileWriter  writer=new FileWriter(file,true);
                        writer.write("\n"+question+"\n"+optionA+"\n"+optionB+"\n"+optionC+"\n"+optionD+"\n"+answer+"\n");
                        writer.close();
                        statusLabel.setText("File written");textfield.setText("");
                        textfield1.setText("");
                        textfield2.setText("");
                        textfield3.setText("");
                        textfield4.setText("");
                        textfield5.setText("");
                        frame.setVisible(false);
                        

                }
                catch(Exception ee)
                {
                        statusLabel.setText("Error while creating file");
                }
            }




                /*try{
                    File file=new File("D:Aiken.txt");
                    if(file.createNewFile())
                    {
                        statusLabel.setText("File"+file.getName()+ " new file created");
                    }
                    else
                    {
                        statusLabel.setText("File already exists in directory.");
                    }
                }
                catch(IOException exception)
                {
                     statusLabel.setText("An unexpected error is occurred.");  
                              exception.printStackTrace();
                }*/
        }
      });
      //controlPanel.add(okButton);
      controlPanel.add(reset);
      controlPanel.add(next);
      controlPanel.add(finish);
      frame.setVisible(true);
   }
      public void addMessage()
    {
        message.setBounds(250,320,200,40);//Setting the size and location of the label
        message.setForeground(Color.black);//Setting foreground Color
        message.setFont(new Font("arial",Font.BOLD,15));//Setting font properties
        frame.add(message);//adding label to the frame
    }
     public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0
 
        while( i<=100)
        {
            try{
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING "+Integer.toString(i)+"%");//Setting text of the message JLabel
                i=i+3  ;
                if(i==99)
                {     frame.dispose();
                   prepareGUIforfile();

                }
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
}
    
public class MainClass
{
	public static void main(String[] args) {
		
        SplashScreenDemo swingControlDemo = new SplashScreenDemo();
     // swingControlDemo.showButtonDemo();
	}

	
}