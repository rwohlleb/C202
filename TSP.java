
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author rwohl
 */
public class TSP
{
        int CITI = 29; //Number of Cities
        int[][] adjacency = new int[CITI][CITI];
        
     /**
     *
     * @param fname
     */
    public void populateMatrix(String fname)
    {
        File f = new File(fname);
        try
        {
            Scanner input = new Scanner(f);
            int i, j;
            for( i = 0; i < CITI && input.hasNext(); i++)
            {
                for (j = 0; j < CITI && input.hasNext(); j++)
                {
                    if (i == j)
                    {
                        adjacency[i][j] = 0;
                    }
                    else
                    {
                        int value = input.nextInt();
                        adjacency[i][j] = value;
                        adjacency[j][i] = value;
                    }
                }
            }
            input.close();
        }
        catch(IOException e)
        {
            System.out.println("File reading failed");
        }
    }
    
    public void TravellingSalesPerson()
    {
        Stack pathStack = new Stack();;
        int[] visitedCities = new int[CITI];
        for(int j = 0; j < CITI; j++)
        {
            visitedCities[j] = 0;
        }
        visitedCities[0] = 0;
        pathStack.push(visitedCities[0]);
        int closestCity = 0;
        boolean minFlag = false;
        System.out.println("Start City: " + visitedCities[0]);
        System.out.print("Path: ");
        
        while(!pathStack.isEmpty())
        {
            int currentCity = (int)pathStack.pop();
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < CITI; i++)
            {
                if(adjacency[currentCity][i] > 0 && visitedCities[i] == 0)
                {
                    if(min > adjacency[currentCity][i])
                    {
                        min = adjacency[currentCity][i];
                        minFlag = true;
                        closestCity = i;
                    }
                }
                
                if(minFlag)
                {
                    visitedCities[closestCity] = 1;
                    pathStack.push(closestCity);
                    System.out.print(closestCity+" ");
                    minFlag = false;
                }
            }
            if(!pathStack.empty())
            {
                pathStack.pop();             
            }
        }
    }
    
    public static void main(String[] args)
    {
        TSP tsp = new TSP();
        tsp.populateMatrix(args[0]);
        tsp.TravellingSalesPerson();
    }
}
