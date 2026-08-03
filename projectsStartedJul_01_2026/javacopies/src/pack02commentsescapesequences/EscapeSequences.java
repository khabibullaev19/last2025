package pack02commentsescapesequences;

public class EscapeSequences {

    public static void main(String[] args) {

        // Escape sequences are used to write a series of special characters.
        // Each escape sequence character is preceded by a backslash "\"

        // "\n" -> Newline => Advances the cursor to the next line for subsequent:
        System.out.println("This is before escape sequence\nAfter escape sequence");

        // "\t" -> Horizontal Tab => Causes the cursor to skip over to the next tab stop:
        System.out.println("\tHorizontal Tab is used.");

        // "\\" -> Backslash => Causes a backslash to be printed:
        System.out.println("\\ Printing backslash.");

        // ( \"between\" ) -> Double Quote => Causes a double quotation mark to be printed:
        System.out.println("Printing \"Double Quotes\"");

        // "\r" -> Carriage Return => Causes to remove the characters before itself:
        System.out.println("Using\rcarriage return");
        System.out.println("Again using\rcarriage return");

        // ( \'between\' ) -> Single Quote => Causes a single quotation mark to be printed:
        System.out.println("Using \'single quote\'");

        // "\f" -> Page break => Inserts a form feed(new line after itself) in the text at this point.
        // Did not work here!
        System.out.println("Using!\fform feed");

    }

}
