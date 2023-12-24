using PayPal.Core;
using PayPal.v1.Payments;

class Program
{
    static void Main()
    {
        var environment = new SandboxEnvironment("Your-Client-Id", "Your-Secret-Key");
        var client = new PayPalHttpClient(environment);

        // Use the client for various PayPal operations
        // For example, creating a payment:
        var payment = new Payment
        {
            Intent = "sale",
            Transactions = new List<Transaction>
            {
                new Transaction
                {
                    Amount = new Amount
                    {
                        Total = "10.00",
                        Currency = "USD"
                    }
                }
            },
            RedirectUrls = new RedirectUrls
            {
                ReturnUrl = "https://example.com/success",
                CancelUrl = "https://example.com/cancel"
            }
        };

        var request = new PaymentCreateRequest();
        request.RequestBody(payment);

        var response = client.Execute(request);

    }
}
