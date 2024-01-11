package main

import (
	"context"
	"fmt"
	"github.com/Azure/go-autorest/autorest/adal"
)

func main() {
	// Replace these values with your Azure AD tenant ID, client ID, and client secret
	tenantID := "your-tenant-id"
	clientID := "your-client-id"
	clientSecret := "your-client-secret"
	resource := "https://management.azure.com/"

	// Create a service principal configuration
	config, err := adal.NewServicePrincipalToken(
		adal.OAuthConfig{TenantID: tenantID},
		clientID,
		clientSecret,
		resource)
	if err != nil {
		fmt.Println("Error creating service principal token:", err)
		return
	}

	// Acquire a token
	token, err := config.ServicePrincipalToken()
	if err != nil {
		fmt.Println("Error acquiring token:", err)
		return
	}

	fmt.Println("Access Token:", token.Token().AccessToken)
}
