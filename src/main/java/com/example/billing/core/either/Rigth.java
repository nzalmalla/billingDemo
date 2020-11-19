package com.example.billing.core.either;

import java.util.Optional;
import java.util.function.Function;

public class Right<L, R> implements Either<L, R> {
    private R value;

    private Right() {
    }

    public static <L, R> Right<L, R> of(R value) {
        Right<L, R> right = new Right<>();
        right.value = value;
        return right;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public Optional<L> getLeft() {
        return Optional.empty();
    }

    @Override
    public Optional<R> getRight() {
        return Optional.of(value);
    }

    @Override
    public <T> T fold(Function<? super L, ? extends T> mapLeft, Function<? super R, ? extends T> mapRight) {
        return mapRight.apply(value);
    }
}
