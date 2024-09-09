package TollCore;
import java.util.HashMap;
import java.util.Map;

public class Header {
    public static Map<String, Object> setHeader(){
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Accept", "application/json");
        return headerMap;
    }
}
