package Visuals.particles;

import processing.core.PApplet;
import processing.core.PVector;

public class Particle {
  private PVector coordinates;
  private PVector acceleration;

  private float life;
  private float circleWidth;

  private int time = 0;
  private float amplitude;

  protected final PApplet processing;

  public Particle(PApplet processing, float x, float y, float acceleration) {
    coordinates = new PVector(x, y);
    this.acceleration = new PVector(0, -acceleration);
    this.processing = processing;
    life = processing.random(30, 300);
    circleWidth = processing.random(1, 10);
    amplitude = processing.random(0, 1);
  }

  public float getX() {
    return coordinates.x;
  }

  public float getY() {
    return coordinates.y;
  }

  public PVector getCoordinates() {
    return coordinates;
  }

  public float getAcceleration() {
    return acceleration.y;
  }

  public void setAcceleration(double newAcceleration) {
    if (newAcceleration < 0) {
      newAcceleration *= -1;
    }
    acceleration.set(0, (float) -newAcceleration);
  }

  public void increaseAcceleration(float increment) {
    acceleration.add(0, increment);
  }

  public void decreaseAcceleration(float decrement) {
    acceleration.sub(0, decrement);
  }

  public boolean isDead() {
    return life >= 500;
  }

  public void update() {
    life++;
    if (processing.frameCount % 60 == 0) {
      amplitude = PApplet.lerp(amplitude, processing.random(0, 1), .4f);
    }

    time++;
    move();
    display();
  }

  public void move() {
    coordinates.add(acceleration);

    float xPos = amplitude * PApplet.sin(2 * PApplet.PI * .1f * time * PApplet.radians(3));

    coordinates.add(xPos, 0);
  }

  public void display() {
    processing.colorMode(PApplet.HSB);
    processing.noStroke();
    processing.fill(255, 0, PApplet.map(life, 50, 500, 0, 255));
    processing.ellipse(coordinates.x, coordinates.y, circleWidth, circleWidth);
  }
}
