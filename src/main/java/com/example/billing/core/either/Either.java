package com.example.billing.core.either;

import java.util.Optional;
import java.util.function.Function;

public interface Either<L, R> {
    boolean isLeft();

    boolean isRight();

    Optional<L> getLeft();

    Optional<R> getRight();

    <T> T fold(Function<? super L, ? extends T> mapLeft,
               Function<? super R, ? extends T> mapRight);
}
