package DataStructure.Trie;

import java.util.Locale;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        if(key == null) {
            System.out.println("Null keys are not allowed");
            return;
        }

        //Keys are stored in lowercase
        key = key.toLowerCase();
        //Start with root
        TrieNode currentNode = this.root;
        for (int level = 0; level < key.length(); level++) {
            //find the index of the characters
            int index = getIndex(key.charAt(level));
            //if that index-th node is absent, create that child node
            if(currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            //continue the flow from that node
            currentNode = currentNode.children[index];
        }
        //mark the endOfWord
        currentNode.markAsLeaf();
    }

    private int getIndex(char x) {
        return x - 'a';
    }

    public boolean search(String key) {
        if(key == null) return false;

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        for (int i = 0; i < key.length(); i++) {
            int index = getIndex(key.charAt(i));
            if(currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndWord;
    }

    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++){
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length) {
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        } else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord) {
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)) {
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            } else {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
}
