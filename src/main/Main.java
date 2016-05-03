package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import util.Tries;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileLoc = "/home/sundaramtiwari/Documents/CodeEval/trieTree.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileLoc));
        String[] words = br.readLine().split(", ");
        Tries trie = new Tries();

        for (int i = 0; i < words.length; i++) {
            try {
                trie.addWordToTrie(words[i]);
            } catch (Exception e) {
                System.out.println("Unable to add word: " + words[i]);
            }
        }

        /*
         * TrieUtil.addWordToTrie("unabandon", root); TrieUtil.addWordToTrie("unabandoned", root); TrieUtil.addWordToTrie("unabased", root); TrieUtil.addWordToTrie("unabashed", root);
         * TrieUtil.addWordToTrie("unabasht", root); TrieUtil.addWordToTrie("unabating", root);
         */

        List<String> suggest = trie.suggest("unabo");
        for (String str : suggest) {
            System.out.println(str);
        }
    }

}
