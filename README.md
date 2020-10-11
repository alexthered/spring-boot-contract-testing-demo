## Small contract testing for Spring boot app with Spring cloud contract

There are two modules:
- Producer: Where the API is implemented and the contract stub is generated
- Consumer: Consume the API and implements test using the generated stub from producer to verify that the contract works.