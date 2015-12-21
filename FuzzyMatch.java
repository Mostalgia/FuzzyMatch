//Find set of substrings within a string, where the substring's characters
//are in the same order as in the string. E.g. "lln" "love lain" returns true,
//whereas "lainl" "love lain" returns false.
public class FuzzyMatch
{

    public boolean fuzzy_match(String fragment, String str)
    {
        //Case sensitive btw
        String newString = "";
        int range = str.length();

        int i = 0; //Represents largest char index in newString.
        int x = 0; // Represents fragment's charAt value.
        while(i < range)
        {
            //If fragment's/str's charAt value is greater than its 
            //length, break.
            if(fragment.length() == x || (i == str.length()))
            {
                break;
            }
            if(fragment.charAt(x) == str.charAt(i))
            {
                x++;
                newString += str.charAt(i);
                str = str.substring(0, i) + str.substring(i+1);
            }
            else
            {
                i++;
            }
        }
        return (fragment.equals(newString));
    }

    public static void main(String[] args)
    {
        FuzzyMatch x = new FuzzyMatch();
        if (args.length != 2 || (args[0].length() > args[1].length()))
        {
            System.err.println("Usage: java FuzzyMatch <Substring> <String>, where <Substring> <= <String>");
            System.exit(-1);
        }
        System.out.println(x.fuzzy_match(args[0], args[1]));
    }
}
