
/**
 * @author Rick Wohlleb
 * CSCI-C202
 * 12/4/16
 * This program performs spell checking on a given document. First, a dictionary
 * is created to hold 26 binary search trees (the first character of each root
 * should correspond to it's position in the alphabet. For example, words beginning
 * with the character "a" should be held at pos [0], while words beginning with 
 * the character "z" should be held at pos. [25]). After the dictionary is created,
 * a document is parsed and each word from the document is compared to the words
 * in the dictionary (if a word is found, it is spelled correctly). Finally, the
 * main() method is called, and the data is displayed.
 */
import java.util.*;
import java.io.*;

public class SpellChecker
{
    private static long found;
    private static long notFound;
    private static long foundComparisons;
    private static long notFoundComparisons;
    private static int size;
    private static Scanner inputStream = new Scanner(System.in);
    private static BinarySearchTree dictionary[] = new BinarySearchTree[26];

//------------------------------------------------------------------------------
    /**
     * pre: none
     * post: fills each binary search tree of the dictionary array
     */
    public static void createDictionary(String fileName)
    {
                    for (int i = 0; i < dictionary.length; i++) 
                    {
                        dictionary[i]= new BinarySearchTree<String>();
                    }
                    
        try 
        {
            File f = new File(fileName);
            Scanner input = new Scanner(f);
            while (input.hasNext())
            {
                String s = input.next();
                String word = s.toLowerCase();
                dictionary[word.charAt(0)-97].insert(word);
            }
            input.close();
        } 
        catch (IOException e)
        {
            System.out.println(e);
        }

    }
//------------------------------------------------------------------------------

    /**
     * runs through a document and compares words from the document to the dictionary
     */
    public static void parser(String fileName) 
    {
        int [] comparisons = new int[1];
        int count = 0;
        try 
        {

            FileInputStream inf = new FileInputStream(new File(fileName));
            char let;
            String str = "";
            int n = 0;
            while ((n = inf.read()) != -1)
            {
                let = (char) n;

                if (Character.isLetter(let))
                {
                    str += Character.toLowerCase(let);
                }
                if ((Character.isWhitespace(let) || let == '-') && !str.isEmpty())
                {
                            if (dictionary[str.charAt(0)-97].search(str, comparisons) == false)
                            {
                                notFound++;
                                notFoundComparisons += comparisons[0];
                            } 
                            else 
                            {
                                found++;
                                foundComparisons += comparisons[0];
                            }
                    size++;
                    comparisons[0] = 0;
                    str = "";
                }

            }
            inf.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Method to display all of the information
     */
    public static void output()
    {
        double avgCompFound = (double) foundComparisons / found;
        double avgCompNotFound = (double) notFoundComparisons / notFound;
        System.out.println("Words found: " + found);
        System.out.println("Words not found: " + notFound);
        System.out.println("Comparisons for words found: " + foundComparisons);
        System.out.println("Comparisons for words not found: " + notFoundComparisons);
        System.out.printf("Average Comparisons per word found: %.2f", avgCompFound);
        System.out.println();
        System.out.printf("Average Comparisons per word not found: %.2f", avgCompNotFound);
        System.out.println();
    }
}

