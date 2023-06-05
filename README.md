# querydsl-fun
Fun with querydsl



https://www.baeldung.com/intro-to-querydsl
https://www.baeldung.com/querydsl-with-jpa-tutorial



To send a list of string values using the AWS RDS Data API library for Java, you can follow these steps:

1. Import the necessary AWS SDK libraries in your Java file:
```java
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rdsdata.RdsDataClient;
import software.amazon.awssdk.services.rdsdata.model.*;
```

2. Create an instance of the `RdsDataClient` by specifying the AWS region:
```java
Region region = Region.YOUR_REGION; // Replace YOUR_REGION with the desired AWS region
RdsDataClient rdsDataClient = RdsDataClient.builder()
                              .region(region)
                              .build();
```

3. Build the `SqlParameter` object for the list of strings:
```java
List<String> stringList = Arrays.asList("value1", "value2", "value3");
SqlParameter stringListParameter = SqlParameter.builder()
                                        .name("myList")
                                        .value(ParameterValue.builder()
                                                .arrayValue(ArrayValue.builder()
                                                        .addAllStringValues(stringList)
                                                        .build())
                                                .build())
                                        .build();
```

4. Build the `ExecuteStatementRequest` with the SQL statement and parameters:
```java
String sqlStatement = "INSERT INTO myTable (column) VALUES (:myList)";
ExecuteStatementRequest request = ExecuteStatementRequest.builder()
                                    .resourceArn("arn:aws:rds:your-resource-arn") // Replace with your RDS resource ARN
                                    .secretArn("arn:aws:secretsmanager:your-secret-arn") // Replace with your Secret Manager ARN
                                    .database("your-database-name") // Replace with your database name
                                    .sql(sqlStatement)
                                    .parameters(stringListParameter)
                                    .build();
```

5. Execute the statement using the `RdsDataClient`:
```java
rdsDataClient.executeStatement(request);
```

Make sure to replace the placeholder values with your own specific details, such as the AWS region, resource ARN, Secret Manager ARN, database name, and SQL statement.

This example demonstrates sending a list of string values as a parameter in an SQL INSERT statement. Adjust the code according to your specific use case and the operation you want to perform.
