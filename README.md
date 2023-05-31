# Retail API

This Spring Boot application exposes an API that calculates the net payable amount based on the given discounts for a retail store. The API takes a bill as input and applies the applicable discounts to determine the final amount to be paid.

**API Endpoint:**
The Swagger documentation for this API is available at [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html). You can use this interface to interactively explore and test the API endpoints.

The API endpoint for calculating the net payable amount is:

```
POST /calculateNetPayableAmount
```

**Request Body:**
The request body should be a JSON object representing the bill with the following properties:

`amount` (number): The total amount of the bill.\
`isGroceries` (boolean): Indicates whether the bill includes groceries. If true, the percentage-based discounts will not be applied.\
`user` : User details contains the `isCustomerOverTwoYears` which indicates is user customer of retail store more then two years  and `roleEnum` which contains three values EMPLOYEE,AFFILIATE,CUSTOMER to identity the user type.

**Example request body:**
```
{
  "amount": 500.0,
  "isGroceries": true,
  "user": {
    "isCustomerOverTwoYears": true,
    "roleEnum": "EMPLOYEE"
  }
}
```

**Response Body:**
The response body will be a JSON object with the following property:

`netPayableAmount` (number): The final amount to be paid after applying the discounts.

**Example response body:**
```
{
  "netPayableAmount": 475
}
```
**Discount Calculation:**
The API applies the following discounts in the order specified:

 1. If the user is an employee of the store, they get a 30% discount.
 2. If the user is an affiliate of the store, they get a 10% discount.
 3. If the user has been a customer for over 2 years, they get a 5% discount.
 4. For every $100 on the bill, there is a $5 discount.

The percentage-based discounts do not apply to groceries, and a user can receive only one of the percentage-based discounts on a bill.

Building and Running the Application

To build and run the application, follow these steps:

**Clone the repository:**
```
git clone <repository-url>
```

**Navigate to the project directory:**
```
cd retail-api
```

**Build the application:**
```
./mvnw clean package
```

**Run the application:**
```
./mvnw spring-boot:run
```

The application will start running on http://localhost:9090.

**Testing:**
Unit tests have been provided for the DiscountServiceImpl class to ensure the correct calculation of the net payable amount. To run the tests, use the following command:

```
./mvnw test
```
**Generate the report:**

From the main menu, select Run | Generate Coverage Report, or click the Generate Coverage Report button in the Coverage tool window.

Note that this option becomes available only after you run the necessary tests with coverage.

In the Generate Coverage Report dialog, specify the directory in which the generated report should be stored, and optionally select the Open generated HTML in browser checkbox.

If there are several projects opened in the same window, make sure that the suggested output directory is correct.

Click Save.
![image](https://github.com/ankit-7span/retail-store/assets/115085627/e0d89646-e0c0-4269-8dfe-3ff31589c1b0)

**UML Diagram:**
![uml_retail_shop drawio](https://github.com/theankitdabhi/retail-store/assets/53808622/51403c22-7ed9-499e-b347-84f049e6b5d2)

Feel free to customize the API request body as per your specific requirements.
