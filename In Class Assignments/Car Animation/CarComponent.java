import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
   A component that shows a car.
*/
public class CarComponent extends JComponent
{
   public CarComponent()
   {
      car1 = new CarShape(20, 20, 50);
      car2 = new CarShape(300, 20, 50); 

      addMouseListener(new MousePressedListener());
      addMouseMotionListener(new MouseDraggedListener());
   }
   
   private class MousePressedListener extends MouseAdapter
   {
      public void mousePressed(MouseEvent event)
      {
         mousePoint1 = event.getPoint();
         mousePoint2 = event.getPoint(); 
         
         if (!car1.contains(mousePoint1)) mousePoint1 = null;
         else if (!car2.contains(mousePoint2)) mousePoint2 = null;
      }
   }

   private class MouseDraggedListener extends MouseMotionAdapter
   {
      public void mouseDragged(MouseEvent event)
      {
         if (mousePoint1 == null) return;
         else if (mousePoint1 != null) {
        	 Point lastMousePoint1 = mousePoint1;
             mousePoint1 = event.getPoint();
             double dx = mousePoint1.getX() - lastMousePoint1.getX();
             double dy = mousePoint1.getY() - lastMousePoint1.getY();
             car1.translate((int) dx, (int) dy);
         }
         
         else if (mousePoint2 == null) return; 
         else if (mousePoint2 != null) {
        	 Point lastMousePoint2 = mousePoint2;
             mousePoint2 = event.getPoint();
             double dx = mousePoint2.getX() - lastMousePoint2.getX();
             double dy = mousePoint2.getY() - lastMousePoint2.getY();
             car2.translate((int) dx, (int) dy);
         }
         repaint();
      }
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      car1.draw(g2);
      car2.draw(g2);
      
   }

   private CarShape car1;
   private CarShape car2; 
   private Point mousePoint1;
   private Point mousePoint2; 
}                               
