import java.util.Scanner;

public class Main {

    public static boolean czySpolgloska(char litera) {
        switch (litera) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return false;
        }
        return true;
    }

    public static void kodowanie(char[] napis) {
        int dl = napis.length;

        boolean f = true;
        int nr = 0;
        char first = 0;

        for (int i = 0; i < dl; i++) {
            if (czySpolgloska(napis[i])) {
                if (f) {
                    nr = i;
                    first = napis[i];
                    f = false;
                } else {
                    char pom = napis[i];
                    napis[i] = first;
                    first = pom;
                }
            }
        }
        if (!f)
            napis[nr] = first;
    }

    public static void dekodowanie(char[] napis) {
        int dl = napis.length;

        boolean f = true;
        int nr = 0;
        char first = 0;

        for (int i = dl - 1; i >= 0; i--) {
            if (czySpolgloska(napis[i])) {
                if (f) {
                    nr = i;
                    first = napis[i];
                    f = false;
                } else {
                    char pom = napis[i];
                    napis[i] = first;
                    first = pom;
                }
            }
        }
        if (!f)
            napis[nr] = first;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj napis do zaszyfrowania: ");
        String input = scanner.next();
        char[] napis = input.toCharArray();

        System.out.println("Przed szyfrowaniem: ");
        System.out.println(input);

        kodowanie(napis);

        System.out.println("Szyfrogram: ");
        System.out.println(napis);

        dekodowanie(napis);

        System.out.println("Tekst jawny: ");
        System.out.println(napis);
    }
}
