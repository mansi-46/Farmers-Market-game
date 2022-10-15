package week04;

public class PoD {
    import java.awt.*;
import java.util.Scanner;

    /**
     * Working from the Oracle Docs
     */

        /**
         * Determines if a point is inside a rectangle.
         * If a point lies on the edges of the rectangle, it is considered to be inside
         * @param r The rectangle object
         * @param p The point that might be or might not be inside the rectangle
         * @return true if inside (including edge), false otherwise
         */
        public static boolean pointInside(Rectangle r, Point p){


        }

        /**
         * Calculates the area of a rectangle
         * @param r the rectangle object
         * @return the area of the rectangle r
         */
        public static int computeArea(Rectangle r){
        }

        /**
         * Computes the perimeter of a rectangle
         * @param r the rectangle object
         * @return the perimeter of the rectangle
         */
        public static int computePerimeter(Rectangle r){

        }

        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);

            Point p = new Point(kb.nextInt(), kb.nextInt());
            Rectangle r = new Rectangle(kb.nextInt(), kb.nextInt(),kb.nextInt(), kb.nextInt());

            System.out.println("Point info: ");
            System.out.println(p);

            System.out.println("Rectangle info: ");
            System.out.println(r);

            System.out.printf("Is point inside rectangle: %b\n", pointInside(r,p));
            System.out.printf("Rectangle's area %d\n", computeArea(r));
            System.out.printf("Rectangle's perimeter %d", computePerimeter(r));
        }
    }

}
