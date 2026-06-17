/*
 * Unit tests for App.java
 */
package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AppTest {
    
    // Tests for add()
    @Test
    void testAddPositiveNumbers() {
        assertEquals(5, App.add(2, 3));
    }
    
    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, App.add(-2, -3));
    }
    
    @Test
    void testAddMixedNumbers() {
        assertEquals(1, App.add(5, -4));
    }
    
    @Test
    void testAddZero() {
        assertEquals(5, App.add(5, 0));
        assertEquals(0, App.add(0, 0));
    }
    
    @Test
    void testAddLargeNumbers() {
        assertEquals(2000000000, App.add(1000000000, 1000000000));
    }
    
    @Test
    void testAddBothNegativeAndPositive() {
        assertEquals(0, App.add(-5, 5));
        assertEquals(-10, App.add(-5, -5));
    }
    
    @Test
    void testAddIntegerOverflow() {
        // Integer overflow: silently wraps around
        int result = App.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, result);
    }
    
    @Test
    void testAddIntegerUnderflow() {
        // Integer underflow: silently wraps around
        int result = App.add(Integer.MIN_VALUE, -1);
        assertEquals(Integer.MAX_VALUE, result);
    }
    
    // Tests for isPrime()
    @Test
    void testIsPrimeWithPrimeNumbers() {
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(3));
        assertTrue(App.isPrime(5));
        assertTrue(App.isPrime(17));
        assertTrue(App.isPrime(97));
    }
    
    @Test
    void testIsPrimeWithNonPrimeNumbers() {
        assertFalse(App.isPrime(4));
        assertFalse(App.isPrime(9));
        assertFalse(App.isPrime(15));
        assertFalse(App.isPrime(100));
    }
    
    @Test
    void testIsPrimeWithNegativeAndZero() {
        assertFalse(App.isPrime(-5));
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(1));
    }
    
    @Test
    void testIsPrimeEdgeCaseTwo() {
        assertTrue(App.isPrime(2));  // Only even prime
    }
    
    @Test
    void testIsPrimeLargeNumbers() {
        assertTrue(App.isPrime(7919));   // Known large prime
        assertFalse(App.isPrime(7920));  // Not prime
    }
    
    // Tests for reverse()
    @Test
    void testReverseString() {
        assertEquals("olleh", App.reverse("hello"));
        assertEquals("abc", App.reverse("cba"));
    }
    
    @Test
    void testReverseEmptyString() {
        assertEquals("", App.reverse(""));
    }
    
    @Test
    void testReverseSingleCharacter() {
        assertEquals("a", App.reverse("a"));
    }
    
    @Test
    void testReversePalindrome() {
        assertEquals("racecar", App.reverse("racecar"));
    }
    
    @Test
    void testReverseWithSpecialCharacters() {
        assertEquals("!dlrow", App.reverse("world!"));
        assertEquals("321", App.reverse("123"));
    }
    
    @Test
    void testReverseWithSpaces() {
        assertEquals("dlrow olleH", App.reverse("Hello world"));
    }
    
    @Test
    void testReverseNull() {
        assertThrows(NullPointerException.class, () -> App.reverse(null));
    }
    
    // Tests for factorial()
    @Test
    void testFactorialPositiveNumbers() {
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
        assertEquals(2, App.factorial(2));
        assertEquals(6, App.factorial(3));
        assertEquals(24, App.factorial(4));
        assertEquals(120, App.factorial(5));
        assertEquals(3628800, App.factorial(10));
    }
    
    @Test
    void testFactorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-10));
    }
    
    @Test
    void testFactorialLargeNumbers() {
        assertEquals(39916800, App.factorial(11));
        assertEquals(479001600, App.factorial(12));
    }
    
    @Test
    void testFactorialIntegerOverflow() {
        // factorial(13) and beyond cause integer overflow
        // 13! = 6,227,020,800 which exceeds Integer.MAX_VALUE
        // The result will be incorrect due to overflow
        int result = App.factorial(13);
        // Just verify it's computed (behavior depends on JVM, but it will be computed)
        assertNotEquals(App.factorial(12), result);
    }
    
    // Tests for isPalindrome()
    @Test
    void testIsPalindromeWithValidPalindromes() {
        assertTrue(App.isPalindrome("racecar"));
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(App.isPalindrome("a"));
        assertTrue(App.isPalindrome("aa"));
    }
    
    @Test
    void testIsPalindromeWithNonPalindromes() {
        assertFalse(App.isPalindrome("hello"));
        assertFalse(App.isPalindrome("world"));
        assertFalse(App.isPalindrome("ab"));
    }
    
    @Test
    void testIsPalindromeWithSpecialCharacters() {
        assertTrue(App.isPalindrome("A1a"));
        assertTrue(App.isPalindrome("12321"));
    }
    
    @Test
    void testIsPalindromeEmptyString() {
        assertTrue(App.isPalindrome(""));  // Empty string is palindrome
    }
    
    @Test
    void testIsPalindromeWithNumbers() {
        assertTrue(App.isPalindrome("121"));
        assertTrue(App.isPalindrome("1221"));
        assertFalse(App.isPalindrome("123"));
    }
    
    @Test
    void testIsPalindromeMultipleSpacesAndPunctuation() {
        assertTrue(App.isPalindrome("A1 B1 a"));
        assertTrue(App.isPalindrome("race e car"));
    }
    
    @Test
    void testIsPalindromeNull() {
        assertThrows(NullPointerException.class, () -> App.isPalindrome(null));
    }
    
    // Tests for fibonacciUpTo()
    @Test
    void testFibonacciUpToPositive() {
        List<Integer> fib10 = App.fibonacciUpTo(10);
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), fib10);
        
        List<Integer> fib1 = App.fibonacciUpTo(1);
        assertEquals(Arrays.asList(0, 1, 1), fib1);
    }
    
    @Test
    void testFibonacciUpToZero() {
        List<Integer> fib0 = App.fibonacciUpTo(0);
        assertEquals(Arrays.asList(0), fib0);
    }
    
    @Test
    void testFibonacciUpToNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1));
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-10));
    }
    
    @Test
    void testFibonacciUpToLargerLimit() {
        List<Integer> fib100 = App.fibonacciUpTo(100);
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89), fib100);
    }
    
    @Test
    void testFibonacciUpToLargeLimit() {
        List<Integer> fib1000 = App.fibonacciUpTo(1000);
        assertTrue(fib1000.contains(987));  // Last Fibonacci number <= 1000
        assertFalse(fib1000.contains(1597)); // Next Fibonacci number > 1000
    }
    
    // Tests for charFrequency()
    @Test
    void testCharFrequencySimpleString() {
        Map<Character, Integer> freq = App.charFrequency("hello");
        assertEquals(1, freq.get('h'));
        assertEquals(1, freq.get('e'));
        assertEquals(2, freq.get('l'));
        assertEquals(1, freq.get('o'));
    }
    
    @Test
    void testCharFrequencyRepeatedCharacters() {
        Map<Character, Integer> freq = App.charFrequency("aaa");
        assertEquals(3, freq.get('a'));
        assertEquals(1, freq.size());
    }
    
    @Test
    void testCharFrequencyEmptyString() {
        Map<Character, Integer> freq = App.charFrequency("");
        assertEquals(0, freq.size());
    }
    
    @Test
    void testCharFrequencyWithSpaces() {
        Map<Character, Integer> freq = App.charFrequency("a b a");
        assertEquals(2, freq.get('a'));
        assertEquals(2, freq.get(' '));
        assertEquals(1, freq.get('b'));
    }
    
    @Test
    void testCharFrequencyWithNumbers() {
        Map<Character, Integer> freq = App.charFrequency("a1b1c");
        assertEquals(1, freq.get('a'));
        assertEquals(2, freq.get('1'));
        assertEquals(1, freq.get('b'));
        assertEquals(1, freq.get('c'));
    }
    
    @Test
    void testCharFrequencyWithSpecialCharacters() {
        Map<Character, Integer> freq = App.charFrequency("!@!#");
        assertEquals(2, freq.get('!'));
        assertEquals(1, freq.get('@'));
        assertEquals(1, freq.get('#'));
    }
    
    @Test
    void testCharFrequencySingleCharacter() {
        Map<Character, Integer> freq = App.charFrequency("x");
        assertEquals(1, freq.get('x'));
        assertEquals(1, freq.size());
    }
    
    @Test
    void testCharFrequencyNull() {
        assertThrows(NullPointerException.class, () -> App.charFrequency(null));
    }
    
    // Tests for isAnagram()
    @Test
    void testIsAnagramValidAnagrams() {
        assertTrue(App.isAnagram("listen", "silent"));
        assertTrue(App.isAnagram("evil", "vile"));
        assertTrue(App.isAnagram("abc", "cba"));
    }
    
    @Test
    void testIsAnagramNonAnagrams() {
        assertFalse(App.isAnagram("hello", "world"));
        assertFalse(App.isAnagram("cat", "dog"));
    }
    
    @Test
    void testIsAnagramWithSpaces() {
        assertTrue(App.isAnagram("the eyes", "they see"));
    }
    
    @Test
    void testIsAnagramCaseInsensitive() {
        assertTrue(App.isAnagram("Listen", "Silent"));
    }
    
    @Test
    void testIsAnagramEmptyStrings() {
        assertTrue(App.isAnagram("", ""));
    }
    
    @Test
    void testIsAnagramSingleCharacter() {
        assertTrue(App.isAnagram("a", "a"));
        assertFalse(App.isAnagram("a", "b"));
    }
    
    @Test
    void testIsAnagramWithNumbers() {
        assertTrue(App.isAnagram("123", "321"));
        assertFalse(App.isAnagram("123", "124"));
    }
    
    @Test
    void testIsAnagramDifferentLengths() {
        assertFalse(App.isAnagram("abc", "abcd"));
        assertFalse(App.isAnagram("hello", "helo"));
    }
    
    @Test
    void testIsAnagramNull() {
        assertThrows(NullPointerException.class, () -> App.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> App.isAnagram("test", null));
    }
    
    @Test
    void testIsAnagramBothNull() {
        assertThrows(NullPointerException.class, () -> App.isAnagram(null, null));
    }
    
    // Tests for average()
    @Test
    void testAverageSimpleArray() {
        assertEquals(3.0, App.average(new int[]{1, 2, 3, 4, 5}));
        assertEquals(2.5, App.average(new int[]{1, 2, 3, 4}));
    }
    
    @Test
    void testAverageSingleElement() {
        assertEquals(5.0, App.average(new int[]{5}));
    }
    
    @Test
    void testAverageWithZero() {
        assertEquals(0.0, App.average(new int[]{0, 0, 0}));
    }
    
    @Test
    void testAverageEmptyArrayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{}));
    }
    
    @Test
    void testAverageNegativeNumbers() {
        assertEquals(-3.0, App.average(new int[]{-1, -2, -3, -4, -5}));
        assertEquals(-2.0, App.average(new int[]{-5, 1}));
    }
    
    @Test
    void testAverageDecimalResult() {
        assertEquals(2.5, App.average(new int[]{2, 3}));
        assertEquals(1.6666666666666667, App.average(new int[]{1, 2, 2}));
    }
    
    @Test
    void testAverageLargeNumbers() {
        assertEquals(500000000.0, App.average(new int[]{1000000000, 0}));
    }
    
    @Test
    void testAverageNull() {
        assertThrows(NullPointerException.class, () -> App.average(null));
    }
    
    // Tests for filterEvens()
    @Test
    void testFilterEvensWithMixedNumbers() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(2, 4, 6), result);
    }
    
    @Test
    void testFilterEvensWithAllOddNumbers() {
        List<Integer> input = Arrays.asList(1, 3, 5);
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(), result);
    }
    
    @Test
    void testFilterEvensWithAllEvenNumbers() {
        List<Integer> input = Arrays.asList(2, 4, 6);
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(2, 4, 6), result);
    }
    
    @Test
    void testFilterEvensEmptyList() {
        List<Integer> input = Arrays.asList();
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(), result);
    }
    
    @Test
    void testFilterEvensWithNegativeNumbers() {
        List<Integer> input = Arrays.asList(-1, -2, -3, -4);
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(-2, -4), result);
    }
    
    @Test
    void testFilterEvensWithZero() {
        List<Integer> input = Arrays.asList(0, 1, 2);
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(0, 2), result);
    }
    
    @Test
    void testFilterEvensLargeNumbers() {
        List<Integer> input = Arrays.asList(1000000, 1000001, 1000002);
        List<Integer> result = App.filterEvens(input);
        assertEquals(Arrays.asList(1000000, 1000002), result);
    }
    
    @Test
    void testFilterEvensNull() {
        assertThrows(NullPointerException.class, () -> App.filterEvens(null));
    }
    
    // Tests for mostCommonWord()
    @Test
    void testMostCommonWordSimpleText() {
        String text = "hello world hello";
        assertEquals("hello", App.mostCommonWord(text));
    }
    
    @Test
    void testMostCommonWordCaseInsensitive() {
        String text = "The the THE";
        assertEquals("the", App.mostCommonWord(text));
    }
    
    @Test
    void testMostCommonWordWithPunctuation() {
        String text = "hello, hello, world!";
        assertEquals("hello", App.mostCommonWord(text));
    }
    
    @Test
    void testMostCommonWordSingleWord() {
        String text = "hello";
        assertEquals("hello", App.mostCommonWord(text));
    }
    
    @Test
    void testMostCommonWordMultipleSpaces() {
        String text = "cat  cat   dog";  // Multiple spaces
        assertEquals("cat", App.mostCommonWord(text));
    }
    
    @Test
    void testMostCommonWordAllUniqueWords() {
        // When there's a tie, max() returns one of them
        String text = "apple banana cherry";
        // The function returns one of them (implementation dependent)
        String result = App.mostCommonWord(text);
        assertTrue(result.equals("apple") || result.equals("banana") || result.equals("cherry"));
    }
    
    @Test
    void testMostCommonWordNull() {
        assertThrows(NullPointerException.class, () -> App.mostCommonWord(null));
    }
    
    @Test
    void testMostCommonWordEmptyString() {
        // Empty string produces an empty string as the only word
        // mostCommonWord will return that empty string
        String result = App.mostCommonWord("");
        assertEquals("", result);
    }
    
    @Test
    void testMostCommonWordOnlyPunctuation() {
        // "!!!" produces only empty strings after split
        // mostCommonWord tries to find max, but empty strings don't have a meaningful max
        assertThrows(java.util.NoSuchElementException.class, () -> App.mostCommonWord("!!!???"));
    }
    
    @Test
    void testMostCommonWordTieBreaker() {
        // Two words with same frequency - result is unpredictable
        String text = "apple apple banana banana";  // Both appear twice
        String result = App.mostCommonWord(text);
        // One of them will be returned (implementation/iteration order dependent)
        assertTrue(result.equals("apple") || result.equals("banana"));
    }
    
    @Test
    void testMostCommonWordMixedCase() {
        String text = "Hello HELLO hello";
        assertEquals("hello", App.mostCommonWord(text));
    }
    
    @Test
    void testMostCommonWordWithNumbers() {
        String text = "123 456 123";
        assertEquals("123", App.mostCommonWord(text));
    }
}
