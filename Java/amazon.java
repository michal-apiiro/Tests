import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerAsyncClient;
import software.amazon.awssdk.services.secretsmanager.model.*;

@Slf4j
public class SecretsClient {

    static SecretsManagerAsyncClient createSecretsManagerClient(Region region) {

        return SecretsManagerAsyncClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.builder()
                        .asyncCredentialUpdateEnabled(true)
                        .build())
                .region(region).build();
    }

    public static SecretsManagerAsyncClient getSecretsManagerClient(String region) {
        return createSecretsManagerClient(Region.of(region));
    }
}