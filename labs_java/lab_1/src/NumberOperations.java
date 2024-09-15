import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberOperations {
    public static void main(String[] args) {
        ArrayList<Number> Numbers = new ArrayList<>(Arrays.asList(10.0, 20.5, 30.0, 40.7, 50.0, 60.3, 70.0, 80.1, 90.0, 100.9));
        // Declaring numeric variables
        int IntegerNum = 2;
        float FloatNum = 3.43f;
        byte ByteNum = 1;
        short ShortNum = 2;
        long LongNum = 243234234;
        double DoubleNum = -34243424.3434432;

        List<Integer> IntList = new ArrayList<>();
        List<Float> FloatList = new ArrayList<>();
        List<Byte> ByteList = new ArrayList<>();
        List<Short> ShortList = new ArrayList<>();
        List<Double> DoubleList = new ArrayList<>();
        List<Long> LongList = new ArrayList<>();



        NumberOperations operations = new NumberOperations();
        operations.addToList(Numbers, IntegerNum, FloatNum, ByteNum, ShortNum, LongNum, DoubleNum);
        System.out.println("1. Всі числа: " + Numbers);
        operations.remakeArrayToInt(Numbers);
        operations.remakeArrayToFloat(Numbers);
        operations.addNumByType(DoubleNum, IntList, FloatList, ShortList, ByteList, DoubleList, LongList);
        operations.sumOfSqrt(Numbers);
    }
        // Add numbers to the list
        public void addToList(List<Number> Numbers, int IntegerNum, float FloatNum, byte ByteNum, short ShortNum, long LongNum, double DoubleNum) {
            Numbers.add(DoubleNum);
            Numbers.add(IntegerNum);
            Numbers.add(FloatNum);
            Numbers.add(ByteNum);
            Numbers.add(ShortNum);
            Numbers.add(LongNum);
        }

        // Print the numbers in Integer format
        public void remakeArrayToInt(List<Number> Numbers) {
            for (Number num : Numbers) {
                if (Numbers.indexOf(num) == 0) {
                    System.out.print("  a. Всі числа переведені в Integer: [");
                }
                else if (Numbers.indexOf(num) == Numbers.size() - 1) {
                    System.out.println(num.intValue() + "]");
                }
                else {
                    System.out.print(num.intValue() + ", ");
                }
            }
        }

        // Print the numbers in Float format
        public void remakeArrayToFloat(List<Number> Numbers) {
            for (Number num : Numbers) {
                if (Numbers.indexOf(num) == 0) {
                    System.out.print("  b. Всі числа переведені в Float: [");
                }
                else if (Numbers.indexOf(num) == Numbers.size() - 1) {
                    System.out.println(String.format("%.2f", num.floatValue()) + "]");
                }
                else {
                    System.out.print(String.format("%.2f", num.floatValue()) + ", ");
                }
            }
        }

        // Add numbers to specific lists based on their type
        public void addNumByType(Number number, List<Integer> IntList, List<Float> FloatList, List<Short> ShortList, List<Byte> ByteList, List<Double> DoubleList, List<Long> LongList) {
            System.out.print("2. ");
            if (number instanceof Integer) {
                IntList.add(number.intValue());
                System.out.println("Число додано у список Integer");
            }
            else if (number instanceof Float) {
                FloatList.add(number.floatValue());
                System.out.println("Число додано у список Float");
            }
            else if (number instanceof Short) {
                ShortList.add(number.shortValue());
                System.out.println("Число додано у список Short");
            }
            else if (number instanceof Byte) {
                ByteList.add(number.byteValue());
                System.out.println("Число додано у список Byte");
            }
            else if (number instanceof Double) {
                DoubleList.add(number.doubleValue());
                System.out.println("Число додано у список Double");
            }
            else if (number instanceof Long) {
                LongList.add(number.longValue());
                System.out.println("Число додано у список Long");
            }
        }

        // Method to calculate the sum of the square roots
        public void sumOfSqrt(List<Number> NumberList) {
            double sum = 0.0;
            for (Number num : NumberList) {
                sum += Math.pow(num.doubleValue(), 2);
            }
            System.out.println("3. Сума квадратів елементу списку: " + sum);
        }
}

