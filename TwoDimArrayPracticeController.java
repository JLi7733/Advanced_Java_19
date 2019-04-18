/** TwoDimArrayPracticeController
*   Anderson, Franceschi
*/

import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

import javafx.animation.AnimationTimer;

public class TwoDimArrayPracticeController 
{
 private final int ROWS = 4;
 private final int COLUMNS = 20;

 private BarChart bc;
  
 private int [][] arr;
 private int key;
 private int rowSelected;
 private static int [][] result;
  
 @FXML private BorderPane bp;
 @FXML private HBox hBox1;
 @FXML private HBox hBox2;
 
 @FXML private Button fill;
 @FXML private Button print;
 @FXML private Button set;
 @FXML private Button count;
 @FXML private Button find;
 private int activity; // 0=fill; 1=print; 2=set; 3=count; 4=find

 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private boolean animate = false;
 private boolean run = false;
 private int resultValue;

 public void initialize( )
 { 
   arr = new int [ROWS][COLUMNS];
   result = new int [ROWS][COLUMNS];
     
   // fill with random numbers between 50 and 80
   for ( int i = 0; i < arr.length; i++ )
   {
     for ( int j = 0; j < arr[i].length; j++ )
       arr[i][j] = ( int ) ( Math.random( ) * 31 ) + 50;   
   }
  
   bc = new BarChart( arr );
    
   Insets insets = new Insets( Dimensions.APP_PADDING, Dimensions.APP_PADDING, 
                               Dimensions.APP_PADDING, Dimensions.APP_PADDING );
   bp.setPadding( insets );
   hBox1.setPadding( insets );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH, 
                        Dimensions.APP_HEIGHT );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( ); 
    
   bc.draw( gc );
 }

 @FXML protected void activity( ActionEvent event ) 
 {
   bc.draw( gc );
   if ( event.getSource( ) == fill )
   {
     activity = 0;
     fillValues( );
     bc.setData( arr );
   }
   else if ( event.getSource( ) == print )
   {
     activity = 1;
     printArray( );
   } 
   else if ( event.getSource( ) == set )
   {
     activity = 2;
     getKeyInputForSetValue( );
     if ( run )
     {
       bc.setKey( key );
       bc.setRowSelected( rowSelected );
       setValues( key, rowSelected );
       bc.setData( arr );
     }
     else
       animate = false;
   }
   else if ( event.getSource( ) == count )
   {
     activity = 3;
     getKeyInput( activity );
     if ( run )
     {
       bc.setKey( key );
       resultValue = countFound( key );
       bc.setResultValue( resultValue );
     }
     else
       animate = false;
   } 
   else if ( event.getSource( ) == find )
   {
     activity = 4;
     getKeyInputForMinimum( );
     if ( run )
     {
       bc.setKey( key );
       resultValue = findMinimum( key );
       bc.setResultValue( resultValue );
     }
     else
       animate = false;
   }
   if ( animate )
   {
     disableButtons( true );
     AnimationTimer timer = new ArrayAnimationTimer( );
     timer.start( );
   }
 }

 public void disableButtons( boolean state )
 {
   fill.setDisable( state );
   print.setDisable( state );
   set.setDisable( state );
   count.setDisable( state );
   find.setDisable( state );
 }
 
 // ***** 1.  This method has been coded as an example
 /** Fills the array with random numbers between 50 and 80
 *  The instance variable named arr is the integer array to be
 *  filled with values
 */
 public void fillValues( )
 {
   Random rand = new Random( );
   for ( int row = 0; row < arr.length; row++ )
   {
     System.out.print( row + "\t" );
     for ( int column = 0; column < arr[row].length; column++ )
     {
       arr[row][column] = rand.nextInt( 31 ) + 50;
       animate( row, column, -1 );  // needed to create visual feedback
     }
     System.out.println( );
   }
 }
 // end of fillValues method

 // ***** 2.  Student writes this method
 /** Prints array to the console, elements are separated by a space
 *    The instance variable named arr is the integer array to be printed
 */
 public void printArray( )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your inner for loop
   //    animate( row, column, -1 );
   //  where row is the index of the array's current row
   //  and column is the index of the array's current column
   // Write your code here:
     for(int row = 0; row<arr.length;row++){
         for(int column = 0; column<arr[row].length; column++){
             System.out.print(arr[row][column]+ "\t");
             animate(row, column, -1);
         }
         System.out.println();
     }

 }
 // end of printArray method

 // ***** 3.  Student writes this method
 /** Sets all the elements in the specified row to the specified value
 *    The instance variable named arr is the integer array
 *  @param value  the value to assign to the element of the row
 *  @param row  the row in which to set the elements to value
 */
 public void setValues( int value, int row )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your for loop
   //    animate( row, column, -1 );
   //  where row is the index of the array's current row
   //  and column is the index of the array's current column
   // Write your code here:
    for(int column = 0; column<arr[row].length; column ++){
        arr[row][column] = value;
        animate(row,column,-1);
    }
 }
 // end of setValues method

 // ***** 4.  Student writes this method
 /** Finds minimum value in the specified column
 *    The instance variable named arr is the integer array
 *  @param column the column to search
 *  @return   the minimum value found in the column
 */
 public int findMinimum( int column )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your for loop
   //    animate( row, column, minimum );
   //  where row is the index of the array's current row,
   //        column is the index of the array's current column
   //        minimum is the local variable storing the current minimum
   // Write your code here:
     int minimum = arr[0][column];
     for(int row = 0; row<arr.length; row++){
        if(arr[row][column]<minimum)
            minimum = arr[row][column];
        animate(row, column, minimum);
    }
   
   return minimum; // replace this line with your return statement
 }
 // end of findMinimum method

 // ***** 5.  Student writes this method
 /** Finds the number of times value is found in the array
 *    The instance variable named arr is the integer array
 *  @param value  the value to count
 *  @return   the number of times value was found
 */
 public int countFound( int value )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your inner for loop
   //    animate( row, column, num );
   //  where row is the index of the array's current row,
   //        column is the index of the array's current column, and
   //        num is the local variable storing the current frequency count
   // Write your code here:
     int num = 0;
     for(int row = 0; row<arr.length;row++){
         for(int column = 0; column < arr[row].length; column++){
             if(arr[row][column] == value) {
                 num++;
             }
             animate(row, column, num);
         }
     }

   
   return num; // replace this line with your return statement
 }
 // end of countFound method

 public void animate( int i, int j, int value )
 {
     int [][] array = new int[arr.length][];
     for ( int k = 0; k < arr.length; k++ )
       array[k] = new int[arr[k].length];
       
     for ( int k = 0; k < arr.length; k++ )
     {
       for ( int l = 0; l < arr[k].length; l++ )
         array[k][l] = arr[k][l];
     }
   
     MethodState ms = new MethodState( i, j, value, array );
     bc.addMethodState( ms );
     animate = true;
 }
  
 public void getKeyInput( int a )
 {
   run = false;
   String keyString = "";
   if ( a == 4 )
     keyString = "Enter an integer value between 50 and 80";
   else if ( a == 3 )
     keyString = "Frequency Count";

   boolean goodInput = false;
   while ( !goodInput || key < 50 || key > 80 )
   {
     try
     {
       TextInputDialog dialog = new TextInputDialog( "" );
       dialog.setTitle( "User Input" );
       dialog.setHeaderText( keyString );
       dialog.setContentText( "Enter an int between 50 and 80" );
       Optional<String> result = dialog.showAndWait( );
       String answer = null;
       if ( result.isPresent( ) ) 
         answer = result.get( );

       if ( answer != null )
       {
         key = Integer.parseInt( answer );
         bc.setKey( key );
         goodInput = true;
         run = true;
       }
       else
       {
         goodInput = false;
         run = false;
         break;
       }
     }
     catch ( Exception e )
     {}
   }
 }
 
 public void getKeyInputForMinimum( )
 {
   run = false;
   String keyString = "Compute the Minimum Value for a Column";
   
   boolean goodInput = false;
   while ( !goodInput || key < 0 || key > COLUMNS - 1 )
   {
     try
     {
       TextInputDialog dialog = new TextInputDialog( "" );
       dialog.setTitle( "User Input" );
       dialog.setHeaderText( keyString );
       dialog.setContentText( "Enter an int between 0 and " + ( COLUMNS - 1 ) );
       Optional<String> result = dialog.showAndWait( );
       String answer = null;
       if ( result.isPresent( ) ) 
         answer = result.get( );
       if ( answer != null )
       {
         key = Integer.parseInt( answer );
         bc.setKey( key );
         goodInput = true;
         run = true;
       }
       else
       {
         goodInput = false;
         run = false;
         break;
       }
     }
     catch ( Exception e )
     {}
   }
 }

 
 public void getKeyInputForSetValue( )
 {
   run = false;
   String keyString = "Set Values for a Row";
  
   boolean goodInput = false;
   while ( !goodInput || key < 50 || key > 80 )
   {
     try
     {
       TextInputDialog dialog = new TextInputDialog( "" );
       dialog.setTitle( "User Input" );
       dialog.setHeaderText( keyString );
       dialog.setContentText( "Enter an int between 50 and 80" );
       Optional<String> result = dialog.showAndWait( );
       String answer = null;
       if ( result.isPresent( ) ) 
         answer = result.get( );

       if ( answer != null )
       {
         key = Integer.parseInt( answer );
         bc.setKey( key );
         goodInput = true;
         // run = true;
       }
       else
       {
         goodInput = false;
         break;
       }
     }
     catch ( Exception e )
     {}
   }
   
   if ( goodInput )
   {
     run = false;
     goodInput = false;
     while ( !goodInput || rowSelected < 0 || rowSelected > 3 )
     {
       try
       {
         TextInputDialog dialog = new TextInputDialog( "" );
         dialog.setTitle( "User Input" );
         dialog.setHeaderText( "Set Values for a Row" );
         dialog.setContentText( "Enter an int between 0 and 3" );
         Optional<String> result = dialog.showAndWait( );
         String answer = null;
         if ( result.isPresent( ) ) 
           answer = result.get( );

         if ( answer != null )
         {
           rowSelected = Integer.parseInt( answer );
           goodInput = true;
           run = true;
         }
         else
         {
           goodInput = false;
           run = false;
           break;
         }
       }
       catch( Exception e )
       {}
     }
   }

 }

 private class ArrayAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {
     if ( activity != 1 )
       Pause.wait( .5 );
          
     // update screen       
     if ( activity == 0 )
       bc.drawNewArray( gc ); 
     else if ( activity == 1)
       bc.drawArray( gc );
     else if ( activity == 2)
       bc.drawNewValue( gc );
     else if ( activity == 3)
       bc.drawCountValue( gc );
     else if ( activity == 4)
       bc.drawMinimum( gc );
          
     bc.incrementCurrentIndex( );  
     if ( ! bc.checkCurrentIndex( ) )
     {
       bc.resetCurrentIndex( );
       bc.clearMS( );
       stop( );
       disableButtons( false );
     } 
   }
 }

}