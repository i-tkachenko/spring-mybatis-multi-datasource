CREATE TABLE IF NOT EXISTS payments_archive
(
    id          bigint    not null,
    amount      bigint    not null,
    date        timestamp not null
);

INSERT INTO payments_archive (id, amount, date)
VALUES (1, 10000, '2022-01-15 10:15:00');

INSERT INTO payments_archive (id, amount, date)
VALUES (2, 25000, '2022-02-20 14:30:00');

INSERT INTO payments_archive (id, amount, date)
VALUES (3, 5000, '2022-03-10 09:00:00');

INSERT INTO payments_archive (id, amount, date)
VALUES (4, 15000, '2022-04-05 16:45:00');

INSERT INTO payments_archive (id, amount, date)
VALUES (5, 30000, '2022-05-18 11:20:00');