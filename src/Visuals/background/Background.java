package Visuals.background;

import Controller.VisualController;

public class Background {
  VisualController vc;
  private float colorOffset = 0;

  public Background(VisualController vc) {
    this.vc = vc;
  }

  public void display() {
    vc.stroke(0);

    int size = 50;
    int offset = 50;
    int lineHeight = 7;

    vc.fill(255);

    vc.beginShape();
    vc.vertex(vc.getHalfWidth(), 0);
    vc.vertex(vc.getHalfWidth(), vc.getHalfHeight() - size);
    vc.vertex(vc.getHalfWidth() - size, vc.getHalfHeight() + size);
    vc.vertex(0, vc.height - lineHeight);
    vc.vertex(0, 0);
    vc.vertex(vc.getHalfWidth(), 0);
    vc.endShape();

    vc.beginShape();
    vc.vertex(vc.getHalfWidth(), 0);
    vc.vertex(vc.getHalfWidth(), vc.getHalfHeight() - size);
    vc.vertex(vc.getHalfWidth() + size, vc.getHalfHeight() + size);
    vc.vertex(vc.width, vc.height - lineHeight);
    vc.vertex(vc.width, 0);
    vc.vertex(vc.getHalfWidth(), 0);
    vc.endShape();

    vc.beginShape();
    vc.vertex(vc.getHalfWidth() - size, vc.getHalfHeight() + size);
    vc.vertex(vc.getHalfWidth() + size, vc.getHalfHeight() + size);
    vc.vertex(vc.width, vc.height - lineHeight);
    vc.vertex(vc.width, vc.height);
    vc.vertex(0, vc.height);
    vc.vertex(0, vc.height - lineHeight);
    vc.vertex(vc.getHalfWidth() - size, vc.getHalfHeight() + size);
    vc.endShape();

    vc.pushMatrix();
    vc.translate(vc.getHalfWidth(), vc.getHalfHeight());

    for (int i = 0; i < 25; i++) {
      vc.stroke(((255 / 25 * i) + colorOffset) % 255, 255, 255);
      vc.line(-(size + offset * i), size + (offset / 2 * i), 0, -(size + (offset * i)));
      vc.line(0, -(size + (offset * i)), size + (offset * i), size + (offset / 2 * i));
      vc.line(size + (offset * i), size + (offset / 2 * i), -(size + offset * i),
          size + (offset / 2 * i));
    }
    vc.popMatrix();

    if (vc.getAmplitude() * 50 > 20) {
      colorOffset += vc.getAmplitude() * 50;
    }
  }
}
