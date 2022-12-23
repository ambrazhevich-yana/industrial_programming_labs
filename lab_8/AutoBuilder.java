abstract class Auto implements AutoInterface
 {
     String make;
     int year;
     int power;

     public void setMake(String make) {this.make = make;}
     public void setYear(int year) {this.year = year;}
     public void setPower(int power) {this.power = power;}

     @Override
     public String toString() {
         return "Auto{" +
                 "make='" + make + '\'' +
                 ", year=" + year +
                 ", power=" + power +
                 '}';
     }
 }

public class AutoBuilder
{
    String make ="Defaut";
    int year = 0000;
    int power= 0;

    AutoBuilder buildMake(String make)
    {
        this.make=make;
        return this;
    }
    AutoBuilder buildYear(int year)
    {
        this.year=year;
        return this;
    }
    AutoBuilder buildPower(int power)
    {
        this.power=power;
        return this;
    }
    Auto build()
    {
    Auto auto = new Auto() {
        @Override
        public String NewFunction() {
            return null;
        }
    };
    auto.setMake(make);
    auto.setYear(year);
    auto.setPower(power);
    return auto;
    }
}
