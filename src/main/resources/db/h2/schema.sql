DROP TABLE contact IF EXISTS;

CREATE TABLE contact (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(30),
  phone  VARCHAR(30)
);
