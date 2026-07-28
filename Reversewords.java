public class ReverseWords {

    public static String reverseWords(String s) {
    
        if (s == null || s.trim().isEmpty()) {
            return s;
        }
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "reverse words in a string";
        System.out.println("Original: " + input);
        
        String result = reverseWords(input);
        System.out.println("Reversed: " + result);
    }
}
