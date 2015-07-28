Scenario: client details

Given that I am an authenticated advisor with $advisorId
When I access uri $clientDetailsUri
Then I retrieve and client with $firstname and $lastname
And I retrieve and $address

Examples:
| advisorId | clientDetailsUri 		| firstname 		| lastname 		| address 											|
| 1			| /client/$clientId		| Luke				| Skywalker		| 401 king street west, m5v1k1, toronto, on, canada |