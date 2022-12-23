import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Singleton
{
    private static Singleton instance;
    private ArrayList<Auto> autoArrayList = new ArrayList<Auto>();

    FileWriter output;

    protected Singleton() {}

    public static Singleton Instance()
    {
        if (instance == null)
        {
            instance = new Singleton();
            return instance;
        }
        return null;
    }

    public void addAuto(Auto auto) throws IOException{
        output = new FileWriter("output.txt", true);
        autoArrayList.add(auto);
        output.write(auto.toString() + "\n");
        output.close();
    }

}