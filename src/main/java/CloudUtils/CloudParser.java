package CloudUtils;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.List;

public class CloudParser {

    HttpRequestFactory requestFactory;
    String baseURL = "https://todoserver222.herokuapp.com/";
    String todosURL = baseURL + "todos/";
    public CloudParser(){
        requestFactory = new NetHttpTransport().createRequestFactory();



    }
    public List<String> syncToCloud(List<String> list){
        try{
            HttpRequest getRequest = requestFactory.buildGetRequest(new GenericUrl(baseURL));
            String rawToDo = getRequest.execute().parseAsString();
            list.add(rawToDo);
        }
        catch(java.io.IOException e){

        }
        return list;

    }
}
