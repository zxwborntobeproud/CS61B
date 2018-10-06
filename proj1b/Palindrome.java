public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> charArray= new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            charArray.addLast(word.charAt(i));
        }
        return charArray;
    }

    public boolean isPalindrome(String word){
        if (word.length() <= 1){
            return true;
        }
        LinkedListDeque<Character> charDeque = (LinkedListDeque<Character>) wordToDeque(word);
        String reverse = "";
        for (int i = 0; i < word.length(); i++){
            reverse += charDeque.removeLast();
        }
        word = word.replaceAll("\\s+","");
        reverse = reverse.replaceAll("\\s+","");
        return reverse.equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() <= 1){
            return true;
        } else {
            for (int i = 0; i < word.length() / 2; i++){
                if (!cc.equalChars(word.charAt(i), word.charAt(word.length()-1-i))){
                    return false;
                }
            }
            return true;
        }
    }
}
