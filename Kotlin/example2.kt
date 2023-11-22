import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
@RestController
class ApiController {
    // Example of @GetMapping
    @GetMapping("/api/hello")
    fun hello(): String {
        return "Hello, World!"
    }
    // Example of @PostMapping
    @PostMapping("/api/create")
    fun create(@RequestBody data: String): String {
        // Logic to handle the creation of a resource
        return "Resource created with data: $data"
    }
    // Example of @PutMapping
    @PutMapping("/api/update")
    fun update(@RequestParam id: Long, @RequestBody newData: String): String {
        // Logic to handle the update of a resource with the given ID
        return "Resource with ID $id updated with data: $newData"
    }