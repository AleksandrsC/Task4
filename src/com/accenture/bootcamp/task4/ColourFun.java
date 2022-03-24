package com.accenture.bootcamp.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
        *  1.declare and initialize String array with 7arbitrary colors.
        *  2. Create new list "colors" (ArrayList) of type String
        *  3. Copy/add all elements from String array to colors list
        *  4. Remove 3rd element from colors list
        *  5. Add new color at the end of the colors list
        *  6. Add new color at the beginning of the colors list
        *  7. Loop through colors list and output all values (use for each loop)
        *  8. Create new list (colorsSublist) which will be sublist of the colors list (will contain elements from
        *     index 2 to index 5)
        *     (hint: take a look at List interface and find a method which you can use to achieve this)
        *  9. Use for loop to output each element of colorsSublist list
 */
public class ColourFun {
    private static String[] rainbow={"red","orange","yellow","green","blue","indigo","violet"};
    private static ArrayList<String> colours=new ArrayList<>(Arrays.asList(rainbow));//asList returns List , not ArrayList.

    public static void ColourDemo(){
        System.out.printf("colours as initialised %s%n", colours); //BTW, IDEA lets you convert between concatenation,
                                                                   // printf, MessageFormat (the PHP-like {0}
                                                                   //notation) and StringBuffer/StringBuilder automatically
        colours.remove(2);//3rd element
        System.out.printf("Removing the 3rd %s%n", colours);
        colours.add("mauve");
        System.out.printf("Mauve added at the end %s%n", colours);
        colours.add(0,"burgundy");
        System.out.printf("Burgundy added at the start %s%n", colours);
        System.out.println("loop demo");
        System.out.println(colourListToString(colours));
        List<String> coloursSublist=colours.subList(2,5);
        System.out.printf("sublist index 2 to 5 %s%n", coloursSublist);
        System.out.println("second loop demo");
        System.out.println(colourListToString2(coloursSublist));

    }

    /**
     *
     * @param colours colour names to display
     * @return colour names separated by spaces in angle braces.
     */

    private static String colourListToString(List<? extends String> colours) {
        StringBuilder rv=new StringBuilder("<");
        for(String colour:colours){
            rv.append(colour);
            rv.append(" ");
        }
        rv.append(">");
        return rv.toString();
    }

    /**
     *
     * @param colours colour names to display
     * @return colour names separated by commas
     */

    private static String colourListToString2(List<? extends String> colours) {
        StringBuilder rv=new StringBuilder();
        for(int i=0;i<colours.size()-1;i++){
            rv.append(colours.get(i));
            rv.append(", ");
        }
        rv.append(colours.get(colours.size()-1));
        return rv.toString();
    }
}
