

/*

 @ Painting Panel Version 1.00 :
     Program creared by Constantinos < tinoC23 /> Constantinou , on the 31st of December , 2015

 @ Sources : http://forum.codecall.net/topic/58137-java-mini-paint-program/

*/
 
// imported classes

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.BorderLayout;

import java.util.Random;

import java.awt.*;

import javax.swing.*;

import javax.swing.border.*;

import javax.swing.SwingUtilities;

 import java.io.IOException;
 
 import java.awt.Desktop;
 
 import java.io.File;

import java.awt.event.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;

import java.awt.Color;
  import   java.lang.Object;
     import   java.awt.geom.Point2D;
       import     java.awt.Point;
       import java.awt.Graphics;
       
       import java.awt.FlowLayout;
       import javax.swing.BoxLayout;

    import java.awt.Dimension;

import javax.swing.JSeparator;
    
import javax.swing.JOptionPane;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import java.awt.Color;

import javax.swing.JColorChooser;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

//

public class paint
{
	
	//
	
	private  static JPanel programMenu;
	
	//
	
	private static Color panelColor;
	
	//
	
	private static JMenuBar KBMenuBar;
	
	//	
	
       private static JMenu MENU;
	       private static JMenu ABOUT;
	
	     //	
	     // menu 1 
	     
	    private static  JLabel BGColor;
	     	
	    private static JLabel clearCanvas;
		
	     private static  JLabel instructions;
	
		     	private static JLabel EXIT;
	     	
	     	// menu 2 
	     	
	     		private static JLabel  programAuthor;
			
			//
	
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("Painting Panel Version 1.00 ");
		//Creates a frame with a title of "Paint it"
		
		final PadDraw drawPad = new PadDraw();
		//creates a new padDraw, which is pretty much the paint program
		
		Container content = frame.getContentPane();
		//Creates a new container
		
		content.setLayout(new BorderLayout());
		//sets the layout
		
		//
		
		  	 //paintingPanel components 
		
		      	//
		
	programMenu=new JPanel();
		
		//
		
		programMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//		
		
		programMenu.setBackground(Color.ORANGE);// set jlabel background 
		   
		   //
		   
		  programMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		   
		// Program Menu   
				
		//    Create the menu bar   
		
        KBMenuBar = new JMenuBar();
        
        // initialize the main menu 
        
        MENU = new JMenu("MENU");
		MENU.setForeground(Color.BLACK);
		MENU.setBackground(Color.WHITE);
		
	ABOUT = new JMenu("HELP");
	ABOUT.setForeground(Color.BLACK);
	ABOUT.setBackground(Color.WHITE); 
			
		 KBMenuBar.add(MENU);
		 KBMenuBar.add(ABOUT);
		 
		 //
	//Build the first menu.
		 // add main menu components
		 //
		 // add Menu JLabels
		 //
		 
		 panelColor=Color.BLACK;
		 
		BGColor=new JLabel("Change Painting Color");// set jlabel text
	   BGColor.setBackground(Color.WHITE);// set jlabel background
	   BGColor.setForeground(Color.BLACK);//set jlabel foreground
	BGColor.setEnabled(true);//set enable the jlabel
    BGColor.addMouseListener(new MouseAdapter() //the mouse listener, handles the mouse entered and mouse exited classes
	{
		
             Color oldcolor=BGColor.getForeground();
		
         public void mouseEntered(MouseEvent me) 
		{
			
		Color c=Color.CYAN;
				
          BGColor.setForeground(c.brighter());
			
         }
         public void mouseExited(MouseEvent me) 
	 {
		 
         BGColor.setForeground(oldcolor);
		 
         }
      });
	BGColor.addMouseListener(new MouseAdapter() // allows to the user to change jframe backround color, buttons backround and foreground color through a JColorChooser ...  
	{
		 public void mousePressed(MouseEvent e)
		 	{
		 	
                          drawPad.choosePaintingColor();
				
			}});  
      MENU.add(BGColor);//add to menu
	      MENU.add(new JSeparator());//add a seperator line
			
			//add clearCanvas JLabel
			
	 clearCanvas=new JLabel("Clear Painting Canvas");
	  clearCanvas.setBackground(Color.WHITE);
	   clearCanvas.setForeground(Color.BLACK);
	 clearCanvas.setEnabled(true);
    clearCanvas.addMouseListener(new MouseAdapter() 
	{
         Color oldcolor = clearCanvas.getForeground();
         public void mouseEntered(MouseEvent me) 
		{
			Color c=Color.orange;
           clearCanvas.setForeground(c);
         }
         public void mouseExited(MouseEvent me) 
	 {
          clearCanvas.setForeground(oldcolor);
         }
      }
      );
	clearCanvas.addMouseListener(new MouseAdapter() 
	{
		
		 public void mousePressed(MouseEvent e)
		 	{
		 
		drawPad.clear();
		 		
        }
		
      }
      );
	 MENU.add(clearCanvas);     
      MENU.add(new JSeparator());  //add a seperator line
			
		 //add instructions JLabel
		 
		 instructions=new JLabel("program instructions");
	  instructions.setBackground(Color.WHITE);
	   instructions.setForeground(Color.BLACK);
	 instructions.setEnabled(true);
	instructions.addMouseListener(new MouseAdapter() 
	{
         Color oldcolor =instructions.getForeground();
         public void mouseEntered(MouseEvent me) 
		{
			Color c=Color.orange;
           instructions.setForeground(c);
         }
         public void mouseExited(MouseEvent me) 
	 {
          instructions.setForeground(oldcolor);
         }
      }
      );
	instructions.addMouseListener(new MouseAdapter() 
	{
		
        public void mousePressed(MouseEvent e)
	{ 
		
		 		try {
    	
        File file = new File("instructions.pdf");
    if (file.toString().endsWith(".pdf")) 
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
    else {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
}
        
    } 
    	catch (IOException ex) 
    	{
    		
        	JOptionPane.showMessageDialog(null,"\n ERROR !!! \n File Requested not Found !!! \n","INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        
    }
		 		
        }
		
      }
      );
	 MENU.add(instructions);
            MENU.add(new JSeparator());   //add a seperator line
	 
       // add JLabel EXIT;
	     
	     		 EXIT=new JLabel("Exit Program");
	  EXIT.setBackground(Color.WHITE);
	   EXIT.setForeground(Color.BLACK);
	 EXIT.setEnabled(true);
    EXIT.addMouseListener(new MouseAdapter() 
	{
         Color oldcolor =EXIT.getForeground();
         public void mouseEntered(MouseEvent me) 
		{
			Color c=Color.orange;
           EXIT.setForeground(c);
         }
         public void mouseExited(MouseEvent me) 
	 {
          EXIT.setForeground(oldcolor);
         }
      }
      );
	EXIT.addMouseListener(new MouseAdapter() 
	{
		
		 public void mousePressed(MouseEvent e)
		 	{
		 		
		 	System.exit(0);
		 		
        }
		
      }
      );
	 MENU.add(EXIT);

		 //
		 //Build the second menu.
		 // add Menu JLabels
		 //
	    // JLabel programAuthor;
	    
	programAuthor=new JLabel("Program Author");
	programAuthor.setBackground(Color.WHITE);
	programAuthor.setForeground(Color.BLACK);
	programAuthor.setEnabled(true);
   programAuthor.addMouseListener(new MouseAdapter() 
	{
         Color oldcolor =programAuthor.getForeground();
         public void mouseEntered(MouseEvent me) 
		{
			Color c=Color.orange;
           programAuthor.setForeground(c);
         }
         public void mouseExited(MouseEvent me) 
	 {
         programAuthor.setForeground(oldcolor);
         }
      }
      );
	programAuthor.addMouseListener(new MouseAdapter() 
	{
		
		 public void mousePressed(MouseEvent e)
		 	{
		 		
		 		try {
    	
        File file = new File("author.pdf");
    if (file.toString().endsWith(".pdf")) 
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
    else {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
}
        
    } 
    	catch (IOException ex) 
    	{
    		
	JOptionPane.showMessageDialog(null,"\n ERROR !!! \n File Requested not Found !!! \n","INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        
    }
		 		
        }
		
      }
      );
      ABOUT.add(programAuthor);
      
      // add the program menu to the appropriate JPanel 
            
    programMenu.add(KBMenuBar);
      
      //
      
      content.add(programMenu, BorderLayout.NORTH);
		
	//
		
	drawPad.setBorder(BorderFactory.createLineBorder(Color.black));
		
      //
      
		content.add(drawPad, BorderLayout.CENTER);
		//sets the padDraw in the center
		
		JPanel panel = new JPanel();
		//creates a JPanel
      
		panel.setPreferredSize(new Dimension(150, 30));
		panel.setMinimumSize(new Dimension(150, 30));
		panel.setMaximumSize(new Dimension(150, 30));
		//This sets the size of the panel
		
		JButton color = new JButton("Choose Painting Color");
		color.setToolTipText("Choose Painting Color");
		color.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				drawPad.choosePaintingColor();
			}
		});
		
		JButton clearButton = new JButton("Clear Painting Panel");
		clearButton.setToolTipText("Clear Painting Panel");
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				drawPad.clear();
			}
		});
		//this is the clear button, which clears the screen.  This pretty
		//much attaches an action listener to the button and when the
		//button is pressed it calls the clear() method
		
		color.setPreferredSize(new Dimension(145, 30));
		clearButton.setPreferredSize(new Dimension(145, 30));
		//sets the sizes of the buttons
		
		panel.add(color);
		panel.add(clearButton);
		//adds the buttons to the panel
		
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBackground(Color.CYAN);// set jlabel background 
		
		content.add(panel, BorderLayout.WEST);
		//sets the panel to the left
		
		frame.setDefaultLookAndFeelDecorated(true);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.setVisible(true);
		
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		
	        frame.pack();
		
		frame.setSize(700, 700);
		//sets the size of the frame
		
	}
}

class PadDraw extends JComponent
{
	private Image image;
	//this is gonna be your image that you draw on
	
	private Graphics2D graphics2D;
	//this is what we'll be using to draw on
	
	private int currentX, currentY, oldX, oldY;
	//these are gonna hold our mouse coordinates
	
	private Color panelColor;

	//Now for the constructors
	public PadDraw()
	{
		
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		//if the mouse is pressed it sets the oldX & oldY
		//coordinates as the mouses x & y coordinates
		
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				currentX = e.getX();
				currentY = e.getY();
				if(graphics2D != null)
				graphics2D.drawLine(oldX, oldY, currentX, currentY);
				repaint();
				oldX = currentX;
				oldY = currentY;
			}

		});
		//while the mouse is dragged it sets currentX & currentY as the mouses x and y
		//then it draws a line at the coordinates
		//it repaints it and sets oldX and oldY as currentX and currentY
		
	}

	public void paintComponent(Graphics g)
	{
		if(image == null)
		{
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}
	//this is the painting bit
	//if it has nothing on it then
	//it creates an image the size of the window
	//sets the value of Graphics as the image
	//sets the rendering
	//runs the clear() method
	//then it draws the image


	public void clear()
	{
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	//this is the clear
	//it sets the colors as white
	//then it fills the window with white
	//thin it sets the color back to black

	public void choosePaintingColor()
	{
	
	panelColor=JColorChooser.showDialog(PadDraw.this,"choose a painting color",panelColor);	
	
		graphics2D.setPaint(panelColor);
		
		repaint();
	
	}
	// choose paint color ... 

}

//
