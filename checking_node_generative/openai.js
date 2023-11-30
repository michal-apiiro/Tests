const { Configuration, OpenAIApi } = require("openai");
const configuration = new Configuration({
  apiKey: "your_api_key",
});
const openai = new OpenAIApi(configuration);
openai
  .createCompletion({
    model: "text-davinci-003",
    prompt: "Say this is a test",
    max_tokens: 7,
    temperature: 0,
  })
  .then((response) => console.log(response.data));

/* Sample Output:
{
  id: 'cmpl-7GOXgfW5pbHTfTs0tWHo74jReaqYI',
  object: 'text_completion',
  created: 1684141944,
  model: 'text-davinci-003',
  choices: [
    {
      text: '\n\nThis is indeed a test',
      index: 0,
      logprobs: null,
      finish_reason: 'length'
    }
  ],
  usage: { prompt_tokens: 5, completion_tokens: 7, total_tokens: 12 }
}
*/