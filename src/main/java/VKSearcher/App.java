package VKSearcher;

import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Gvozd on 12.07.2016.
 */
public class App {
    public static void main(String[] args) throws URISyntaxException {
        URIBuilder getkey=  new URIBuilder("https://oauth.vk.com/authorize?" +
                "client_id=5542076&" +
                "scope=pages&" +
                "redirect_uri=https://oauth.vk.com/blank.html&" +
                "display=page&" +
                "v=5.0&" +
                "response_type=token");
        HttpResponse response = HttpConnectionAgent.connectResponse(getkey);
        Integer status = response.getStatusLine().getStatusCode();

        Object obj = null;
        try {
            obj = response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }


        VKScribe vk = new VKScribe(obj);
    }
}
