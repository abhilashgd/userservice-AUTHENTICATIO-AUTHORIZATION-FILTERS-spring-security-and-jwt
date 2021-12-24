package io.gateways.userservice.utilities;

import com.auth0.jwt.algorithms.Algorithm;

public class AlgorithmHMAC265 {
    public static Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
}
