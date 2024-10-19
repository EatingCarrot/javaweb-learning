package servlet.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class GoodDB {
    private static final ConcurrentHashMap<Integer, Good> GOODS_MAP = new ConcurrentHashMap<>();
    static {
        GOODS_MAP.put(1, new Good(1, "apple", 3.0));
        GOODS_MAP.put(2, new Good(2, "banana", 2.5));
        GOODS_MAP.put(3, new Good(3, "orange", 4.5));
        GOODS_MAP.put(4, new Good(4, "pear", 3.5));
    }
    public static List<Good> getGoods() {
        return new ArrayList<>(GOODS_MAP.values());
    }
    public static Good getGood(int id) {
        return GOODS_MAP.get(id);
    }
}
