import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
public class main
{
    public static class comp implements Comparator<Double>
    {
        public int compare(Double a, Double b)
        {
            if (a.equals(b)) return 0;
            else if (a > b) return -1;
            else return 1;
        }
    }
    private static Double[][] makeMatrix(int n)
    {
       Double[][] matrix = new Double[n][n];
        for(Double[] i : matrix)
        {
            for(int j = 0; j < i.length; j++)
            {
                i[j] = (Math.random() * 100);
            }
        }
        return matrix;
    }
    private static void printMatrix(Double[][] matrix)
    {
        int moneyRow = 0;
        int numberRow = 1;
        DecimalFormat money = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormat number = (DecimalFormat) DecimalFormat.getPercentInstance();
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(i != moneyRow)
                {
                    System.out.print(matrix[i][j] + " ");
                } else if(i == moneyRow)
                {
                    System.out.print(money.format(matrix[i][j]) + " ");
                } else if(i == numberRow)
                {
                    System.out.print(number.format(matrix[i][j]) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void sortLastRow(Double[][] matrix)
    {
        Arrays.sort( matrix[matrix.length-1], new comp());
    }
    private static void sortMatrix2(Double[][] matrix2)
    {
        for(int i=0; i<matrix2.length; i++)
        Arrays.sort( matrix2[i], new comp());
    }


  private static int BinarySearch(Double[][] matrix)
    {
        double i;
        System.out.println("Enter element: ");
        Scanner input = new Scanner(System.in);
        i = input.nextInt();
        int pos1 = Arrays.binarySearch(matrix[matrix.length - 1],i,new comp());
        System.out.println(pos1);
        return pos1+5;
    }

    private static Double[][] MultipliedMatrix(Double[][] matrix, Double[][] matrix2, int n)
    {
        Double[][] multiplied_matrix = new Double[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                multiplied_matrix[i][j]=matrix[i][j]*matrix2[i][0];
            }
        }
        return multiplied_matrix;
    }

    public static void main(String[] args)
    {
        int n;
        System.out.println("Enter size of matrix");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        if(n < 2) {
            n = 2;
        }
        Double[][] matrix = makeMatrix(n);
        Double[][] matrix2 = makeMatrix(n);
        System.out.print("matrix:");
        System.out.println();
        printMatrix(matrix);
        System.out.print("matrix2:");
        System.out.println();
        printMatrix(matrix2);
        sortLastRow(matrix);
        System.out.print("sort last row matrix1:");
        System.out.println();
        printMatrix(matrix);
        sortMatrix2(matrix2);
        System.out.print("sort matrix2:");
        System.out.println();
        printMatrix(matrix2);
        Double[][] multiplied_matrix = MultipliedMatrix(matrix,matrix2,n);
        System.out.print("multiplied_matrix:");
        System.out.println();
        printMatrix(multiplied_matrix);
        BinarySearch(matrix);

    }
}




































