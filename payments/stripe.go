package main

import (
	"fmt"
	"log"

	"github.com/stripe/stripe-go"
	"github.com/stripe/stripe-go/charge"
)

func main() {
	// Set Stripe API key
	stripe.Key = "YOUR_API_KEY"

	// Create a new charge
	params := &stripe.ChargeParams{
		Amount:   stripe.Int64(2000),
		Currency: stripe.String(string(stripe.CurrencyUSD)),
		Desc:     stripe.String("Test Charge"),
	}
	params.SetSource("tok_visa") // use a test card token provided by Stripe
	ch, err := charge.New(params)

	// Check for errors
	if err != nil {
		log.Fatal(err)
	}

	// Print charge details
	fmt.Printf("Charge ID: %s\n", ch.ID)
	fmt.Printf("Amount: %d\n", ch.Amount)
	fmt.Printf("Description: %s\n", ch.Description)
}