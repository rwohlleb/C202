     //Rick Wohlleb Part 2 Final

import java.util.*;
import java.io.*;

public class Part2
{
    public static void main(String[] args)
    {
        try
        {
            File f = new File(args[0]);
            Scanner input = new Scanner(f);
            while(input.hasNextLine())
            {
                String list = input.nextLine();
                if(reverse(list).equals(list))
                    System.out.println(list + " is a palindrome.");
                else
                    System.out.println(list + " is not a palindrome, reversed " + list + " is " + reverse(list));
            }
            input.close();
        }
            catch(IOException e)
            {
                System.out.println("You suck");
            }
    }
    
    public static String reverse(String s)
    {
        if(s.length() <= 1)
        {
            return s;
        }
        
        
        
        else
        {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

}
/*racecar is a palindrome.
forward is not a palindrome, reversed forward is drawrof
kinikinik is a palindrome.
malayalam is a palindrome.
physics is not a palindrome, reversed physics is scisyhp
devoved is a palindrome.
remarkable is not a palindrome, reversed remarkable is elbakramer
sagas is a palindrome.
solos is a palindrome.
recount is not a palindrome, reversed recount is tnuocer
spacecaps is a palindrome.
murdrum is a palindrome.
toilet is not a palindrome, reversed toilet is teliot
cancel is not a palindrome, reversed cancel is lecnac
assign is not a palindrome, reversed assign is ngissa
lithium is not a palindrome, reversed lithium is muihtil
evitative is a palindrome.
kayak is a palindrome.
noon is a palindrome.
basics is not a palindrome, reversed basics is scisab
backwards is not a palindrome, reversed backwards is sdrawkcab
*/