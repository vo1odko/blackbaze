docker run --name my-postgres \
  -e POSTGRES_PASSWORD=admin \
  -e POSTGRES_USER=postgres \
  -p 5432:5432 \
  -d postgres:15