package main;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiFoo;

@Controller
@RequestMapping("/")
public class SomeClassName {
    private static final Logger LOGGER = Logger.getLogger(SomeClassName.class);

    @ApiOperation(value = "value", notes = "notes", authorizations = {
            @Authorization(value = "value")
    })
    @ApiFoo
    public void foo() {
        // Method implementation
    }
}