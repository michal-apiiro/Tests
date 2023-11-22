import { ModelServiceClient } from '@google-cloud/aiplatform';
import { v1 } from '@google-cloud/aiplatform';
const {PipelineServiceClient} = v1;

async function main(){
    const clientOptions = {
    apiEndpoint: 'us-central1-aiplatform.googleapis.com',
    };

    const modelServiceClient = new ModelServiceClient(clientOptions);
    const pipelineClient = new PipelineServiceClient(clientOptions);
}