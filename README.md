# Candlestick solution

## Server Side

### Usage

```
mvn clean install
mvn spring-boot:run
```

Once the application is packaged (`mvn package`), you can run / distribute the jar file as well, as a normal Java application.

Edit `/src/resources/application.properties` to change the port on which the application will listen. The default port is 3001.

The interesting endpoints are:

- `http://localhost:3001/data` - the data snapshot endpoint
- `http://localhost:3001/v2/api-docs` - the Swagger generated documentation (json)
- `http://localhost:3001/swagger-ui.html` - the Swagger UI for human readable API documentation

### Requirements

#### REQ1

The server shall expose a REST API with a single method, `GET /data` (not `/getData` because that's a REST antipattern).
The method should return a snapshot of the most recent state of data.
The method response shall contain a CORS header accepting any origin.
The method response shall contain a CORS header accepting headers `Origin, X-Requested-With, Content-Type, Accept`.

#### REQ1.1

The `GET /getData` response body should have the following structure:

```yaml
DataPBatch:
    type: "object"
    properties:
      date:
        type: Date
        description: Timestamp of the data point
      data:
        type: "array"
            items:
              $ref: "DataPoint"
DataPoint:
    type: "object"
    properties:
      type:
        type: number
        enum: [1,2,3]
        description:
          Type of data:
            * `1` - Desktop
            * `2` - Mobile
            * `3` - Tablet
      value:
        type: number
        minimum: 1
        maximum: 100
```

#### REQ2

The application shall provide a stub implementation of the data snapshot service, returning 50-100 random data samples with type 1-3 and value 1-100.

#### REQ3

The application shall provide automatic documentation endpoint in `swagger` API format.