import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.WebIdentityTokenCredentialsProvider;

public class amazon1{
public final AWSCredentialsProvider getAwsCredentialsProvider() {
        return WebIdentityTokenCredentialsProvider.builder().roleSessionName("ms-file-storage").build();
    }
AWSCredentials getAWSCredentials() {
        AWSCredentials credentials;
        try {
            credentials =  new DefaultAWSCredentialsProviderChain().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials using the DefaultAWSCredentialsProviderChain.", e);
        }
        return credentials;
    }

}