package events;

import ui.AppWindow;

import java.awt.event.*;


public class ObslugaMyszy implements MouseListener, MouseMotionListener {
    private AppWindow okno;

    public ObslugaMyszy(AppWindow okno) {
        this.okno = okno;
    }

    @Override //it overrides a method from the parent class or interface
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked in" + e.getX() + "," + e.getY());
        okno.zwiekszKliknieciaMyszy();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Przycisk myszy wciśnięty");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Przycisk myszy zwolniony");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Kursor wszedł w obszar");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Kursor wyszedł z obszaru");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Przeciąganie myszy: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Ruch myszy: " + e.getX() + ", " + e.getY());
        okno.ustawWspolrzedne(e.getX(), e.getY());
    }
}
