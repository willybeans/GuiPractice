//source: http://www.dreamincode.net/forums/topic/17705-basic-gui-concepts/

package guipractice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiPractice extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    
    private JLabel lengthL, widthL, areaL, perimeterL;
    private JTextField lengthTF, widthTF, areaTF, perimeterTF;
    private JButton calculateB, exitB;
           
    //Button handlers:
    private CalculateButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;
    
    public GuiPractice() 
    {
        //Instantiate the labels:
        lengthL = new JLabel("Enter the length: ", SwingConstants.RIGHT);
        widthL = new JLabel("enter the width: ", SwingConstants.RIGHT);
        areaL = new JLabel("Area: ", SwingConstants.RIGHT);
        perimeterL = new JLabel("Perimeter: ", SwingConstants.RIGHT);
        
        //Text fields next:
        lengthTF = new JTextField(10);
        widthTF = new JTextField(10);
        areaTF = new JTextField(10);
        perimeterTF = new JTextField(10);
        
        //Specify handlers for each button and add(register) action
        //listeners to each button
        
        //Buttons too:
        calculateB = new JButton("Calculate");
        cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);
        exitB = new JButton("Exit");
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
        
        //set the window's title:
        setTitle("Sample Title");
        //get the content pame (CP)
        Container pane = getContentPane();
        //set the layout
        pane.setLayout(new GridLayout(5,2));
        
        //add things to the pane in order you want them to appear
        //Other jframe stuff
        pane.add(lengthL);
        pane.add(lengthTF);
        pane.add(widthL);
        pane.add(widthTF);
        pane.add(areaL);
        pane.add(areaTF);
        pane.add(calculateB);
        pane.add(exitB);
        
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class CalculateButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double width, length, area;
            length = Double.parseDouble(lengthTF.getText());//we use the get text&
            //set text to manipulate the data in those fields
            width = Double.parseDouble(widthTF.getText());
            area = length * width;
            
            areaTF.setText("" + area);
        }
        }
    public class ExitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        GuiPractice GuiPrac = new GuiPractice();
    }
    
}
