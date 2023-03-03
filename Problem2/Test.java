package Problem2;

public class Test {
    public static void main(String[] args) {
        MapReduce mapReduce = new MapReduce("HELLO THIS IS PROSANTO A EUU DEB");
        mapReduce.startWithVowel();
        mapReduce.sort();
        System.out.println(mapReduce.showOutput());

        System.out.println();

        MapReduce mapReduce2 = new MapReduce("HELLO AN THIS IS PROSANTO A DEB");
        mapReduce2.isArticle();
        mapReduce2.sort();
        System.out.println(mapReduce2.showOutput());
    }
}
