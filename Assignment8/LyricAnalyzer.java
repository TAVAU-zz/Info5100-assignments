package Assignment8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LyricAnalyzer { // score 4
    private HashMap<String, ArrayList<Integer>> map;

    public LyricAnalyzer() {
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        LyricAnalyzer l = new LyricAnalyzer();
        try {
            l.read(new File("/Users/mana/Documents/GitHub_New/neu-sep17/assignments/Assignment_8/Question2_test1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("unique words: " + l.count());
        System.out.println("most frequently word: " + l.mostFrequentWord());
        System.out.println();
        l.displayWords();
        File newfile = new File("lyrics.txt");
        try {
            l.writeLyrics(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(File file) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int pos = 1;
        String line;
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String[] words = line.toUpperCase().split(" ");
            for (int i = 0; i < words.length; ++i) {
                if (i == words.length - 1) {
                    add(words[i], -pos);
                } else add(words[i], pos);
                pos++;
            }
        }
        br.close();
        fr.close();

    }

    private void add(String lyricWord, int wordPosition) {
        if (!map.containsKey(lyricWord)) {
            ArrayList<Integer> pos=new ArrayList<>();
            pos.add(wordPosition);
            map.put(lyricWord, pos);
        } else {
            map.get(lyricWord).add(wordPosition);
        }
    }

    public void displayWords() {
        String[] words = new String[map.size()];
        map.keySet().toArray(words);
        Arrays.sort(words);
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            sb.append(word).append(": ");
            //enclosed in square brackets ("[]")
            String list = map.get(word).toString();
            sb.append(list.substring(1, list.length() - 1));
            System.out.println(sb.toString());
        }
    }

    public int count() {
        return map.size();
    }

    public String mostFrequentWord() {
        int count = 0;
        String str = "";
        for (String s : map.keySet()) {
            if (map.get(s).size() > count) {
                count = map.get(s).size();
                str = s;
            }
        }
        return str;
    }

    public void writeLyrics(File file) throws IOException {
        int n = 0;
        for (ArrayList<Integer> a : map.values()) {
            n += a.size();
        }
        String[] words = new String[n + 1];
        Arrays.fill(words, "");
        for (String s : map.keySet()) {
            for (Integer i : map.get(s)) {
                if (i < 0) {
                    words[-i] = s.toUpperCase() + " " + "\n";
                } else words[i] = s.toUpperCase() + " ";
            }
        }
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 1; i < words.length; ++i) {
            pw.print(words[i]);
        }
        pw.close();
        fw.close();
    }
}
