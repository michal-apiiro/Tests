'use strict'

const Razorpay = require('razorpay')

let razorpay = new Razorpay({
  key_id: process.env.KEY_ID, // your `KEY_ID`
  key_secret: process.env.KEY_SECRET // your `KEY_SECRET`
})

async function main(){
    try {
		const response = await razorpay.orders.create(options);
		res.json({
			status:true,
			id: response.id,
			currency: response.currency,
			amount: response.amount
		})
	} catch (error) {
		return res.status(503).json({status:false , error:error.message});
	}
}