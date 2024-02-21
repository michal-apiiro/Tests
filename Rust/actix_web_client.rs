use actix_rt::System;
use actix_web::client::Client;

async fn make_request() -> Result<(), actix_web::Error> {
    let client = Client::new();
    let response = client.get("http://example.com").send().await?;

    println!("Response: {:?}", response);

    Ok(())
}

fn main() {
    let sys = System::new();
    System::block_on(make_request()).unwrap();
}
