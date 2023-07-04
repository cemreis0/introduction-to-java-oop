public class Strings {
    public static void main(String[] args) {
        String text;
        String text2;
        text = "Espresso";
        System.out.println(text.substring(2, 7));
        System.out.println(text.length());
        text2 = "I Love Java";
        System.out.println(text2.indexOf("Love"));
        System.out.println(text2.indexOf("java"));
        System.out.println(text2.indexOf("Java"));
        System.out.println(text+text2);
        ch2StringProcessing();
    }
    public static void ch2StringProcessing() {
        String fullName, firstName, lastName, space;
        fullName = "Decafe Latte";
        space = " ";
        firstName = fullName.substring(0, fullName.indexOf(space));
        lastName = fullName.substring(fullName.indexOf(space)+1);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(fullName);
        System.out.println(fullName.length());
    }
}
