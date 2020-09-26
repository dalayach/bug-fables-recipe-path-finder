package io.github.dalayach;

import java.awt.Component;
import javax.swing.SpringLayout;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;
import java.util.EnumMap;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

/** GUI Card that prompts user to use any of the items they already have in their inventory. */
public class CardUseYourOwnItems extends JScrollPane
{

   /** Main panel. */
   private JPanel mainPanel = new JPanel();
   
   /** Constructor. */
   public CardUseYourOwnItems() throws ParseException
   {
      
      //we MUST set a specific layout if we want to be able to scroll.
      //using a GridLayout is easier, since we can control the number of columns
      mainPanel.setLayout(new SpringLayout());
      
      //place the JPanel inside the JScrollPane (this)
      this.setViewportView(mainPanel);
      
      //don't allow horizontal scrolling - cleaner with only vertical scrolling.
      //plus, not all users can horizontal scroll
      this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      
      //the scroll speed is a bit slow for my liking
      this.getVerticalScrollBar().setUnitIncrement(7);
      
      String titleBorder =
         "Please enter the quantity of each food item that is already in your inventory and you are willing to use!";
      
      //place a quick description on the top border of the JScrollPane
      this.setViewportBorder(new TitledBorder(titleBorder));
      
      this.addFoodItemsToPanel();
      
      //after every update to panel, we must run these 2 commands (I will assume in this order)
      mainPanel.revalidate();
      mainPanel.repaint();
       
   }
   
   /** Adds foodItem labels and respective textfields to the panel. */
   public void addFoodItemsToPanel() throws ParseException
   {
   
      for (String each : BugFablesFoodItem.getAlphabeticallyOrderedListOfFoodItems())
      {
      
         JLabel l = new JLabel(each, JLabel.TRAILING);
         this.mainPanel.add(l);
         DecimalFormat format = new DecimalFormat();
         format.setMaximumFractionDigits(0);
         format.setMaximumIntegerDigits(5);
         format.setParseIntegerOnly(true);
         JFormattedTextField textField = new JFormattedTextField(new NumberFormatter(format));
         textField.setText("0");
         l.setLabelFor(textField);
         this.mainPanel.add(textField);
      
      }
   
      //Lay out the panel.
      SpringUtilities.makeCompactGrid(this.mainPanel,
         BugFablesFoodItem.values().length, 2, //rows, cols
         6, 6,        //initX, initY
         6, 6);       //xPad, yPad
   
   }
   
   /** Returns  */
   public final Map<BugFablesFoodItem, Integer> getAnswers()
   {
   
      Map<BugFablesFoodItem, Integer> responses = new EnumMap<>(BugFablesFoodItem.class);
      
      for (Component component : mainPanel.getComponents())
      {
      
         if (component instanceof JLabel)
         {
         
            JLabel label = (JLabel) component;
         
            if (label.getText() != null && label.getText().trim() != "")
            {
            
               JTextField textField = ((JTextField) label.getLabelFor());
               BugFablesFoodItem foodItem = Enum.valueOf(BugFablesFoodItem.class, label.getText());
               
               textField.setText(this.cleanUpUserInput(textField.getText()));
            
               responses.put(foodItem, Integer.parseInt(textField.getText().trim()));
            
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
