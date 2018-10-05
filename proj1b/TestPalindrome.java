import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the auto grader might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String[] test = {"", "a", "nurses run", "strange", "repaper"};
        assertTrue(palindrome.isPalindrome(test[0]));
        assertTrue(palindrome.isPalindrome(test[1]));
        assertTrue(palindrome.isPalindrome(test[2]));
        assertFalse(palindrome.isPalindrome(test[3]));
        assertTrue(palindrome.isPalindrome(test[4]));
    }

    @Test
    public void testIsPalindrome2(){
        String[] test = {"", "a", "flake", "strange", "Flake", "elakf"};
        assertTrue(palindrome.isPalindrome(test[0], offByOne));
        assertTrue(palindrome.isPalindrome(test[1], offByOne));
        assertTrue(palindrome.isPalindrome(test[2], offByOne));
        assertFalse(palindrome.isPalindrome(test[3], offByOne));
        assertFalse(palindrome.isPalindrome(test[4], offByOne));
        assertTrue(palindrome.isPalindrome(test[5], offByOne));
    }
}
