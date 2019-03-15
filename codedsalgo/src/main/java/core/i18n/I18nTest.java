package core.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {
    static String language;
    static String country;
    static Locale locale;
    static ResourceBundle resourceBundle;

    public static void main(String[] args) {
        if(args.length>1){
            language=args[0];
            country=args[1];
        }else{
            language=new String("en");
            country=new String("US");
        }
        locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("my_messages", locale);

        System.out.println(resourceBundle.getString("name"));
        System.out.println(resourceBundle.getString("age"));
        System.out.println(resourceBundle.getString("message"));
    }
}
