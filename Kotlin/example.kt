import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
@RestController
@RequestMapping("/michal1","michal2")
class ApiController {
    // Example of @GetMapping
    @GetMapping("/api/hello")
    fun getUserAgent(@RequestHeader("User-Agent") userAgent: String): String {
        return "User-Agent: $userAgent"
    }
    fun hello(): String {
        return "Hello, World!"
    }
    // Example of @PostMapping
    @PostMapping("/api/create")
    fun create(
        @PathVariable modelName: String,
        @RequestBody body: CreateItemRequest?,
        @RequestHeader("User-Agent") userAgent: String,
        @CurrentUser userDetails: UserDetails,
    ): ResponseEntity<ItemResponse> {
        val model = modelProvider.getByModelName(modelName).orElseThrow {
            badRequest("Model '$modelName' does not exist")
        }
        // Logic to handle the creation of a resource
        return "Resource created with data: $data"
    }
    // Example of @PutMapping
    @PutMapping("/api/update")
    fun update(@RequestParam id: Long, @RequestBody newData: String): String {
        // Logic to handle the update of a resource with the given ID
        return "Resource with ID $id updated with data: $newData"
    }
}