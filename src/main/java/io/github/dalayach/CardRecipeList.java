package io.github.dalayach;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Set;
import java.util.EnumSet;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

/** GUI Card that prompts user to pick the recipes they want to make. */
public class CardRecipeList extends JScrollPane
{

   /** Main panel. */
   private JPanel mainPanel = new JPanel();
   
   /** Constructor. Uses layout to ensure the correct number of columns, and spoilersAllowed decides the checkbox text. */
   public CardRecipeList(GridLayout layout, boolean spoilersAllowed)
   {
      
      //we MUST set a specific layout if we want to be able to scroll.
      //using a GridLayout is easier, since we can control the number of columns
      mainPanel.setLayout(layout);
      
      //place the JPanel inside the JScrollPane (this)
      this.setViewportView(mainPanel);
      
      //don't allow horizontal scrolling - cleaner with only vertical scrolling.
      //plus, not all users can horizontal scroll
      this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      
      //the scroll speed is a bit slow for my liking
      this.getVerticalScrollBar().setUnitIncrement(7);
      
      String titleBorder = "<html>Please select the recipes that you want to make!";
      
      titleBorder += (spoilersAllowed ? "" : " Don't worry, the numbers are a 1-to-1 match with the recipe book!");
      
      titleBorder += "<br>Use tab and spacebar to make things go faster!";
      
      //place a quick description on the top border of the JScrollPane
      this.setViewportBorder(new TitledBorder(titleBorder));
      
   
      //putting all of the items on a scrollable list of checkboxes
      for (BugFablesRecipeBook recipeBook : BugFablesRecipeBook.values())
      {
      
         String checkBoxName = "<html>" + recipeBook.getRecipeBookId();
      
         if (spoilersAllowed)
         {
         
            checkBoxName += "&emsp;" + recipeBook.name();
         
         }
         
         checkBoxName += "</html>";
      
         //add JCheckBox to the JPanel -- as the JPanel gets bigger within the JScrollPane, the JScrollPane will add a
         //scroll wheel to the right to allow the user to scroll to that content 
         mainPanel.add(new JCheckBox(checkBoxName));
      
      }
      
      //after every update to panel, we must run these 2 commands (I will assume in this order)
      mainPanel.revalidate();
      mainPanel.repaint();
       
   }
   
   /** Returns the Set of recipes that the user chose. */
   public final Set<BugFablesRecipeBook> getAnswers()
   {
   
      Set<BugFablesRecipeBook> recipeBooks = EnumSet.noneOf(BugFablesRecipeBook.class);
      
      for (Component component : mainPanel.getComponents())
      {
      
         if (component instanceof JCheckBox) {
         
            JCheckBox checkBox = (JCheckBox) component;
         
            if (checkBox.isSelected())
            {
            
               String enumName = new String(checkBox.getText());
            
               System.out.println(enumName);
            
               if (!enumName.replaceAll("[^A-Z_]", "").isEmpty())
               {
                  recipeBooks.add(BugFablesRecipeBook.valueOf(enumName.replaceAll("[^A-Z_]", "")));
               }
               
               else
               {
                  recipeBooks.add(BugFablesRecipeBook.values()[Integer.parseInt(enumName.replaceAll("[^0-9]", "")) - 1]);
               }
            
            }
         
         }
      
      }
      
      return recipeBooks;
   
   }
   
}
