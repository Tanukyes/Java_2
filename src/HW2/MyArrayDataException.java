package HW2;

public class MyArrayDataException extends Exception {
    int errX;
    int errY;

    public MyArrayDataException(int x, int y) {
        super();
        this.errX = x;
        this.errY = y;
    }

    String getError() {
        return "Ошибка в [" + errX + " , " + errY + "] ";
    }

}
