# test IO Java API
## Usage
### Very simple example:
```java
TestIoClientFactory factory = new TestIoClientFactory.Builder()
    .baseUrl("https://api.test.io/customer/v2/")
    .token("abcdefg")
    .build();

BugsClient bugsClient = factory.bugsClient();

Response<BugsResponse> resp = bugsClient.fetchBugs().execute();

List<Bug> bugs = resp.body().getBugs();
```
### Add logging of requests/responses:
```java
TestIoClientFactory factory = new TestIoClientFactory.Builder()
    .baseUrl("https://api.test.io/customer/v2/")
    .token("abcdefg")
    .loggingLevel(Level.BODY)
    .build();

    ...
```

## Advanced Configuration
### Custom HTTP Client
```java
OkHttpClient client = new OkHttpClient.Builder()
    .connectTimeout(Duration.ofSeconds(10))
    .readTimeout(Duration.ofSeconds(10))
    .retryOnConnectionFailure(true)
    .build();
TestIoClientFactory factory = new TestIoClientFactory.Builder()
    .baseUrl("https://api.test.io/customer/v2/")
    .token("abcdefg")
    .client(client)
    .build();

    ...
```
