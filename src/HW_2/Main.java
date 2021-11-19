package HW_2;


public class Main {
    public static void main(String[] args) {
        try {
            int sum = sumArray(new String[][]{
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "0", "1", "2"},
                    {"3", "4", "5", "6"},
            });
            System.out.println("Результат: " + sum);
        } catch (MySizeArrayException e) {
            e.printStackTrace();
            System.out.println("Ошибка размера массива");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getError());
        }
    }

    public static int sumArray(String[][] toSum) throws MyArrayDataException, MySizeArrayException {
        if (toSum.length != 4) {
            throw new MySizeArrayException();
        }
        for (String[] stringArray : toSum) {
            if (stringArray.length != 4) {
                throw new MySizeArrayException();
            }
        }
        int sum = 0;
        for (int i = 0; i < toSum.length; i++) {
            for (int j = 0; j < toSum[i].length; j++) {
                try {
                    sum += Integer.parseInt(toSum[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

