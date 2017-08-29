package algo3;



import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.io.IOException;
import java.util.Map;

/**
 * Created by paramin on 8/17/17.
 */
public class alexa {

    public static void main(String[] args) {

        ObjectMapper ob = new ObjectMapper();
        ob.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        String json = "{name: \"Bob\", state: \"Colorado\", Friends: [{ name: \"Dan\", age: 23 }, {name: \"Zane\", age: 24 }]}";
        String json = "{directive={payload={entities=[{type=Genre, uri=entity://provider/genre/1, value=Action, externalIds={ENTITY_ID=0, gracenote=1}}, {type=Genre, uri=entity://provider/genre/1, value=Action, externalIds={ENTITY_ID=1, gracenote=1}}, {type=Genre, uri=entity://provider/genre/105, value=Action sports, externalIds={ENTITY_ID=2, gracenote=105}}, {type=Genre, uri=entity://provider/genre/1, value=Action, externalIds={ENTITY_ID=3, gracenote=1}}, {type=MediaType, value=Movie}]}, header={payloadVersion=3, messageId=ea90b8cc-2fc0-4293-9e6a-767ac01f2773, namespace=Alexa.RemoteVideoPlayer, name=SearchAndDisplayResults}, endpoint={cookie={}, scope={token=Atza|IwEBIFViG-OtC1jC4IQ6i_5KvyDUA1BXH2eiZylE3w2wo6-gPVDmHIYytPwFGYWhi3ka1YUR5WqZKINQJK86kbVHilazQy_pRE8x4UPcZsBtbPr0Np7jkGoUp2Z93FeY0Z4r5SAZtKfQM2kYKZcK-5kz6OboXjfhMMazs4iiRdv7b8b6gMh9cS6sFVHcx0f97xEkcwjwl9CTKyHQt0aXJXrwGhvOf8HohmyfEyfb_1JBSYH1LMakL4dsNxiUGrjwmdfYTFHdGvsnuK93k81hAFVd28LlT9MSJs-jxafCINQakUptD5UZDgAGAAuZBsDuBlOVi7gvUj0CuIxciJ66XuErZYGWmaXGSSRO2KCFUAF_d41FdfNImNEBibw7V1fGYpAIAErbFZaKw3DBppEfMn-Dtbm8j3bVIKl7LbYzfUg1J-2p2fmTFDvfu2R5boteqcLTtILJhRLvAMagK4ahdwUqJTxWaW3wHxN5BAbsT2zrZX-5BIU-9SOfnLf-M6QfDtH3-C4, type=BearerToken}, endpointId=DummyDevice-001}}}";
        //String modJson = json.replace('=',':');
        System.out.println(json);
        Map<String, ObjectNode> theMap = null;
        try {
            theMap = ob.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(theMap.get("directive"));
    }
}
