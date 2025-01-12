package exercise;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App{

    public static List<String> buildApartmentsList(List<Home> apart,int n){

        List<String> result = apart.stream()
                .sorted()
                .limit(n)
                .map(Home::toString)
                .collect(Collectors.toList());

        return result;
    }
}
// END
