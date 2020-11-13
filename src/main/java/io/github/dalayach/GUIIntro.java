package io.github.dalayach;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
   
/** Class that houses the primary GUI the user will be interacting with. Houses all "cards." */
public class GUIIntro implements ActionListener
{

   /** Decides whether or not spoiler text will be returned to the user. */
   private final boolean allowSpoilers;
   /** Decides whether or not we can even run this program. */
   private final boolean canWeRunProgram;

   /** A panel that uses CardLayout to flip between other panels at the push of a button. */
   private JPanel parentCard;
   /** Contains the List of "cards" (pages) that the user can page through. */
   private List<JScrollPane> listOfCards = new ArrayList<>();
   
   /** Previous button. */
   private JButton previous;
   /** Next button. */
   private JButton next;
   /** Finish button. */
   private JButton finish;
   
   private static final String PREVIOUS = "Previous";
   private static final String NEXT = "Next";
   private static final String FINISH = "Finish";
   
   /** Layout useful for aligning components for proper spacing within the JScrollPane. */
   private GridLayout gridLayout = new GridLayout(0, 1, 0, 0);
   /** Card to ask user what recipes to make. */
   private CardRecipeList recipeListCard;
   /** Card to ask user about reusing foodItems for other foodItem recipes. */
   private CardAllowFoodItemReuse allowFoodItemReuseCard;
   /** Card to ask user about inventory space. */
   private CardHowMuchInventorySpace howMuchInventorySpaceCard;
   /** Card to ask user if they want to use any of their own items to make the recipes with. */
   private CardUseYourOwnItems useYourOwnItemsCard;
   
   public static final String AVOID_SPOILERS_PROMPT = "<html><p>"
         + "Welcome to the Bug Fables Recipe Path Finder! This is an application that will help you find a fairly<br>"
         + "optimal path for unlocking all of the recipes in the game!<br><br>"
         + "Would you like to AVOID spoilers for the names of recipes? (Nothing else besides recipe/food item<br>"
         + "names will be spoiled)"
         + "</p></html>";
         
   public final ImageIcon dialogIcon;
   public final ImageIcon windowIcon;

   /** Constructor. */
   public GUIIntro(ImageIcon dialogIcon, ImageIcon windowIcon) 
   {
   
      this.dialogIcon = dialogIcon;
      this.windowIcon = windowIcon;
   
      //ask user if they want to AVOID SPOILERS
      switch(JOptionPane.showConfirmDialog(
         null,
         this.AVOID_SPOILERS_PROMPT,
         "Bug Fables Recipe Path Finder!",
         JOptionPane.YES_NO_CANCEL_OPTION,
         JOptionPane.QUESTION_MESSAGE,
         dialogIcon
         ))
      {
      
         case (JOptionPane.NO_OPTION):
            this.canWeRunProgram = true;
            this.allowSpoilers = true;
            break;
         case (JOptionPane.YES_OPTION):
            this.canWeRunProgram = true;
            this.allowSpoilers = false;
            break;
         default: //they clicked the X button or cancel -- either way, we should end the program
            this.allowSpoilers = false;
            this.canWeRunProgram = false;
      
      }
      
      if (this.canWeRunProgram) {
      
         JFrame frame = this.createJFrame();
      
         boolean safe = true;
      
         try
         {
         
            //some of the cards might throw an exception
            this.addEachCard(frame);
         
         } catch (ParseException pe) //if there is an exception
         {
         
            //set the flag to false to signify that we failed to add the proper cards
            safe = false;
         
         }
      
         //if the safe flag is true
         if (safe)
         {
         
            //go ahead and display the application, allowing the user to start using it
            frame.setVisible(true);
         
         } else //otherwise
         {
         
            //make sure it is invisible, then close the frame, which should close the program
            frame.setVisible(false);
            frame.dispose();
         
         }
      
      }
   
   }
   
   /** Creates JFrame. */
   public JFrame createJFrame()
   {
   
      JFrame frame = new JFrame("Bug Fables Recipe Path Finder");
      
      //program should end when we close
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //set the top left dialogIcon for the application
      frame.setIconImage(this.windowIcon.getImage());
   
      //width, height
      frame.setSize(700, 400);
      
      //center the application in the middle of the screen
      this.centerWindow(frame);
      
      //set up and activate the card/page functionality using the 3 buttons
      this.setUpCardLayout(frame.getContentPane());
      
      JRootPane rootPane = SwingUtilities.getRootPane(next); 
      rootPane.setDefaultButton(next);
      
      return frame;
   
   }
   
   /** Centers the JFrame on the screen. (ideally) */
   public static final void centerWindow(final Window window) {
   
      GraphicsDevice screen = MouseInfo.getPointerInfo().getDevice();
      Rectangle r = screen.getDefaultConfiguration().getBounds();
      
      int x = (r.width - window.getWidth()) / 2 + r.x;
      int y = (r.height - window.getHeight()) / 2 + r.y;
      
      window.setLocation(x, y);
      
   }
   
   /** Sets up the CardLayout, complete with JButtons for simple traversal through the cards. */
   public void setUpCardLayout(Container pane) {
   
      JPanel traversalPanel = new JPanel();
      
      previous = new JButton(PREVIOUS);
      previous.setEnabled(false);
      previous.setActionCommand(PREVIOUS);
      previous.addActionListener(this);
      
      next = new JButton(NEXT);
      next.setEnabled(true);
      next.setActionCommand(NEXT);
      next.addActionListener(this);
      
      finish = new JButton(FINISH);
      finish.setEnabled(false);
      finish.setActionCommand(FINISH);
      finish.addActionListener(this);
      
      traversalPanel.add(previous);
      traversalPanel.add(next);
      traversalPanel.add(finish);
      
      //Create the "parentCard".
      parentCard = new JPanel(new CardLayout());
   
      pane.add(parentCard);
      pane.add(traversalPanel, BorderLayout.SOUTH);
   
   }
  
   /** Action handler for the traversal button. Allows GUI to flip through the cards. */
   public void actionPerformed(ActionEvent e)
   {
   
      CardLayout cardLayout = (CardLayout) (parentCard.getLayout());
   
      if (this.listOfCards.size() >= 2) {
      
         switch (e.getActionCommand())
         {
         
            case PREVIOUS:
               if (!this.isCurrentCard(this.listOfCards.get(0)))
               { cardLayout.previous(parentCard); }
               break;
            case NEXT:
               if (!this.isCurrentCard(this.listOfCards.get(this.listOfCards.size() - 1)))
               { cardLayout.next(parentCard); }
               break;
            case FINISH:
               if (this.isCurrentCard(this.listOfCards.get(this.listOfCards.size() - 1)))
               {
               
                  Date start = new Date();
                  AlgorithmPathFinder.findBestPathway(this.recipeListCard.getAnswers());
                  cardLayout.next(parentCard);
                  Date end = new Date();
                  
                  System.out.println("Time difference = " + (end.getTime() - start.getTime()) + " ms");
               
               }
               break;
            default:
               break;
            
         }
      
         this.enableAndDisableRelevantButtons();
      
      } else
      {
      
         previous.setEnabled(false);
         next.setEnabled(false);
         finish.setEnabled(false);  
         
      }
   
   }
   
   /** Adds each card to the JFrame. */
   private void addEachCard(JFrame frame) throws ParseException
   {
   
      this.listOfCards = this.createListOfCards(frame);
      
      for (JComponent card : this.listOfCards)
      {
      
         this.parentCard.add(card);
      
      }
      
      frame.add(parentCard);
      //frame.add(new JLabel("Welcome to the Bug Fables Recipe Path Finder!", SwingConstants.CENTER), BorderLayout.NORTH);
   
   }
   
   /** Creates and stores the list of Cards to cycle through. */
   private List<JScrollPane> createListOfCards(JFrame frame) throws ParseException
   {
   
      gridLayout.setColumns(frame.getWidth() / 200);
      recipeListCard = new CardRecipeList(gridLayout, this.allowSpoilers);
      allowFoodItemReuseCard = new CardAllowFoodItemReuse(new BorderLayout(), frame.getSize().getWidth(), this.allowSpoilers);
      howMuchInventorySpaceCard = new CardHowMuchInventorySpace();
      useYourOwnItemsCard = new CardUseYourOwnItems();
      
      List<JScrollPane> cardList = new ArrayList<>();
   
      cardList.add(recipeListCard);
      cardList.add(allowFoodItemReuseCard);
      cardList.add(howMuchInventorySpaceCard);
      
      if (this.allowSpoilers)
      {
      
         cardList.add(useYourOwnItemsCard);
      
      }
      
      recipeListCard.addComponentListener(
         new ComponentAdapter() {
         
            /** If the card is resized, alter number of columns. */
            public void componentResized(ComponentEvent e) {
               
               JScrollPane somePanel = ((JScrollPane) e.getComponent());
               
               int howManyColumns = ((int) somePanel.getSize().getWidth()) / 200;
               
               if (howManyColumns != 0 && howManyColumns != gridLayout.getColumns())
               {
               
                  gridLayout.setColumns(howManyColumns);
                  
                  //always revalidate and repaint after each major change to the UI
                  somePanel.revalidate();
                  somePanel.repaint();
                  
               }
               
            }
         });
               
      return cardList;
   
   }
   
   /** Enables and disables relevant buttons based on the current card. */
   public void enableAndDisableRelevantButtons()
   {
   
      if (this.isCurrentCard(this.listOfCards.get(0)))
      {
      
         previous.setEnabled(false);
         
         if (this.listOfCards.size() > 2)
         {
         
            next.setEnabled(true);
            finish.setEnabled(false);
         
         }
         
      }
      
      if (this.isCurrentCard(this.listOfCards.get(this.listOfCards.size() - 1)))
      {
      
         next.setEnabled(false);
         finish.setEnabled(true);  
         
      }
      
      if (!(this.isCurrentCard(this.listOfCards.get(0)))
         && !(this.isCurrentCard(this.listOfCards.get(this.listOfCards.size() - 1))))
      {
      
         previous.setEnabled(true);
         next.setEnabled(true);
         finish.setEnabled(false);  
         
      }
         
   }
   
   /** Returns whether or not the given card is the current card on display. */
   public boolean isCurrentCard(JScrollPane cardToTest)
   {
   
      for (Component component : this.parentCard.getComponents())
      {
      
         if (component.isVisible() && component instanceof JScrollPane && cardToTest == (JScrollPane) component)
         {
         
            return true;
         
         }
         
      }
         
      return false;
            
   }
  
}
