package dawidos506.ddrops.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUtil {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
//        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
//        list.sort(Map.Entry.comparingByValue());
//
//        Map<K, V> result = new LinkedHashMap<>();
//        for (Map.Entry<K, V> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }
//
//        return result;
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V> comparingByValue().reversed())
                // Type here -----^ reversed() here -------^
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}
