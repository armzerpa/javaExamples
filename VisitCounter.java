import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VisitCounter {
    Map<Long, Long> count(Map<String, UserStats>... visits) {
        //Map<String, UserStats> v = visits[0];


        Stream<Map<String, UserStats>> stream = Arrays.stream(visits);
        stream.forEach( (v) -> {
                 Set result = v.entrySet().stream().filter((a) -> {
                    try {
                        Long.parseLong(a.getKey());
                        return true;
                    } catch (Exception ex) {
                        return false;
                    }
                }).filter(b -> b.getValue() != null).filter(c -> !c.getValue().visitCount.isEmpty()).collect(Collectors.toSet());
            }
        );


        //List<Integer> integerList= Arrays.asList(integerArray);
        //List<Map<String, UserStats>> visitsWithValidKeys = Arrays.asList(visits).stream().filter(v -> v.getValue() != null).collect(Collectors.toList());



        /*for (Map.Entry<String, UserStats> entry : visits.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/
        /*for (int i = 0; i < visits.length; i++) {
            Long key = 0L;
            System.out.println(visits[i].getKey());
            try {
                key = Long.parseLong(visits[i].key);
            } catch (NumberFormatException nfex) {
                continue;
            }
        }*/
        return null;
    }
}
