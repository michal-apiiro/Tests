package paypal_test

import (
	"context"
	"github.com/plutov/paypal/v4"
)

func ExampleClient_CreatePayout_Venmo() {
	// Initialize client
	c, err := paypal.NewClient("clientID", "secretID", paypal.APIBaseSandBox)
	if err != nil {
		panic(err)
	}

	// Retrieve access token
	_, err = c.GetAccessToken(context.Background())
	if err != nil {
		panic(err)
	}

	c.CreatePayout(context.Background(), payout)
}