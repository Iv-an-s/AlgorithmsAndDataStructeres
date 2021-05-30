package homework3;

public class MainForInvert {
    public static void main(String[] args) {
        InvertedText text = new InvertedText("Мама мыла раму. ");
        text.display();
        text.push("Мама мыла раму. ");
        text.push("Раму Первого!");
        text.display();

    }
}
