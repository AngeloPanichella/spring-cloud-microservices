package companytest

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder



class CompanySimulation extends Simulation {

    before {
        println("***** Company simulation start.. *****")
    }

    after {
        println("***** Company simulation finish.. ******")
    }

  val httpConf = http
    .baseURL("http://localhost:8765")

  val scn = scenario("Login") // A scenario is a chain of requests and pauses
    .exec(http("Login")
    .post("/v1/authentication-api/login")
    .body(ElFileBody("data/Login.json"))
    .asJSON
    .check(status.is(200))

    .check(jsonPath("$.access_token").saveAs("access_token")))

    .exec(session => {
      val access_token = session.get("access_token").asOption[String]
      println(access_token.getOrElse("access_token not found"))
      session
    })

    .pause(10)

    .exec(http("Request 1")
    .post("/v1/order-api/oauth/order")
    .body(ElFileBody("data/Request1.json"))
    .asJSON
    .header("Authorization", "Bearer ${access_token}")
    .check(status.is(200))

    .check(jsonPath("$.totalOrder").saveAs("totalOrder"))
    .check(jsonPath("$.totalOrder").is("29.83")))

    .exec(session => {
      val totalOrder = session.get("totalOrder").asOption[String]
      println(totalOrder.getOrElse("totalOrder not found"))
      session
    })

    .pause(10)

    .exec(http("Request 2")
    .post("/v1/order-api/oauth/order")
    .body(ElFileBody("data/Request2.json"))
    .asJSON
    .header("Authorization", "Bearer ${access_token}")
    .check(status.is(200))

    .check(jsonPath("$.totalOrder").saveAs("totalOrder"))
    .check(jsonPath("$.totalOrder").is("65.15")))

    .exec(session => {
      val totalOrder = session.get("totalOrder").asOption[String]
      println(totalOrder.getOrElse("totalOrder not found"))
      session
    })

    .pause(10)

    .exec(http("Request 3")
    .post("/v1/order-api/oauth/order")
    .body(ElFileBody("data/Request3.json"))
    .asJSON
    .header("Authorization", "Bearer ${access_token}")
    .check(status.is(200))

    .check(jsonPath("$.totalOrder").saveAs("totalOrder"))
    .check(jsonPath("$.totalOrder").is("74.68")))

    .exec(session => {
      val totalOrder = session.get("totalOrder").asOption[String]
      println(totalOrder.getOrElse("totalOrder not found"))
      session
    })

  setUp(scn.inject(atOnceUsers(10)).protocols(httpConf))
}
