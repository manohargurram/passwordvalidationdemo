# passwordvalidationdemo
Problem statement 2: Password Validation
We like to build code for purposes of password verification. Verification will fail if any one of the rules mentioned does not pass.
Implement the following rules. Each one of these will throw an exception with a different message of your choice
- password should be larger than 8 chars - met
- password should not be null - met
- password should have one uppercase letter at least - met
- password should have one lowercase letter at least - met
- password should have one number at least - met
1.
e.
2.
3.
4.
Add feature: Password is OK if at least three of the previous conditions is true - met
Add feature: password is never OK if item 1.d is not true. - met
Assume Each verification takes 1 second to complete. How would you solve items 2 and 3 so tests can run faster? 

while testing via junit:

if we run each test case separately or written separate test file for each test case then for every test it should start and stop the container. it reads to perfrmance issue will take so much time to execute all testcases. to solve this problem write all test cases in single file so that it will start and stop container only once for all test cases 
