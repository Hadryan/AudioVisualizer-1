package Main;

import Controller.VisualController;


public class Main {
  public void visualController() {
    String[] args = {"MAIN"};
    processing.core.PApplet.runSketch(args, new VisualController());
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.visualController();
  }
}
