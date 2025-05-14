package ui;

import events.KeyboardHandling;
import events.ObslugaMyszy;



import javax.swing.*; // package which contain JFrame class
import java.awt.*; // to set canva color
import java.awt.event.*; // to use listeners

public class AppWindow extends JFrame{
    // Clas variables, constructor and methods:

    // Displaying text on canva
    private int mouseX = 0;
    private int mouseY = 0;
    private int clickMouse = 0;
    private int clickKeyboard = 0;

    // Adding text field
    private JTextField textField;

    public AppWindow(){ //class constructor
        // methods from JFrame and its parents classes
        setTitle("Empty canva");
        setSize(400, 300);
        // what to do when the window closes:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EXIT_ON_CLOS = System.exit(0); when x button is clicked

        // background:
        getContentPane().setBackground(Color.white);

        // Mouse handling
        ObslugaMyszy mouseHandling = new ObslugaMyszy(this);
        this.addMouseListener(mouseHandling);
        this.addMouseMotionListener(mouseHandling); // this keyword refers to the current instance of AppWindow

        // Keyboard handling
        KeyboardHandling keyboard = new KeyboardHandling(this);
        this.addKeyListener(keyboard);
        this.setFocusable(true); //it allows JFrame to receive keyboard acction
        this.requestFocusInWindow();

        // display window
        setVisible(true);

        // typing handling:
        textField = new JTextField();
        textField.setBounds(20, 50, 200, 30); // pozycja i rozmiar (x, y, szerokość, wysokość)


        KeyboardHandling key = new KeyboardHandling(this);
        textField.addKeyListener(key);

        // Mouse moving handling:

        ObslugaMyszy mouse = new ObslugaMyszy(this);

        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);


        // dodajemy pole tekstowe do okna
        this.setLayout(null); // pozwala na ręczne pozycjonowanie komponentów
        this.add(textField);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        try {
            int sum = clickMouse + clickKeyboard;
            if (sum > 10){
                throw new ClickedSumException("Suma kliknięć przekroczyła 10!");
            }
        } catch (ClickedSumException e){
            clickMouse = 0;
            clickKeyboard = 0;
            System.out.println("Złapano wyjątek: " + e.getMessage());
        } finally {
            g.setColor(Color.BLACK);
            g.drawString("współrzędne myszy: x = " + mouseX + ", y = " + mouseY, 20, 100);
            g.drawString("ilość kliknięć myszy: " + clickMouse, 20, 120);
            g.drawString("ilość kliknięć klawiszy: " + clickKeyboard, 20, 140);
        }

    }

    public void ustawWspolrzedne(int x, int y) {
        this.mouseX = x;
        this.mouseY = y;
        repaint();
    }

    public void zwiekszKliknieciaMyszy() {
        clickMouse++;
        repaint();
    }

    public void zwiekszKliknieciaKlawiszy() {
        clickKeyboard++;
        repaint();
    }


}

