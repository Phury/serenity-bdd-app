Scenario: login

Given that I am an advisor with $username and $password
When I access uri $loginUri
Then I get a valid authentication token

Examples:
| username 	| password 		| loginUri 				|
| bfett		| useTheForce 	| /authentication/login	|