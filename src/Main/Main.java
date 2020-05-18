package Main;

import Visuals.particles.ParticlesSystem;
import Visuals.cube.Cube;

public class Main {
  public void particles() {
    String[] args = {"MAIN"};
    processing.core.PApplet.runSketch(args, new ParticlesSystem());
  }

  public void cube() {
    String[] args = {"MAIN"};
    processing.core.PApplet.runSketch(args, new Cube());
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.cube();
  }
}
