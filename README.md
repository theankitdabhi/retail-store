# Retail API

This Spring Boot application exposes an API that calculates the net payable amount based on the given discounts for a retail store. The API takes a bill as input and applies the applicable discounts to determine the final amount to be paid.

API Endpoint
The API endpoint for calculating the net payable amount is:

```
POST /calculateNetPayableAmount
```

Request Body:
The request body should be a JSON object representing the bill with the following properties:

`amount` (number): The total amount of the bill.\
`isGroceries` (boolean): Indicates whether the bill includes groceries. If true, the percentage-based discounts will not be applied.\
`user` : User details contains the `isCustomerOverTwoYears` which indicates is user customer of retail store more then two years  and `roleEnum` which contains three values EMPLOYEE,AFFILIATE,CUSTOMER to identity the user type.

Example request body:
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

Response Body:
The response body will be a JSON object with the following property:

`netPayableAmount` (number): The final amount to be paid after applying the discounts.\

Example response body:
```
{
  "netPayableAmount": 475
}
```
