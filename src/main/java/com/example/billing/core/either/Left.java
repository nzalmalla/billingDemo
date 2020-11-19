package com.example.billing.core.either;

import java.util.Optional;
import java.util.function.Function;

public class Left<L, R> implements Either<L, R> {
    private L value;

    private Left() {
    }

    public static <L, R> Left<L, R> of(L value) {
        Left<L, R> left = new Left<>();
        left.value = value;
        return left;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public Optional<L> getLeft() {
        return Optional.of(value);
    }

    @Override
    public Optional<R> getRight() {
        return Optional.empty();
    }

    @Override
    public <T> T fold(Function<? super L, ? extends T> mapLeft, Function<? super R, ? extends T> mapRight) {
        return mapLeft.apply(value);
    }
}
