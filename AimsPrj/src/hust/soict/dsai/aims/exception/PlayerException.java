package hust.soict.dsai.aims.exception;

public class PlayerException extends Exception {
    // Constructor không tham số
    public PlayerException() {
        super();
    }

    // Constructor có thông báo lỗi
    public PlayerException(String message) {
        super(message);
    }
}