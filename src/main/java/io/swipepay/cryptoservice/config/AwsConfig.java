package io.swipepay.cryptoservice.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.AWSKMSClientBuilder;

import io.swipepay.cryptoservice.properties.AwsCredentialsProperties;
import io.swipepay.cryptoservice.properties.AwsKmsProperties;

@Configuration
public class AwsConfig {
	
	@Bean
	@ConfigurationProperties("aws.credentials")
	@Validated
	public AwsCredentialsProperties awsCredentialsProperties() {
		return new AwsCredentialsProperties();
	}
	
	@Bean
	@ConfigurationProperties("aws.kms")
	@Validated
	public AwsKmsProperties awsKmsProperties() {
		return new AwsKmsProperties();
	}
	
	@Bean
	public AWSKMSClient awsKmsClient(AWSCredentialsProvider credentialsProvider) {
		AwsKmsProperties awsKmsProperties = awsKmsProperties();
		
		return (AWSKMSClient) AWSKMSClientBuilder
				.standard()
				.withClientConfiguration(new ClientConfiguration())
				.withEndpointConfiguration(new EndpointConfiguration(
						awsKmsProperties.getServiceEndpoint(), 
						awsKmsProperties.getSigningRegion()))
				.withCredentials(credentialsProvider)
				.build();
	}
	
	private AWSStaticCredentialsProvider awsStaticCredentialsProvider() {
		AwsCredentialsProperties awsCredentialsProperties = awsCredentialsProperties();
		
		return new AWSStaticCredentialsProvider(
				new BasicAWSCredentials(
					awsCredentialsProperties.getAccessKey(), 
					awsCredentialsProperties.getSecretKey()));
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("awsCredentialsProperties:" + awsCredentialsProperties());
		System.out.println("awsKmsProperties:" + awsKmsProperties());
		
		awsKmsClient(awsStaticCredentialsProvider());
	}
	
}