# CFMS-backend
springboot backend for CFMS project

{
    "user_id":"1se3",
    "first_name":"Ganesh",
    "last_name":"patnala",
    "phone_number":"9542868633",
    "email":"ganesh@gmail.com",
    "user_name":"syam",
    "password":"ganesh",
    "address":"kakinada",
    "card_type":"gold",
    "bank":"SBI",
    "account_number":"643024589",
    "ifsc_code":"SBIN200145",
    "user_type":"na",
    "is_activated":true,
    "registration_date":"10-02-2022"
}


SchemaUsers: 

* First name
* Last name
* Phone number
* Email
* Username (primary)
* Password
* Address
* Card type (dropdown)
* Bank
* accountNumber
* IFSC code
* Activated / deactivated (by default deactivated)
* userType ( ADMIN / USER )
* // now the history and card related things

Products ( ) // getAllProduct()  ….. getProduct(id)
* ProductId
* Price
* Description
* productName


Cards: (gold and titanium ) // Gold credit ….titanium credit
* id  
* joining fee
* Credit Limit
* Credit days
* Billing cycle
* cardType
* Description

Transactions / history
* Transaction ID (primary key)
* Amount Paid
* Product Id (foreign to product)
* userCard id (foreign to user Card)
* outStanding (bool) => optional 
* isCompleted (boolean) => optional 
* userId (foreign to users)
* Date 

UsersCard
* userId (foreign key to User) // accountNumber 
* cardNumber (primary key)
* cardType (foreign key to Cards) => gold / titanium
* useableCreditLimit (number) => Optional
* isActivated
* IssueDate
* ExpiryDate

