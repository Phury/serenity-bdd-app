Scenario: advisor details

Given that I am an authenticated advisor $advisorId
When I access uri $advisorDetailUri
Then I retrieve and advisor with $firstname and $lastname
And I retrieve and $address

Examples:
| advisorId | advisorDetailUri 		| firstname 		| lastname 	| address 										|
| 1			| /advisor/$advisorId	| Boba				| Fett		| 550 gerard street east, m4m1x6, toronto, on, canada |