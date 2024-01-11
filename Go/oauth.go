package main

import (
    "context"
    "fmt"
    "golang.org/x/oauth2"
)

func main() {
    // Your OAuth2 configuration
    config := &oauth2.Config{
        ClientID:     "your-client-id",
        ClientSecret: "your-client-secret",
        Endpoint: oauth2.Endpoint{
            AuthURL:  "https://example.com/oauth2/auth",
            TokenURL: "https://example.com/oauth2/token",
        },
        RedirectURL: "https://your-app/callback",
        Scopes:      []string{"scope1", "scope2"},
    }

    // Get the URL for OAuth2 authorization
    url := config.AuthCodeURL("state", oauth2.AccessTypeOffline)

    fmt.Printf("Visit the URL for the auth dialog: %v\n", url)
}
