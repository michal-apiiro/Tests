import mangopay from 'mangopay2-nodejs-sdk';

async function main(){
    var api = new mangopay({
        clientId: 'your_client_id',
        clientApiKey: 'your_client_api_key',
        // Set the right production API url. If testing, omit the property since it defaults to sandbox URL
        baseUrl: 'https://api.mangopay.com'
    });

    api.Users.create()
}