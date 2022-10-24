INSERT
INTO
  fabricante
  (nome)
VALUES
  ('volkswagen'), ('citroen');

  INSERT
INTO
  carro
  (modelo, fk_fabricante, data_fabricacao, ano_fabricacao, potencia_motor)
VALUES
  ('c3', 2, '2022-08-30', 2022, 80),
  ('c4', 2, '2022-09-03', 2022, 90),
  ('Golf', 1, '2018-06-06', 2018,30),
  ('Atlas', 1, '2012-07-13', 2018, 15);