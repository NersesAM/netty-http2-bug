package com.example.nettyhttp2bug

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class DefaultController {

  @RequestMapping("/*")
  suspend fun generateResponse(): ResponseEntity<String> {
    return ResponseEntity.status(200)
      .body("OK")
  }
}
