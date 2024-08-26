import pkgs.*;
import pkgs.Search.*;
import pkgs.Sort.*;
import pkgs.Recursion.*;
import pkgs.clean.*;

public class m {
    public static void main(String[] args) {
        //Search.call(SearchType.Binary);
        Sort.call(SortType.Quick);
        //Recursion.call(RecursionType.PathFind);
        clean.main();
    }
}
