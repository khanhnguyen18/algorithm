# Requirement
- We are provided with a plan of an industrial village, represented by an array A consisting of N integers. 
- One tree is able to neutralize one unit of pollution. Our goal is to make every neighborhood sustainable, i.e. for every field, the sum of its value and the values of its neighbors (adjacent fields to the left and right) should be greater than or equal to zero.
-  To achieve this goal, we can plant additional trees in any chosen field (note that we can plant trees in fields containing industrial buildings).
* For example
    - given A = *[1, -3, 2]*,
    - one tree in the field number 0, an industrial building producing 3 units of pollution in field number 1 and two trees in field number 2.
    - The sums of values of the fields and their neighbors are [-2, 0, -1]
    - The neighborhoods of fields 0 and 2 are not sustainable, as their sums are negative.
    - After planting two trees in field 1, we obtain A = [1, -1, 2]. In the new array, the sums are respectively 0, 2, and 1, which makes every neighborhood sustainable.

- Examples:
1. Given A = *[1, -3, 2]*, the function should return 2, as described above.
2. Given A = *[-3, 2, 4, -5, 3]*, the function should return 3.
    - We can plant one tree in field number 0 and two trees in field number 4, achieving [-2, 2, 4, -5, 5].
3. Given A = *[-2, 1, -3, 1]*, the function should return 4.
    - B = [-1, -4, -1, -2]
    - [-2, 3, -1, 1]
    - We can plant two trees each in fields number 1 and 2. After that, we obtain values [-2, 3, -1, 1].

- Note:  N is an integer within the range 1..100.000 :

## 