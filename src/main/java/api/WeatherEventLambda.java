package api;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class WeatherEventLambda {

    private final ObjectMapper objectMapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false);

    private final DynamoDB dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder.defaultClient());
    private final String tableName = System.getenv("LOCATIONS_TABLE");

    public ApiGatewayResponse handler(ApiGatewayRequest event) throws IOException {
        final WeatherEvent weatherEvent = objectMapper.readValue(event.body, WeatherEvent.class);

        final Item item = new Item()
                                .withPrimaryKey("locationName", weatherEvent.locationName)
                                .withDouble("temperature", weatherEvent.temperature)
                                .withLong("timestamp", weatherEvent.timestamp)
                                .withDouble("longitude", weatherEvent.longitude)
                                .withDouble("latitude", weatherEvent.latitude);

        final Table table = dynamoDB.getTable(tableName);
        table.putItem(item);

        return new ApiGatewayResponse(200, weatherEvent.locationName);
    }


}
