public class Main {
    public static void main (String args[]){
        Point firstPoint = new Point();
        firstPoint.x = 100;
        firstPoint.y = 100;
        System.out.println("Point with x = " + firstPoint.x + " and y = " + firstPoint.y);

        Point secondPoint = new Point();
        secondPoint.x = 20;
        secondPoint.y = 2;
        secondPoint.showCoordinates();
        secondPoint.movePoint(3, -4);

        System.out.println(secondPoint.getX());
        System.out.println(secondPoint.getY());

        Point thirdPoint = new Point();
        thirdPoint.setX(secondPoint.x);
        thirdPoint.setY(secondPoint.y);
        thirdPoint.showCoordinates();

        Point fourthPoint = new Point();
        fourthPoint = firstPoint.getCorXY();
        fourthPoint.showCoordinates();

        Point fifthPoint = new Point();
        fifthPoint.setXY(fourthPoint);
        fifthPoint.showCoordinates();

        Point sixthPoint = new Point(secondPoint);
        sixthPoint.showCoordinates();

        Point3D point3D = new Point3D();
        point3D.showCoordinates();
        System.out.println(point3D.z);

        SztucznaInteligencja si = new SztucznaInteligencja("rozmyta");

        // Tworzymy tablicę robotów
        String nazwa = "Abd";
        Robot[] roboty = new Robot[6];
        roboty[0] = new RobotDomowy(si);
        roboty[1] = new RobotDomowy(si);
        roboty[2] = new RobotProdukcja(nazwa, si);
        roboty[3] = new RobotProdukcja(nazwa, si);
        roboty[4] = new RobotSkladanie(nazwa, si);
        roboty[5] = new RobotSkladanie(nazwa, si);

        // Wypisanie na konsolę stanu początkowego robotów
        for (Robot robot : roboty) {
            System.out.println(robot);
            robot.meldunek();
            if (robot instanceof PorozumieniePlus) {
                ((PorozumieniePlus) robot).powitanie();
            }
        }

        // Symulacja zadania
        for (Robot robot : roboty) {
            robot.wykonajZadanie();
        }

        // Wypisanie po wykonaniu zadań
        for (Robot robot : roboty) {
            System.out.println(robot);
        }

        // Porównanie robotów
        if (roboty[0].equals(roboty[1])) {
            System.out.println("Są identyczne roboty");
        } else {
            System.out.println("Brak identycznych robotów");
        }
    }
}

