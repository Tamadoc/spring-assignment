package se.lexicon.teri;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.teri.config.ComponentScanConfig;
import se.lexicon.teri.data_access.StudentDao;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
    }
}
