package Visuals.background;

import Controller.VisualController;

public class Background extends AudioController {
  private float halfWidth, halfHeight;

  public void settings() {
    size(1024, 700, P3D);
    smooth(4);
  }

  public void setup() {
    halfWidth = width / 2;
    halfHeight = height / 2;
  }

  public void draw() {
    background(0);
    stroke(0);
    noFill();

    int size = 50;
    int offset = 50;
    float sum = 0;
    int lineHeight = 70;

    fill(255);

    beginShape();
    vertex(halfWidth, 0);
    vertex(halfWidth, halfHeight - size);
    vertex(halfWidth - size, halfHeight + size);
    vertex(0, height - lineHeight);
    vertex(0, 0);
    vertex(halfWidth, 0);
    endShape();

    beginShape();
    vertex(halfWidth, 0);
    vertex(halfWidth, halfHeight - size);
    vertex(halfWidth + size, halfHeight + size);
    vertex(width, height - lineHeight);
    vertex(width, 0);
    vertex(halfWidth, 0);
    endShape();

    beginShape();
    vertex(halfWidth - size, halfHeight + size);
    vertex(halfWidth + size, halfHeight + size);
    vertex(width, height - lineHeight);
    vertex(width, height);
    vertex(0, height);
    vertex(0, height - lineHeight);
    vertex(halfWidth - size, halfHeight + size);
    endShape();

    pushMatrix();
    translate(halfWidth, halfHeight);
    for (int i = 0; i < 25; i++) {
      line(-(size + offset * i), size + (offset / 2 * i), 0, -(size + (offset * i)));
      line(0, -(size + (offset * i)), size + (offset * i), size + (offset / 2 * i));
      line(size + (offset * i), size + (offset / 2 * i), -(size + offset * i),
          size + (offset / 2 * i));
    }
    popMatrix();
  }
}
