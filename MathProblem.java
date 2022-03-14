
public class MathProblem {

    // To make the code more organized.

    static class Rectangle {
        int x1, y1, x2, y2;
        int left, right, top, bottom;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;

            if (x1 < x2) { left = x1; right = x2; } 
            else { left = x2; right = x1; }
    
            if (y1 < y2) { bottom = y1; top = y2; } 
            else { bottom = y2; top = y1; }
        }
    }

    // This method will check all posibilities of intersection of the two rectangles

    static boolean doTheyIntersect(Rectangle Rect1, Rectangle Rect2) {

        if (Rect1.left == Rect1.right || Rect2.left == Rect2.right || Rect1.top == Rect1.bottom || Rect2.top == Rect2.bottom) return false;

        if (Rect1.left >= Rect2.right || Rect1.right <= Rect2.left) return false;

        if (Rect1.bottom >= Rect2.top || Rect1.top <= Rect2.bottom) return false;

        // If the rectangles are overlaping with no intersection, it returns false

        if (Rect1.left <= Rect2.left && Rect1.right >= Rect2.right && Rect1.top >= Rect2.top && Rect1.bottom <= Rect2.bottom) return false;

        if (Rect1.left >= Rect2.left && Rect1.right <= Rect2.right && Rect1.top <= Rect2.top && Rect1.bottom >= Rect2.bottom) return false;
        
        return true;
    }



    public static void main(String[] args) {

        // To make sure it all works I've prepared 4 different examples

        // Example1: ([0, 0], [2, 2]) & ([1, 1], [3, 3]) == True, they intersect
        Rectangle Rect1 = new Rectangle(0, 0, 2, 2);
        Rectangle Rect2 = new Rectangle(1, 1, 3, 3);

        if (doTheyIntersect(Rect1, Rect2)) System.out.println("Example 1 result: True, The Rectangles Intersect!\n");  
        else System.out.println("Example 1 result: False, Rectangles Don't Intersect!\n");


        // Example2: ([0, 10], [10, 0]) & ([5, 5], [15, 0]) == True
        Rect1 = new Rectangle(0, 10, 10, 0);
        Rect2 = new Rectangle(5, 5, 15, 0);

        if (doTheyIntersect(Rect1, Rect2)) System.out.println("Example 2 result: True, The Rectangles Intersect!\n");  
        else System.out.println("Example 2 result: False, Rectangles Don't Intersect!\n");


        // Example ([0, 2], [1, 1]) & ([-2, 0], [0, -3]) == false, no intersection
        Rect1 = new Rectangle(0, 2, 1, 1);
        Rect2 = new Rectangle(-2, 0, 0, 3);

        if (doTheyIntersect(Rect1, Rect2)) System.out.println("Example 3 result: True, The Rectangles Intersect!\n");  
        else System.out.println("Example 3 result: False, Rectangles Don't Intersect!\n");


        // Example ([1, 2], [3, 4]) & ([3, 4], [1, 2) == false, they do not intersect as they are on top of each other.
        Rect1 = new Rectangle(1, 2, 3, 4);
        Rect2 = new Rectangle(3, 4, 1, 2);

        if (doTheyIntersect(Rect1, Rect2)) System.out.println("Example 4 result: True, The Rectangles Intersect!\n");  
        else System.out.println("Example 4 result: False, Rectangles Don't Intersect!\n");

    }
}

    