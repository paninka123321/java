package events;

import ui.AppWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandling implements KeyListener {

    private AppWindow okno;

    public KeyboardHandling(AppWindow okno) {
        this.okno = okno;
    }

    @Override
    public void keyTyped(KeyEvent e){
        System.out.println("Naciśnięto znak: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e){
        System.out.println("Wciśnięto klawisz (kod): " + e.getKeyCode());
        okno.zwiekszKliknieciaKlawiszy();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Zwolniono klawisz: " + e.getKeyChar());
    }
}
