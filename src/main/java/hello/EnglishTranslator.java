package hello;


public class EnglishTranslator implements Translator {


    @Override
    public String translateToEnglish(String spanishGreeting) {
        return "Hello %s";
    }
}
