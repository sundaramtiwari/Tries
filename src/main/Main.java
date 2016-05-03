package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import util.TrieUtil;
import entity.Node;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileLoc = "/home/sundaramtiwari/Documents/CodeEval/trieTree.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileLoc));
        String[] words = br.readLine().split(", ");
        Node root = new Node();

        for (int i = 0; i < words.length; i++) {
            try {
                root.addWord(words[i]);
            } catch (Exception e) {
                System.out.println("Unable to add word: " + words[i]);
            }
        }

        /*
         * TrieUtil.addWordToTrie("unabandon", root); TrieUtil.addWordToTrie("unabandoned", root); TrieUtil.addWordToTrie("unabased", root); TrieUtil.addWordToTrie("unabashed", root);
         * TrieUtil.addWordToTrie("unabasht", root); TrieUtil.addWordToTrie("unabating", root);
         */

        List<String> suggest = TrieUtil.suggest("unabo", root);
        for (String str : suggest) {
            System.out.println(str);
        }
    }

}
