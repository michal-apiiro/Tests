using MangoPay.SDK;
using MangoPay.SDK.Entities;
using MangoPay.SDK.Core.Enumerations;

class Program
{
    static void Main()
    {
        var api = new MangoPayApi();
        api.Config.ClientId = "YourClientId";
        api.Config.ClientPassword = "YourClientPassword";
        api.Config.BaseUrl = "https://api.sandbox.mangopay.com"; // or production URL

        // Use the API here for various operations
        // For example, creating a user:
        var user = new UserNatural
        {
            FirstName = "John",
            LastName = "Doe",
            Email = "john.doe@example.com",
            Birthday = 636467136000000000, // Representing a birth date, adjust as needed
            Nationality = CountryIso.FR,
            CountryOfResidence = CountryIso.FR
        };

        var createdUser = api.Users.Create(user);
    }
}
