FROM eclipse-temurin:11

WORKDIR /app

COPY ./target/universal .

EXPOSE 9000

RUN chmod +x ./backend-1.0-SNAPSHOT/bin/backend

ENTRYPOINT ["./backend-1.0-SNAPSHOT/bin/backend"]

CMD ["-Dplay.http.secret.key=ad31779d4ee49d5ad5162bf1429c32e2e9933f3b"]