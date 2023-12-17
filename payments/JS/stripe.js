const express = require('express');
const app = express();
const { resolve } = require('path');
// Copy the .env.example in the root into a .env file in this folder
require('dotenv').config({ path: './.env' });
const stripe = require('stripe');

// Ensure environment variables are set.
checkEnv();


async function main(){
  const price =  stripe.prices.retrieve(process.env.PRICE);
  const session =  stripe.checkout.sessions.retrieve(sessionId);
}


