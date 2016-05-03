package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import util.Tries;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream stream = Main.class.getResourceAsStream("/resources/tries.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String[] words = br.readLine().split(", ");
        Tries trie = new Tries();

        for (int i = 0; i < words.length; i++) {
            try {
                trie.addWordToTrie(words[i]);
            } catch (Exception e) {
                System.out.println("Unable to add word: " + words[i]);
            }
        }

        List<String> suggest = trie.suggest("unag");

        for (String str : suggest) {
            System.out.println(str);
        }

        /*BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(buffer.readLine());
        Tries trie = new Tries();
        String[] line;
        
        for (int i=0; i < lines; i++) {
            line = buffer.readLine().split(" ");
            if (line[0].equals("add")) {
                trie.addWordToTrie(line[1]);
            } else if (line[0].equals("find")) {
                System.out.println(trie.suggest(line[1]).size());
            }
        }*/
    }

}
