package io.github.dalayach;

/** Checked exception to ensure we deal with the edge case that we try to remove more than there is to remove. */
public class OutOfBoundsException extends Exception
{

   public OutOfBoundsException()
   {
   
      super();
   
   }

   public OutOfBoundsException(String message)
   {
   
      super(message);
   
   }

}
