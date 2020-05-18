package Visuals.particles;

import Controller.AudioController;

import java.util.ArrayList;

public class ParticlesSystem extends AudioController {
  private ArrayList<Particle> particles;

  private float circleAcceleration = 0;
  private float lerpedCircleAcceleration = 0;

  public void settings() {
    size(1024, 700);
  }

  public void setup() {
    colorMode(HSB);

    setFrameSize(1024);
    startMinim();
    loadAudio("All My Friends.mp3");
    playAudio();

    particles = new ArrayList<Particle>();

    for (int i = 0; i < 500; i++) {
      addParticle();
    }
  }

  public void addParticle() {
    float xPos = random(0, width);
    particles.add(new Particle(this, xPos, height + 10, random(0.2f, 1)));
  }

  public void keyPressed() {
    if (key == ' ') {
      playAudio();
    }
  }

  public void draw() {
    background(0);

    float sum = 0;

    for (int i = 0; i < getAudioPlayer().bufferSize(); i++) {
      sum += abs(getAudioBuffer().get(i));
    }

    circleAcceleration = sum / getAudioPlayer().bufferSize();
    circleAcceleration *= 10000;

    calculateAverageAmplitude();

    for (int i = particles.size() - 1; i >= 0; i--) {
      double temp = particles.get(i).getAcceleration();
      Particle currParticle = particles.get(i);

      float mappedCircleAcceleration = map(circleAcceleration, 0f, 200, .2f, 1.5f);
      float lerpedCircleAcceleration =
          lerp((float) temp, (float) temp + mappedCircleAcceleration, .3f);


      println(-(getAmplitude() * 10));
      currParticle.increaseAcceleration(-(getAmplitude() * 10));
      currParticle.update();
      currParticle.setAcceleration(temp);

      if (currParticle.isDead() == true) {
        particles.remove(i);
        addParticle();
      }
    }
  }
}
