import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun performMapping() {
        val result = performMapping(
            listOf("CVCD", "SDFD", "DDDF", "SDFD"),
            mapOf(
                "CVCD" to Mapping(
                    version = 1,
                    edition = "X"
                ),
                "SDFD" to Mapping(
                    version = 2,
                    edition = "Z"
                ),
                "DDDF" to Mapping(
                    version = 1
                ),
            )
        )

        assertThat(result, hasSize(3))
        assertThat(
            result, containsInAnyOrder(
                PurchasedItem(
                    version = 1,
                    edition = null,
                    quantity = 1
                ), PurchasedItem(
                    version = 2,
                    edition = "Z",
                    quantity = 2
                ), PurchasedItem(
                    version = 1,
                    edition = "X",
                    quantity = 1
                )
            )
        )
    }

}