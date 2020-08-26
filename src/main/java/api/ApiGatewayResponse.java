package api;

public class ApiGatewayResponse {
    public final int statusCode;
    public final String body;

    public ApiGatewayResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
