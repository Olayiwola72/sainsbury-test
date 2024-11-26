## Instructions  
You can choose to solve the challenge in one of two ways: using your local environment or the hackajob online IDE.  
  
**Local IDE**  
* Clone the repository into your local machine.
* You are provided with a skeletal Spring Boot application.
* Read the requirements below, add your solution within the project
* To validate your solution against our requirements:
    * Commit your changes to `master` branch and push them to remote
    * Restart the application in hackajob
    * Run test cases using **Run Test** button in the hackajob environment
* You can also run the application locally to debug / test any issues found during the test run in hackajob.
    * Maven Wrapper is included to allow you to build without having to install Maven on your local machine.
    * For example, the application can be built using: `./mvnw clean install` or `mvnw.cmd clean install`

**hackajob IDE**  
* You are provided with a skeletal Spring Boot application in the online IDE.
* Read the requirements below, add your solution within the project.
* To validate your solution against our requirements:
    * Restart the application using the **Build & Restart application** command from the right sidebar.
    * View application logs using the **Show logs** command from the right sidebar.
    * Run test cases using the **Run Tests** button in the hackajob environment.  
  
## Product listing  
You are provided with two public endpoints that deliver JSON data about products available on the Sainsbury Marketplace. You are also given the structure for a Spring Boot application, `uk.co.sainsburys.interview.ProductsApplication`.  
  
**Requirements**  
* Your task is to develop an application that provides a unified JSON response from a single endpoint located at `/products`. The endpoint will combine the data provided by the two external APIs.
* You will need to create a service class file and a new controller `src/main/java/uk/co/sainsburys/interview/controller/ProductController.java`. The controller is using the service class in order to merge the data from both APIs, to apply the necessary filters, and to ensure the results are correct and returned in the correct format. The necessary clients and models for fetching product details and prices from these APIs have already been implemented.
* The response status of the API must be `200`.   
  
**Input & Output**  
The public APIs that are in use: 
* [https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury\_products/products\_v2.json](https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_v2.json) - It provides a list of products available on the Sainsbury Marketplace.
* [https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury\_products/products\_price_v2.json](https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_price_v2.json) - It provides a list of prices for the products available on the Sainsbury Marketplace.
  
The output data your endpoints will return should be in JSON format and be an array of objects. An example is provided below. Each product should have the following fields:  
```GET /products```
```json
[
  ...
  {
    "product_uid": "6447344",
    "product_type": "BASIC",
    "name": "Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g",
    "full_url": "https://www.sainsburys.co.uk/gol-ui/product/sainsburys-responsibly-sourced-scottish-salmon-fillet-x2-240g",
    "unit_price": 15.63,
    "unit_price_measure": "kg",
    "unit_price_measure_amount": 1
  },
  {
    "product_uid": "7947559",
    "product_type": "BASIC",
    "name": "Sainsbury's Houmous 200g",
    "full_url": "https://www.sainsburys.co.uk/gol-ui/product/sainsburys-houmous-200g",
    "unit_price": 0.5,
    "unit_price_measure": "g",
    "unit_price_measure_amount": 100
  },
  ...
]
```
* The mapping of fields from public API endpoint to the `/products` endpoint is as follows:
  * `product_uid` - `product_uid`
  * `product_type` - `product_type`
  * `name` - `name`
  * `full_url` - `url`
  * `unit_price.price` - `unit_price`
  * `unit_price.measure` - `unit_price_measure`
  * `unit_price.measure_amount` - `unit_price_measure_amount`
* Any data from the public API endpoints that does not fit into the `/products` endpoint schema should be ignored.
  
**Additional Requirements**  
* Your endpoint should also support an optional query string parameter `type`, which can have a value of a **single** `product_type`.
* When the `type` parameter is present and a corresponding `product_type` is found, the endpoint should return only the products that match the `product_type` value.
* When the `type` parameter is present and a corresponding `product_type` is not found, the endpoint should return an **empty array**.

**Evaluation Criteria**  
* Accuracy of the code, overall code quality, and quality of unit tests.
* Correctness of the response code returned by the endpoint.
* Validity of the returned JSON, ensuring the data matches expected results.
* Functionality of the query parameter, confirming it filters data as intended.
   
There are 7 test cases that run after the test is submitted. Each test case is worth approximately 14.28 points, leading to a total possible score of 100 points.  
