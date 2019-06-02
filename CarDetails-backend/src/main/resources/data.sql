INSERT INTO car_show (car_show_id, show_name) VALUES
  (1, 'Omega Car Show'),
  (2, 'Alpha Car Show'),
(3, 'Beta Car Show');


INSERT INTO car_details(car_details_id, car_make, car_model) VALUES
 (1, 'Audi', 'A4'),
  (2, 'BMW', '320d'),
(3, 'Audi', 'A3');

INSERT INTO car_show_car_details_list(car_show_car_show_id, car_details_list_car_details_id) VALUES
 (1, 1),
  (2, 2),
(3, 3);