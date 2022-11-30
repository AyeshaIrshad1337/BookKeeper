import java.io.*;
import java.util.Scanner;
public class ReadCSVExample1
{
    public static void main(String[] args) throws Exception
    {
//parsing a CSV file into Scanner class constructor  
        Scanner sc = new Scanner(new File("D:\\semester 3\\DS_SEC _B_Lab Sec B\\Data Structure\\src\\books.txt"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNextLine())  //returns a boolean value
        {
            System.out.println(sc.nextLine());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}  