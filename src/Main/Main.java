package Main;

import Visuals.particles.ParticlesSystem;
import Controller.VisualController;


public class Main {
  public void particles() {
    String[] args = {"MAIN"};
    processing.core.PApplet.runSketch(args, new ParticlesSystem());
  }

  public void visualController() {
    String[] args = {"MAIN"};
    processing.core.PApplet.runSketch(args, new VisualController());
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.visualController();
  }
}
