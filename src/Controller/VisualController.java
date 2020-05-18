package Controller;

import Visuals.background.Background;

public class VisualController extends AudioController {
  private float halfWidth, halfHeight;
  private Background background;

  public void settings() {
    size(1024, 700);
  }

  public void setup() {
    startMinim();
    loadAudio("All My Friends.mp3");
    background = new Background(this);

    halfWidth = width / 2;
    halfHeight = height / 2;
  }

  public void keyPressed() {
    if (key == ' ') {
      getAudioPlayer().cue(0);
      getAudioPlayer().play();
    }
  }

  public float getHalfWidth() {
    return halfWidth;
  }

  public float getHalfHeight() {
    return halfHeight;
  }

  public void draw() {
    background.display();
  }
}
