package io.github.dalayach;

import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

/** GUI Card that prompts user about how much empty inventory space they want to use. */
public class CardHowMuchInventorySpace extends JScrollPane
{

   /** Main panel. */
   private JPanel mainPanel = new JPanel();
   
   private static final String LABEL1 = "How many EMPTY slots do you have in your personal inventory?";
   private static final String LABEL2 = "<html>How many EMPTY slots do you have in your Storage Service "
         + "inventory?<br>(the insect with the massive blue backpack)</html>";
   
   /** Constructor. */
   public CardHowMuchInventorySpace()
   {
   
      final Dimension textFieldDimensions = new Dimension(50, 20);
       
      //we MUST set a panel layout if we want to be able to scroll
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
      
      //place the JPanel inside the JScrollPane (this)
      this.setViewportView(mainPanel);
      
      //no horizontal scrolling
      this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      
      //put some instructions on the top
      this.setViewportBorder(new TitledBorder("How many inventory slots do you have?"));
      
      //create a formatter to prevent invalid user input
      DecimalFormat format = new DecimalFormat();
      format.setMaximumFractionDigits(0);
      format.setMaximumIntegerDigits(5);
      format.setParseIntegerOnly(true);
   
      //creating the textfields and their adjacent labels
      JLabel personalInventorySlotsDesc = new JLabel(LABEL1);
      JFormattedTextField personalInventorySlots = new JFormattedTextField(new NumberFormatter(format));
      JLabel antStorageInventorySlotsDesc = new JLabel(LABEL2);
      JFormattedTextField antStorageInventorySlots = new JFormattedTextField(new NumberFormatter(format));
      
      //tie the label to the respective textField
      personalInventorySlotsDesc.setLabelFor(personalInventorySlots);
      antStorageInventorySlotsDesc.setLabelFor(antStorageInventorySlots);
      
      //configure each of the textfields with dimensions and initial values
      personalInventorySlots.setMaximumSize(textFieldDimensions);
      personalInventorySlots.setText("0");
      antStorageInventorySlots.setMaximumSize(textFieldDimensions);
      antStorageInventorySlots.setText("0");
         
      //putting all of the items on a scrollable list of checkboxes
      mainPanel.add(personalInventorySlotsDesc);
      mainPanel.add(personalInventorySlots);
      mainPanel.add(antStorageInventorySlotsDesc);
      mainPanel.add(antStorageInventorySlots);
      
      //after every update to panel, we must run these 2 commands (I will assume in this order)
      mainPanel.revalidate();
      mainPanel.repaint();
       
   }
   
   /** Returns  */
   public final List<Integer> getAnswers()
   {
   
      List<Integer> responses = new ArrayList<>();
      
      for (Component component : mainPanel.getComponents())
      {
      
         if (component instanceof JLabel)
         {
         
            JLabel label = (JLabel) component;
         
            if (label.getLabelFor() instanceof JFormattedTextField)
            {
            
               JFormattedTextField textField = ((JFormattedTextField) label.getLabelFor());
               
               textField.setText(this.cleanUpUserInput(textField.getText()));
            
               System.out.println(label.getText());
            
               switch (label.getText())
               {
               
                  case LABEL1:
                     responses.add(0, Integer.parseInt(textField.getText().trim()));
                     break;
                  case LABEL2:
                     responses.add(1, Integer.parseInt(textField.getText().trim()));
                     break;
               }
            
            
            }
         
         }
      
      }
      
      return responses;
   
   }
   
   public String cleanUpUserInput(String input)
   {
   
      String output = "";
   
      if (input != null && !input.isEmpty())
      {
      
         for (char c : input.toCharArray())
         {
         
            if (Character.isDigit(c))
            {
            
               output += c;
            
            }
         
         }
      
      }
      
      return output != "" ? output : "0";
   
   }
   
}
