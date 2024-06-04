CREATE TABLE IF NOT EXISTS payments
(
    id          bigint    not null,
    amount      bigint    not null,
    date        timestamp not null
);

INSERT INTO payments (id, amount, date)
VALUES (6, 100, '2024-01-15 10:15:00');

INSERT INTO payments (id, amount, date)
VALUES (7, 200, '2024-02-20 14:30:00');

INSERT INTO payments (id, amount, date)
VALUES (8, 50, '2024-03-10 09:00:00');