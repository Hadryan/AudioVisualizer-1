package Visuals.particles;

import processing.core.PApplet;

import java.util.ArrayList;

import Controller.VisualController;

public class ParticlesSystem {
  private ArrayList<Particle> particles;

  private VisualController vc;

  public ParticlesSystem(VisualController vc) {
    this.vc = vc;

    particles = new ArrayList<Particle>();

    for (int i = 0; i < 500; i++) {
      addParticle();
    }
  }

  public void addParticle() {
    float xPos = vc.random(0, vc.width);
    particles.add(new Particle(vc, xPos, vc.height + 10, vc.random(0.2f, 1)));
  }

  public void keyPressed() {
    if (vc.key == ' ') {
      vc.playAudio();
    }
  }

  public void display() {
    vc.calculateAverageAmplitude();

    for (int i = particles.size() - 1; i >= 0; i--) {
      double temp = particles.get(i).getAcceleration();
      Particle currParticle = particles.get(i);

      currParticle.increaseAcceleration(-(vc.getAmplitude() * 10));
      currParticle.update();
      currParticle.setAcceleration(temp);

      if (currParticle.isDead() == true) {
        particles.remove(i);
        addParticle();
      }
    }
  }
}
