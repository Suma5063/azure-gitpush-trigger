package com.function;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class GitPushHttpTrigger {

    @FunctionName("GitPushHttpTrigger")
    public HttpResponseMessage run(
        @HttpTrigger(name = "req", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS)
        HttpRequestMessage<String> request,
        final ExecutionContext context
    ) {
        context.getLogger().info("Received push from Git!");
        return request.createResponseBuilder(HttpStatus.OK)
                      .body("Push received successfully")
                      .build();
    }
}

