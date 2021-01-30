package io.github.dalayach;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

/** GUI Card that prompts the user to use foodItems they've created as ingredients for other foodItems. */
public class CardAllowFoodItemReuse extends JScrollPane
{

   /** Main panel that houses everything. */
   private JPanel mainPanel = new JPanel();
   /** Label containing the prompt text. */
   private JLabel jLabel = new JLabel();
   private static final String TEXT = "Use created foodItems as ingredients for recipes of other foodItems?";
      
    /** Constructor. */
   public CardAllowFoodItemReuse(BorderLayout layout, double width, boolean spoilersAllowed)
   {
       
      //we MUST set a panel layout if we want to be able to scroll
      //rows, columns, horizontal gap, vertical gap
      mainPanel.setLayout(layout);
      
      //place the JPanel inside the JScrollPane (this)
      this.setViewportView(mainPanel);
      this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      this.setViewportBorder(new TitledBorder("Reuse items for other recipes?"));
      
      this.createJLabel(width - 200, spoilersAllowed);
      
      //putting all of the items on a scrollable list of checkboxes
      mainPanel.add(this.jLabel, BorderLayout.CENTER);
      mainPanel.add(new JCheckBox(TEXT), BorderLayout.PAGE_END);
      
      //after every update to panel, we must run these 2 commands (I will assume in this order)
      mainPanel.revalidate();
      mainPanel.repaint();
       
   }
   
   /** Returns the user's answer. */
   public final boolean getAnswers()
   {
   
      for (Component component : mainPanel.getComponents())
      {
      
         if (component instanceof JCheckBox
            && ((JCheckBox) component).isSelected()
            && ((JCheckBox) component).getText() == TEXT)
         {
         
            return true;
            
         }
      
      }
      
      return false;
   
   }
   
   /** Creates the JLabel. Width decides how many columns, and spoilersAllowed decides the specific text used. */
   public void createJLabel(double width, boolean spoilersAllowed)
   {
   
      String label = "<html><p>Do you want to take the foodItems you make, and use them as ingredients"
         + " for other foodItems on your list?</p><p></p>";
         
      label += (!spoilersAllowed ? "</html>"
         : 
         "<p>For example, let's say that the 2 recipes you need to create are a Glazed Honey and a Crisbee Donut."
         + "</p><p></p>"
         + "<p>A Glazed Honey is made by cooking a Honey Drop.</p><p> A "
         + "Crisbee Donut is made by cooking a Glazed Honey and a "
         + "Bag of Flour.</p><p></p>"
         + "<p>Do you want to first make the Glazed Honey, then use that same Glazed Honey"
         + " you made as an ingredient in the Crisbee Donut? Or do you want to keep that "
         + "Glazed Honey for yourself, and make another Glazed Honey for the "
         + "Crisbee Donut?<p></p><p>Check the box below if you want to use the foodItems you make as ingredients"
         + " for other foodItems (only cook 1 Glazed Honey). Leave it unchecked if you want to keep the "
         + "ingredients for yourself (have to cook 2 Glazed Honeys, since you will be keeping the first "
         + "and cooking the other)."
         + "</p></html>")
         ;
      
      final String html = "<html><body style='width: %1spx'>%1s";
      
      this.jLabel.setText(String.format(html, width, label));
   
      //after every update to panel, we must run these 2 commands (I will assume in this order)
      mainPanel.revalidate();
      mainPanel.repaint();
      
   }
   
}
