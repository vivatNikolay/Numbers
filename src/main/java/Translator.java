import org.apache.commons.lang.math.NumberUtils;

public class Translator {

    Numbers numbers = new Numbers("./src/main/resources/input.txt");

    public String translate(String input) {

        if(!checkInput(input)){
            return "Некорректный ввод";
        }

        if("0".equals(input)){
            return numbers.getZero();
        }

        StringBuilder in = new StringBuilder(input);

        String output = "";

        while (in.length() != 0){
            int length = in.length();
            int current = Character.getNumericValue(in.charAt(0));
            int pow = 0;
            if(length > 3){
                pow = length/3;
            }
            switch (length%3){
                case 0:
                    output = calcHundreds(output, current);
                    break;
                case 2:
                    output = calcTens(in, output, current, pow);
                    break;
                case 1:
                    output = calcOnes(output, length, current, pow);
                    break;
                default:
                    return "Некорректный ввод";
            }
            in.deleteCharAt(0);
        }
        return output.substring(0, output.length()-1);
    }

    private String calcHundreds(String output, int current) {
        output += numbers.getNumPow2()[current];
        return output;
    }

    private String calcTens(StringBuilder in, String output, int current, int pow) {
        int next = Character.getNumericValue(in.charAt(1));
        if(1 == current && 0 == next){
            output += numbers.getNumPow1()[current];
            output += numbers.getWords()[pow][2];
        } else if(1 == current){
            output += numbers.getNum11()[next];
            in.deleteCharAt(0);
            output += numbers.getWords()[pow][2];
        } else {
            output += numbers.getNumPow1()[current];
        }
        return output;
    }

    private String calcOnes(String output, int length, int current, int pow) {
        if(current == 0) return output;
        if(length == 3) {
            output += numbers.getDigitsForThousand()[current];
        } else {
            output += numbers.getDigits()[current];
        }
        if(current == 1) output += numbers.getWords()[pow][0];
        else if(current > 1 && current < 5) output += numbers.getWords()[pow][1];
        else output += numbers.getWords()[pow][2];
        return output;
    }

    private boolean checkInput(String input){
        return NumberUtils.isNumber(input);
    }

}
