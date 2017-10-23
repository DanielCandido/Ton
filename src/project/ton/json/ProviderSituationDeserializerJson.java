package project.ton.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import project.ton.enums.ProviderSituation;

public class ProviderSituationDeserializerJson extends JsonDeserializer<ProviderSituation>
{
	 @Override
	    public ProviderSituation deserialize(JsonParser pJsonParser, DeserializationContext pDeserializationContext)
	                    throws IOException, JsonProcessingException
	    {
	        String tValor = pJsonParser.getText();
	        return ProviderSituation.fromChar(tValor.charAt(0));
	    }
}
