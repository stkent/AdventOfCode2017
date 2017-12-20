import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class SwarmTest : BehaviorSpec({

  Given("a swarm of two particles constrained to the X-axis") {
    val swarm = Swarm(listOf(
        "p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>",
        "p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>"
    ))

    When("we compute the number of the particle that is eventually closest to the origin") {
      val closest = swarm.eventualClosest()

      Then("the particle number should be 0") {
        closest shouldBe 0
      }
    }
  }

  Given("a swarm of four particles") {
    val swarm = Swarm(listOf(
        "p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>",
        "p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>",
        "p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>",
        "p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>"
    ))

    When("we compute the number of particles that eventually survive") {
      val survivorCount = swarm.survivorCount()

      Then("the number of survivors should be 1") {
        survivorCount shouldBe 1
      }
    }
  }

})
