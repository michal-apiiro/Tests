
using System.Threading.Tasks;
using Square;
using Square.Models;

namespace square_
{
class Program
{
    static async Task Main()
    {
        // Replace with your actual Square access token
        string accessToken = "YOUR_ACCESS_TOKEN";

        // Replace with your actual location ID
        string locationId = "YOUR_LOCATION_ID";

        // Create a Square client
        var squareClient = new SquareClient.Builder()
            .Environment(ApiClient.Environment.Sandbox)
            .AccessToken(accessToken)
            .Build();

        try
        {
            // Create a payment
            var createPaymentRequest = new Models.CreatePaymentRequest.Builder(
                "ccof:GaJGNaZa8x4OgDJn4GB",
                locationId
            )
            .AmountMoney(
                new Models.Money.Builder()
                .Amount(1000L)  // $10.00 in cents
                .Currency("USD")
                .Build())
            .Autocomplete(false)  // Set to false to capture later
            .CustomerId("W92WH6P11H4Z77CTET0RNTGFW8")
            .ReferenceId("123456")
            .Note("Brief description")
            .Build();

            var paymentsApi = squareClient.PaymentsApi;
            CreatePaymentResponse createResult = await paymentsApi.CreatePaymentAsync(createPaymentRequest);

            Console.WriteLine($"Payment ID: {createResult.Payment?.Id}");
            Console.WriteLine($"Payment Status: {createResult.Payment?.Status}");

            // Complete (capture) the payment
            string paymentId = createResult.Payment?.Id;
            var completePaymentRequest = new Models.CompletePaymentRequest.Builder()
                .Build();

            CompletePaymentResponse completeResult = await paymentsApi.CompletePaymentAsync(paymentId, completePaymentRequest);

            Console.WriteLine($"Completed Payment Status: {completeResult.Payment?.Status}");
        }
        catch (ApiException e)
        {
            // Handle exception here
            Console.WriteLine($"Error: {e.Message}");
        }
    }
}
}