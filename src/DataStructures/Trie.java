package DataStructures;

import java.util.*;

public class Trie {
        Node root;
        /** Initialize your data structure here. */
        class Node{
            char c;
            boolean isWord;
            boolean hasWord;
            Map<Character,Node> children;
        }
        public Trie() {
            root = new Node();
            root.children = new HashMap<>();
            root.isWord = false;
            root.hasWord= true;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node current = root;
            boolean flag = true;
            for (int i=0;i<word.length();i++){
                char key = word.charAt(i);
                if (flag){
                    if (current.children.containsKey(key)){
                        current = current.children.get(key);
                        current.hasWord = true;
                    }
                    else{
                        flag = false;
                    }
                }
                if(!flag){
                    Node node = new Node();
                    node.children = new HashMap<>();
                    node.isWord = false;
                    node.hasWord = true;
                    node.c = key;
                    current.children.put(key,node);
                    current = node;
                }
            }
            current.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node current = root;
            for (int i=0;i<word.length();i++){
                char key = word.charAt(i);
                if (current.children.containsKey(key)){
                    current = current.children.get(key);
                }
                else{
                    return false;
                }
            }
            return current.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node current = root;
            for (int i=0;i<prefix.length();i++){
                char key = prefix.charAt(i);
                if (current.children.containsKey(key)){
                    current = current.children.get(key);
                }
                else{
                    return false;
                }
            }
            return current.hasWord;
        }

}
