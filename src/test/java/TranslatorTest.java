import org.junit.Assert;
import org.junit.Test;

public class TranslatorTest {
    private Translator translator = new Translator();

    @Test
    public void translateTest(){
        String [] input = {"123456789",
                "987654321",
                "100",
                "111012"};
        String [] output = {"сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять",
                "девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один",
                "сто",
                "сто одиннадцать тысяч двенадцать"};
        for(int i = 0; i < input.length; i++) {
            Assert.assertEquals(translator.translate(input[i]), output[i]);
        }
    }
}
