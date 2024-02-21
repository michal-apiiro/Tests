use rocket::{get, post, response::status, serde::json::Json};
use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize)]
struct Message {
    id: u32,
    text: String,
}

#[get("/")]
fn index() -> &'static str {
    "Hello, Rocket Web Server!"
}

#[post("/message", format = "json", data = "<message>")]
fn create_message(message: Json<Message>) -> status::Accepted<Json<Message>> {
    println!("Received message: {:?}", message);
    status::Accepted(Some(message))
}

#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![index, create_message])
}
