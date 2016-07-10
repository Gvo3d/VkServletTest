package VKSearcher;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;

public class VKScribe {

    public VKScribe() {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.vk.com").setPath("/method/wall.get")
                .setParameter("domain", GROUP_DOMAIN)
                .setParameter("access_token", ACCESS_TOKEN)
                .setParameter("count", "10");

        HttpResponse response = HttpConnectionAgent.connectResponse(uriBuilder);
        Integer status = response.getStatusLine().getStatusCode();

        if (status == 200) {
            StringWriter content = new StringWriter();

            try {
                IOUtils.copy(response.getEntity().getContent(), content);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }

            JSONParser parser   = new JSONParser();

            try {

                JSONObject jsonResp  = (JSONObject) parser.parse(content.toString());
                JSONArray  postsList = (JSONArray) jsonResp.get("response");
                JSONObject unicPost  = null;

                for (int i=1; i < postsList.size(); i++) {
                    unicPost = (JSONObject) postsList.get(i);
                    System.out.println(unicPost.get("text"));
                }

            } catch (ParseException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}