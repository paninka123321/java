class Point {
    int x;
    int y;

    // Constructors Point():
    Point() {
        x = 1;
        y = 1;
    }
    Point(int corX, int corY){
        x = corX;
        y = corY;
    }
//    // can also do this using this:
//    Point(int x, int y){
//        thix.x = x;
//        this.y = y;
//    }
    Point(Point point){
        x = point.x;
        y = point.getY();
    }

    void showCoordinates() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    void movePoint(int right, int up){
        int x1 = x + right;
        int y1 = y + up;
        System.out.println("After moving " + right + " right and " + up +
                " new location of point is: \n" + "(" + x1 + ", " + y1 + ")");
    }

    int getX() {
        return x;
    }
    int getY() {
        return y;
    }

    void setX(int corX){
        x = corX;
    }
    void setY(int corY){
        y = corY;
    }
    void setXY(int corX, int corY){
        x = corX;
        y = corY;
    }

    void setXY(Point point){
        x = point.x;
        y = point.y;
    }

    Point getCorXY(){
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }
}

