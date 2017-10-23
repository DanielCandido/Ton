package project.ton.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import project.ton.enums.ProviderSituation;

public  class ProviderSituationSerializeJson extends JsonSerializer<ProviderSituation>
{

    @Override
    public void serialize(ProviderSituation pSituacao, JsonGenerator pJsonGenerator, SerializerProvider pSerializerProvider) throws IOException, JsonProcessingException
    {
        pJsonGenerator.writeString(String.valueOf(pSituacao.getCodigo()));
    }

}
