package cn.huling.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @description 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28888248288841/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "zsxq_access_token=908BB828-5D3B-23A3-0CB5-4AA1205B7BD1_CAD91CFEC08805BA; zsxqsessionid=d520c8269ccfc79ee39f7c7217beccc7; sensorsdata2015jssdkcross={\"distinct_id\":\"1913122a6d5c87-0e52982006be0d-63095450-1328640-1913122a6d6a46\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkxMzEyMmE2ZDVjODctMGU1Mjk4MjAwNmJlMGQtNjMwOTU0NTAtMTMyODY0MC0xOTEzMTIyYTZkNmE0NiJ9\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"1913122a6d5c87-0e52982006be0d-63095450-1328640-1913122a6d6a46\"}; abtest_env=product");
        get.addHeader("Content-Type", "application/json, text/plain, */*");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/1522851258218282/answer");
        post.addHeader("cookie", "zsxq_access_token=908BB828-5D3B-23A3-0CB5-4AA1205B7BD1_CAD91CFEC08805BA; zsxqsessionid=d520c8269ccfc79ee39f7c7217beccc7; sensorsdata2015jssdkcross={\"distinct_id\":\"1913122a6d5c87-0e52982006be0d-63095450-1328640-1913122a6d6a46\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkxMzEyMmE2ZDVjODctMGU1Mjk4MjAwNmJlMGQtNjMwOTU0NTAtMTMyODY0MC0xOTEzMTIyYTZkNmE0NiJ9\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"1913122a6d5c87-0e52982006be0d-63095450-1328640-1913122a6d6a46\"}; abtest_env=product");
        post.addHeader("Content-Type", "application/json, text/plain, */*");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"来自idea的回复：这是一条测试回答！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}

