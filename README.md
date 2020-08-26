# weather-api

A minimal serverless API implementation in Java

Features:

- Lambda + DynamoDB + HttpApi (a cheaper alternative to RestApi)
- Custom implemetation for ApiGateway request/response format to reduce the deployable artifact size (**not** recommended, import [aws-lambda-java-events](https://mvnrepository.com/artifact/com.amazonaws/aws-lambda-java-events) instead)
- reproducible builds, deploy using a ZIP file (no "Uberjar")

Please note:
- The [DynamoDBMapper](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.html) is recommended to simplify data-model binding in real-world applications
- Newer serverless applications may leverage new data-mapping capabilities available in the [AWS SDK for Java v2](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html). For example the new [DynamoDbEnhancedClient](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/examples-dynamodb-enhanced.html)


## Prerequisites

- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) already configured with Administrator permission
- [Maven](https://maven.apache.org/)  
- [SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)


## Usage

Build:

```
❯ mvn package
```

 Deploy:

```
❯ sam deploy --guided
```

Invoke the remote endpoint:

```
❯ url=https://ae34eqcwlk.execute-api.eu-west-1.amazonaws.com/

# Add some data

❯ http $url/events < src/test/resources/oxford.json
❯ http POST $url/events < src/test/resources/brooklin.json

# Query data

❯ http GET $url/locations
```

## Credits

This application is inspired by code examples from the great [Programming AWS Lambda](https://www.oreilly.com/library/view/programming-aws-lambda/9781492041047/) book. 