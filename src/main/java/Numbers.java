import java.io.*;

public class Numbers {

    public Numbers(String file) {
        setWords(file);
    }

    private String zero = "ноль";
    private String [] digits = {"", "один ", "два ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять "};
    private String [] num11 = {"", "одиннадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать "};
    private String [] numPow1 = {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ",
            "семьдесят ", "восемьдесят ", "девяносто "};
    private   String [] numPow2 = {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ",
            "семьсот ", "восемьсот ", "девятьсот "};
    private String [] digitsForThousand = {"", "одна ", "две ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять "};
    private String [][] words = new String[37][3];

    public String getZero() {
        return zero;
    }

    public String[] getDigits() {
        return digits;
    }

    public String[] getNum11() {
        return num11;
    }

    public String[] getNumPow1() {
        return numPow1;
    }

    public String[] getNumPow2() {
        return numPow2;
    }

    public String[] getDigitsForThousand() {
        return digitsForThousand;
    }

    public String[][] getWords() {
        return words;
    }

    public void setWords(String file){
        words[0][0] = "";
        words[0][1] = "";
        words[0][2] = "";
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int numStr = 1;
            while ((strLine = br.readLine()) != null) {
                    words[numStr] = strLine.split(" ");
                    for(int i = 0; i < 3; i++) words[numStr][i] += " ";
                numStr++;
            }
            fstream.close();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

    }
}
