package Controller;

public class AudioException extends Throwable {
  private static final long serialVersionUID = 1L;

  private String message;

  public AudioException(String message) {
    this.message = message;
  }

  public String toString() {
    return message;
  }
}
