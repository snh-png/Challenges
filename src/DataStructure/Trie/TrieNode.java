package DataStructure.Trie;

public class TrieNode {
    public static final int ALPHABET_SIZE = 26;
    //Holds children
    //And marks the last character as endOfWord

    TrieNode[] children;
    boolean isEndWord;

    TrieNode() {
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public void markAsLeaf() {
        this.isEndWord = true;
    }

    public void unMarkAsLeaf() {
        this.isEndWord = false;
    }
}
