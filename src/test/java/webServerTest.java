import org.junit.Test;

import java.util.ArrayList;


public class webServerTest {
    @Test
    public void ItemHashMapTest(){
        String[] splitData = "name=e&amount=200".split("&");
        ArrayList<String> dataList = new ArrayList<>();
        for(String value : splitData){
            String subData = value.substring(value.indexOf("=")+1);
            System.out.println(subData);
        }

    }
}
