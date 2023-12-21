import (
    "context"
    "fmt"
	"github.com/adyen/adyen-go-api-library/v7/src/checkout"
	"github.com/adyen/adyen-go-api-library/v7/src/common"
	"github.com/adyen/adyen-go-api-library/v7/src/adyen"
)

// Create a payment object.

func ExamplePaymentWithIdempotencyKey() {
    client := adyen.NewClient(&common.Config{
    ApiKey:      "YOUR_API_KEY",
    Environment: common.TestEnv,
    Debug:       true,
})

service := client.Checkout()

card := checkout.NewCardDetails()
card.SetEncryptedCardNumber("test_4111111111111111")
card.SetEncryptedExpiryMonth("test_03")
card.SetEncryptedExpiryYear("test_2030")
card.SetEncryptedSecurityCode("test_737")

// Create a payment request.
req := service.PaymentsApi.PaymentsInput().PaymentRequest(checkout.PaymentRequest{
    Amount:          *checkout.NewAmount("EUR", int64(1000)),
    MerchantAccount: "YOUR_MERCHANT_ACCOUNT",
    PaymentMethod:   checkout.CardDetailsAsCheckoutPaymentMethod(card),
    Reference:       "My first Adyen test payment with an API library/SDK",
    ReturnUrl:       "https://your-company.com/...",
})

// Add your idempotency key.
req = req.IdempotencyKey("YOUR_IDEMPOTENCY_KEY")

res, httpRes, err := service.PaymentsApi.Payments(context.Background(), req)

fmt.Println(res, httpRes, err)
}