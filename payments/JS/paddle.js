import { PaddleSDK } from 'paddle-sdk';

async function run() {
	const client = new PaddleSDK(
		'your-vendor-id-here',
		'your-unique-api-key-here'
	);

	const products = await client.getProducts();
	console.log(products);

	const plans = await client.getProductPlans(123);
	console.log(plans);
}

run();