/* ArrayListController Class
*  Anderson, Franceschi
*/

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
import java.util.*;

public class ArrayListController 
{
 private ArrayList<Auto> carList;
 private AutoDrawing drawing;
 private int activity;
  
 @FXML private BorderPane bp;
 @FXML private Button fill;
 @FXML private Button print;
 @FXML private Button set;
 @FXML private Button count;
 @FXML private Button find;
 
 private Pane pane;
 private Canvas canvas; 
 private GraphicsContext gc;
 
 private int result;
 private boolean animate;
 
 public void initialize( )
 { 
   carList = new ArrayList<Auto>( );
   drawing = new AutoDrawing( carList );
    
   pane = new Pane( );
   bp.setCenter( pane );
   canvas = new Canvas( Dimensions.APP_WIDTH - Dimensions.APP_PADDING, 
                        Dimensions.APP_HEIGHT - Dimensions.APP_PADDING );
   pane.getChildren( ).add( canvas );
   gc = canvas.getGraphicsContext2D( );
 }
 
 @FXML protected void activity( ActionEvent event ) 
 {
   if ( event.getSource( ) == fill )
   {  
     activity = 0;
     drawing.clearAutoStates( );
     fillWithCars( );
     animate = true;
   }
   else if ( event.getSource( ) == print )
   {
     activity = 1;
     drawing.clearAutoStates( );
     printAutoList( );
     animate = true;
   } 
   else if ( event.getSource( ) == set )
   {
     activity = 2;
     TextInputDialog dialog = new TextInputDialog( "" );
     dialog.setTitle( "User Input" );
     dialog.setHeaderText( "Changing the Model of All Cars" );
     dialog.setContentText( "Enter a Model" );
     Optional<String> result = dialog.showAndWait( );
     String model = null;
     if ( result.isPresent( ) ) 
         model = result.get( );
     if ( model != null )
     {
       drawing.clearAutoStates( );
       drawing.setSearchModel( model );
       setModelValues( model );
       animate = true;
     }
     else
       animate = false;
   }
   else if ( event.getSource( ) == count )
   {
     activity = 3;
     TextInputDialog dialog = new TextInputDialog( "" );
     dialog.setTitle( "User Input" );
     dialog.setHeaderText( "Computing the Count for a Model" );
     dialog.setContentText( "Enter a Model" );
     Optional<String> resultFromDialog = dialog.showAndWait( );
     String model = null;
     if ( resultFromDialog.isPresent( ) ) 
         model = resultFromDialog.get( );
     
     if ( model != null )
     {
       drawing.clearAutoStates( );
       drawing.setSearchModel( model );
       result = countFound( model );
       drawing.setResult( result );
       animate = true;
     }
     else
       animate = false;
   } 
   else if ( event.getSource( ) == find )
   {
     activity = 4;
     animate = true;
     drawing.clearAutoStates( );
     result = findMaximumMilesDriven( );
     drawing.setResult( result );
   }
   
   if ( animate )
   {
     disableButtons( true );
     AutoAnimationTimer timer = new AutoAnimationTimer( );
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
 /** Fills the carList with hard-coded Auto objects
 *    The instance variable carList is the ArrayList
 *    to be filled with Auto objects
 */
 public void fillWithCars( )
 {
   // clear carList before adding cars
   carList.clear( );
   // Reset the number of Autos to 0
   // This is needed so that the animation feedback works correctly
   Auto.clearNumberAutos( );

   Auto car1 = new Auto( "BMW", 0, 0.0 );
   Auto car2 = new Auto( "Ferrari", 100, 500.0 );
   Auto car3 = new Auto( "Jeep", 1000, 90.0 );
   Auto car4 = new Auto( "Ferrari", 10, 3.0 );
   Auto car5 = new Auto( "BMW", 4000, 200.0 );
   Auto car6 = new Auto( "Ferrari", 1000, 50.0 );

   carList.add( car1 );
   animate( car1 );
   carList.add( car2 );
   animate( car2 );
   carList.add( car3 );
   animate( car3 );
   carList.add( car4 );
   animate( car4 );
   carList.add( car5 );
   animate( car5 );
   carList.add( car6 );
   animate( car6 );
 }
 // end of fillWithcars method

 // ***** 2.  Student writes this method
 /**  Prints carList to console, elements are separated by a space
 *    The instance variable carList is the ArrayList to be printed
 */
 public void printAutoList( )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last element in your for loop
   //    animate( car );
   //  where car is the variable name for the current Auto object
   //  as you loop through the ArrayList object
   // Write your code here:
     for(Auto car: carList){
         System.out.println(car.toString());
         animate(car);
     }
  
  
 }
 // end of printAutoList method

 // ***** 3.  Student writes this method
 /** Sets the model of all the elements in carList to parameter value
 *    The instance variable carList is the ArrayList to be modified
 *  @param model the model to assign to all Auto objects in carList
 */
 public void setModelValues( String model )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your for loop
   //    animate( car );
   //  where car is the variable name for the current Auto object
   //  as you loop through the ArrayList object
   // Write your code here:
     for(Auto car: carList){
         car.setModel(model);
         animate( car );
     }


 }
 // end of setModelValues method

 // ***** 4.  Student writes this method
 /** Finds maximum number of miles driven
 *   Instance variable carList is the ArrayList to search
 *  @return the maximum miles driven by all the Auto objects
 */
 public int findMaximumMilesDriven( )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your for loop
   //    animate( car, maximum );
   //  where car is the variable name for the current Auto object
   //  and maximum is the int variable storing the current maximum
   //  number of miles for all Auto elements you have already tested
   //  as you loop through the ArrayList object
   // Write your code here:
     int maximum=0;
     for(Auto car: carList){
         if(car.getMilesDriven()>maximum) {
             maximum = car.getMilesDriven();
         }
         animate( car, maximum);
     }
   
   
   
   
   return maximum; // replace this statement with your return statement
 }
 // end of findMaximumMilesDriven method


 // ***** 5.  Student writes this method
 /** Finds number of times parameter model is found in the carList
 *   Instance variable carList is the ArrayList in which we search
 *  @param model  the model to count
 *  @return   the number of times model was found
 */
 public int countFound( String model )
 {
   // Note:  To animate the algorithm, put this method call as the
   // last statement in your for loop
   //    animate( car, num );
   //  where car is the variable name for the current Auto object
   //  and num is the int variable storing the current number of
   //  Auto elements whose model is equal to the method's parameter
   //  as you loop through the ArrayList object
   // Write your code here:
     int num = 0;
     for(Auto car: carList){
         if(model.equals(car.getModel())){
             num++;
         }
         animate(car, num);
     }

  
  

   return num; // replace this statement with your return statement
 }
 // end of countFound method

 public void animate( Auto car )
 {
   AutoState as = new AutoState( car, -1 );
   drawing.addAutoState( as );
 }

 public void animate( Auto car, int value )
 {
   AutoState as = new AutoState( car, value );
   drawing.addAutoState( as );
 }


 public void startAnimation( ) 
 {
   AutoAnimationTimer timer = new AutoAnimationTimer( );
   timer.start( );
 }
      
 private class AutoAnimationTimer extends AnimationTimer 
 {
   @Override
   public void handle( long now ) 
   {         
     // update screen  
     // gc.setFill( Color.rgb( 205, 205, 205 ) );  
     // gc.fillRect( 0, 0, Dimensions.APP_WIDTH, Dimensions.APP_HEIGHT );        
       
     if ( drawing.doneAll( ) )
     {
       stop( );
       drawing.resetIndex( );
       disableButtons( false );
       drawing.resetX( );
       drawing.resetY( );
     }
     else if ( activity == 0 )
     {
       drawing.displayCars( gc );    
       drawing.incrementIndex( );
       drawing.addToX( 2 );
       drawing.addToY( 10 );
       Pause.wait( 0.3 );
     }
     else // if( activity == 1 )
     {
       if ( drawing.done( ) )
       {
         stop( );
         drawing.incrementIndex( );
                
         drawing.resetX( );
         Pause.wait( 0.5 );
        
         startAnimation( );
       }
       else // current drawing not done
       {
         drawing.drawCar( gc );
         if ( activity == 2 )
           drawing.drawResultForSet( gc );
         if ( activity == 3 )
           drawing.drawResultForCount( gc );
         else if ( activity == 4 )
           drawing.drawResultForMaximum( gc );

         drawing.addToX( 2 );
         Pause.wait( 0.02 );

       }  
     }
               
   }
 }
}