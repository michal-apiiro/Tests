use reqwest;

#[tokio::main]
async fn main() -> Result<(), reqwest::Error> {
    let response = reqwest::get("http://localhost:8000").await?;
    println!("Status: {}", response.status());
    println!("Headers:\n{:#?}", response.headers());

    let body = response.text().await?;
    println!("Body:\n{}", body);

    Ok(())
}
