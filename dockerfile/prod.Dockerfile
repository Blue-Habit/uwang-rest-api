FROM rustlang/rust:nightly-slim AS builder
WORKDIR /workdir
COPY ./Cargo.toml ./Cargo.lock ./
COPY ./migration ./migration
COPY ./src ./src
RUN cargo +nightly build --release

FROM debian:stable-slim
RUN apt update \
    && apt upgrade -y \
    && apt install libssl-dev \
    && apt install -y openssl ca-certificates \
    && apt clean \
    && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
COPY --from=builder /workdir/target/release/uwang-rest-api /usr/local/bin

EXPOSE 7001
ENTRYPOINT ["/usr/local/bin/uwang-rest-api"]