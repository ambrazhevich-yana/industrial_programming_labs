import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        Singleton singleton = new Singleton();

        Auto auto = new AutoBuilder()
                .buildMake("Mercedes Benz")
                .buildPower(5)
                .buildYear(2020)
                .build();
        System.out.println(auto);
        singleton.addAuto(auto);

        Auto auto2 = new AutoBuilder()
                .buildMake("Nissan")
                //.buildPower(42)
                .buildYear(2022)
                .build();
        System.out.print(auto2);
        AdditionalCriteria autoAdditionalCriteria = new AdditionalCriteria((AutoInterface) auto2);
        singleton.addAuto(auto2);
        System.out.println(autoAdditionalCriteria.NewFunction());

    }
}