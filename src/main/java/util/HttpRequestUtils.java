package util;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpRequestUtils {
    public static Map<String,String> parseQueryString (String queryString){
        return parseValues(queryString,"&");
    }

    public static Map<String,String> parseCookies(String cookies){
        return parseValues(cookies,";");
    }

    public static Pair parseHeader(String header){
        return getKeyValue(header,": ");
    }

    private static Map<String,String> parseValues(String values,String separator){
        if(Strings.isNullOrEmpty(values)){
            return Maps.newHashMap();
        }

        String[] tokens = values.split(separator);
        return Arrays.stream(tokens)
                .map( t->getKeyValue(t,"="))
                .filter(p ->p != null)
                .collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));
    }

    static Pair getKeyValue(String keyValue, String regex){
        if(Strings.isNullOrEmpty(keyValue)){
            return null;
        }

        String[] tokens = keyValue.split(regex);
        if(tokens.length != 2){
            return null;
        }
        return new Pair(tokens[0],tokens[1]);
    }
    @Getter
    public static class Pair{
        String key;
        String value;

        public Pair(String key,String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "Pair [key="+key+"value="+value+"]";
        }
    }
}
