import java.util.*;

public class Day18 {
    // Two instance variables: stack one for your stack, queue and one for your queue
    Stack<Character> myStack = new Stack<>();
    Queue<Character> myQueue = new LinkedList<>();

    void pushCharacter(char c) {
        myStack.push(c);
    }

    void enqueueCharacter(char c) {
        myQueue.add(c);
    }

    char popCharacter() {
        return myStack.pop();
    }

    char dequeCharacter() {
        return myQueue.remove();
    }

    boolean isStringPalindrome(String inputString) {
        // convert input string into an array of characters
        char[] s = inputString.toCharArray();

        // create a solution object
        Day18 day18 = new Day18();

        // enqueue and push all characters into their respective data structures
        for (char c : s) {
            day18.pushCharacter(c);
            day18.enqueueCharacter(c);
        }

        // pop and dequeue the characters at the head of both data structures and compare them
        boolean isPalindrome = true;
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (day18.popCharacter() != day18.dequeCharacter()) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();

        Day18 day18 = new Day18();

        boolean isPalindrome = day18.isStringPalindrome(inputString);

        System.out.println("The word, " + inputString + ", is" + ((!isPalindrome) ? " not a palindrome." : " a palindrome"));


    }
}

