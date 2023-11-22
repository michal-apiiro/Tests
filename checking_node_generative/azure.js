import { OpenAIClient } from "@azure/openai";
import { DefaultAzureCredential } from "@azure/identity";

const client = new OpenAIClient("<endpoint>", new DefaultAzureCredential());
const openai = client