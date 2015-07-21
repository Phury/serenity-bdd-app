Scenario: compute total cost of items
Given that I add $fruit with $fruitPrice
And that I add a $vegetable with $vegetablePrice
When I sell $goods
Then the total cost should be $total
Examples:
| fruit    | fruitPrice | vegetable | vegetablePrice | goods 		  | total |
| apple    | 5.00       | carrot    | 6.50           | apple, carrot  | 11.50 |
| apple    | 5.00       | pear      | 6.00           | apple, pear    | 11.00 |
| potato   | 4.00       | carrot    | 6.50           | potato, carrot | 10.50