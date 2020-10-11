import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return correct user by id=1000"

    request {
        url "/users/1000"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: 1000,
                firstName: "John",
                lastName: "Doe",
                email: "john.doe@gmail.com"
        )
    }
}