CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE FUNCTION add_demo(a IN INT, b IN INT, sum OUT INT) AS $$
BEGIN
  sum := a + b;
END;
$$ LANGUAGE plpgsql

