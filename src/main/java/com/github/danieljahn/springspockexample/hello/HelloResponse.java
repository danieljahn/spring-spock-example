package com.github.danieljahn.springspockexample.hello;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class HelloResponse {
    String message;
}
