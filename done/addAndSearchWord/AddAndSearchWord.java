package addAndSearchWord;

// Source : https://leetcode.com/problems/add-and-search-word-data-structure-design/
// Author : Hao Chen & Jared Koontz
// Date   : 2015-06-10

/**********************************************************************************
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters `a-z` or `.`
 * A `.` means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * click to show hint.
 *
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 **********************************************************************************/
public class AddAndSearchWord {
    public static void main(String[] a) {
        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();
        addAndSearchWord.run();
    }

    private void run() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // -> false
        System.out.println(wordDictionary.search("bad")); // -> true
        System.out.println(wordDictionary.search(".ad")); // -> true
        System.out.println(wordDictionary.search("b..")); // -> true
    }
}
