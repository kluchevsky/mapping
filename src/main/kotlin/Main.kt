import com.google.gson.Gson

/**
 * Please find unit tests for the method [performMapping]
 * **[MainKtTest]**
 */
fun main(args: Array<String>) {
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
    val gson = Gson()
    print(gson.toJson(result))
}

fun performMapping(products: List<String>, mappings: Map<String, Mapping>): List<PurchasedItem> {
    val quantityMap = products.groupingBy { it }.eachCount()
    return mappings.entries.map { a ->
        PurchasedItem(
            version = a.value.version,
            edition = a.value.edition,
            quantity = quantityMap[a.key]
        )
    }
}

data class Mapping(
    var version: Int? = null,
    var edition: String? = null
)

data class PurchasedItem(
    var version: Int? = null,
    var edition: String? = null,
    var quantity: Int? = null
)