package pack03variables;

public class DataTypesInJava {

    /*

        There are two types of Data Types in Java:
        - Primitive.
        - Non-Primitive.

        Primitives:
        - byte < short < int < long < float < double
        - char - boolean

        Non-Primitives:
        - String => as created by Java itself

     */

    public static void main(String[] args) {

        byte maxByteValue = Byte.MAX_VALUE;
        byte minByteValue = Byte.MIN_VALUE;
        System.out.println("maxByteValue: " + maxByteValue);
        System.out.println("minByteValue: " + minByteValue);

        short maxShortValue = Short.MAX_VALUE;
        short minShortValue = Short.MIN_VALUE;
        System.out.println("maxShortValue: " + maxShortValue);
        System.out.println("minShortValue: " + minShortValue);

        int maxIntValue = Integer.MAX_VALUE;
        int minIntValue = Integer.MIN_VALUE;
        System.out.println("maxIntValue: " + maxIntValue);
        System.out.println("minIntValue: " + minIntValue);

        long maxLongValue = Long.MAX_VALUE;
        long minLongValue = Long.MIN_VALUE;
        System.out.println("maxLongValue: " + maxLongValue);
        System.out.println("minLongValue: " + minLongValue);

        float maxFloatValue = Float.MAX_VALUE;
        float minFloatValue = Float.MIN_VALUE;
        System.out.println("maxFloatValue: " + maxFloatValue);
        System.out.println("minFloatValue: " + minFloatValue);

        double maxDoubleValue = Double.MAX_VALUE;
        double minDoubleValue = Double.MIN_VALUE;
        System.out.println("maxDoubleValue: " + maxDoubleValue);
        System.out.println("minDoubleValue: " + minDoubleValue);

        char maxCharValue = Character.MAX_VALUE;//!!!!!!📌 Character!
        char minCharValue = Character.MIN_VALUE;//!!!!!!📌 Character!
        System.out.println("maxCharValue: " + maxCharValue);
        System.out.println("minCharValue: " + minCharValue);

        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println("isTrue: " + isTrue);
        System.out.println("isFalse: " + isFalse);

        String myName = "Ali";
        System.out.println("myName: " + myName);


    }

}
