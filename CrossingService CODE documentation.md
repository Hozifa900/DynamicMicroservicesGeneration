
Controller Classes
HealthyController
This controller class is responsible for handling requests related to "healthy" data APIs.
    * Endpoints:
    * GET /healthy: Retrieves a paginated list of "healthy" data APIs.
    * GET /healthy/{id}: Retrieves a specific "healthy" data API by ID.
    * PUT /healthy/{id}/disallow: Marks a data API as unhealthy.
    * POST /healthy: Adds a new "healthy" data API.
UnsureController
This controller class is responsible for handling requests related to "unsure" data APIs.
    * Endpoints:
    * GET /unsure: Retrieves a paginated list of "unsure" data APIs.
    * GET /unsure/{id}: Retrieves a specific "unsure" data API by ID.
    * PUT /unsure/{id}/allow: Marks an "unsure" data API as healthy.
    * POST /unsure: Adds a new "unsure" data API.



Kafka Configuration
public Map<String, Object> getConfig()
This method returns a configuration map for Apache Kafka. It is used to configure Kafka consumers and producers.
* Return Type: Map<String, Object>
* Description: Returns a map containing configuration properties for Kafka, including the bootstrap servers, key and value deserializers, and serializers.
@Bean public KafkaAdmin kafkaAdmin()
This is a Spring Bean method that creates a KafkaAdmin instance.
* Return Type: KafkaAdmin
* Description: KafkaAdmin is a high-level administrative client for managing and inspecting topics in Kafka. It is configured with the same bootstrap servers as the consumer and producer.
@Bean public ConsumerFactory<String, String> StringConsumerFactory()
This Bean method creates a Kafka Consumer Factory for processing messages as strings.
* Return Type: ConsumerFactory<String, String>
* Description: Creates a Kafka Consumer Factory configured with the properties obtained from getConfig().
@Bean public ProducerFactory<String, String> stringProducerFactory()
This Bean method creates a Kafka Producer Factory for producing messages as strings.
* Return Type: ProducerFactory<String, String>
* Description: Creates a Kafka Producer Factory configured with the properties obtained from getConfig().
@Bean public KafkaTemplate<String, String> stringKafkaTemplate()
This Bean method creates a KafkaTemplate for producing and sending messages as strings.
* Return Type: KafkaTemplate<String, String>
* Description: Creates a KafkaTemplate using the stringProducerFactory() to send messages to Kafka topics as strings.
@Bean public ProducerFactory<String, DataApi> apiProducerFactory()
This Bean method creates a Kafka Producer Factory for producing messages of type DataApi.
* Return Type: ProducerFactory<String, DataApi>
* Description: Creates a Kafka Producer Factory configured with the properties obtained from getConfig() for producing messages of type DataApi.
@Bean public KafkaTemplate<String, DataApi> apiKafkaTemplate()
This Bean method creates a KafkaTemplate for producing and sending messages of type DataApi.
* Return Type: KafkaTemplate<String, DataApi>
* Description: Creates a KafkaTemplate using the apiProducerFactory() to send messages to Kafka topics as DataApi objects.