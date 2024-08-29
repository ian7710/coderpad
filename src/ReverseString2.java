public class ReverseString2 {
    public static String reverse(String s){

        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
