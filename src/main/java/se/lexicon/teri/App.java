package se.lexicon.teri;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.teri.config.ComponentScanConfig;
import se.lexicon.teri.util.UserInputService;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        UserInputService userInputService = context.getBean(UserInputService.class);
    }
}
