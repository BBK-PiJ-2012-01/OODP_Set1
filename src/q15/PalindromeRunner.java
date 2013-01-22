package q15;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 14:30
 */
public class PalindromeRunner {
    public static void main(String[] args) {
        PalindromeTester pt = new PalindromeTester();
        if (pt.isPalindrome("bob"))
            System.out.println("bob is a palindrome");
        else
            System.out.println("bob is not a palindrome");
        if (pt.isPalindrome("amanaplanacanalpanama"))
            System.out.println("amanaplanacanalpanama is a palindrome");
        else
            System.out.println("amanaplanacanalpanama is not a palindrome");
        if (pt.isPalindrome("abcdefghijklmnopqrstuvwxyz"))
            System.out.println("abcdefghijklmnopqrstuvwxyz is a palindrome");
        else
            System.out.println("abcdefghijklmnopqrstuvwxyz is not a palindrome");
    }
}
