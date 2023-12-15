BEGIN TRANSACTION;


INSERT INTO public.items(
	name, price, description, category, image)
	VALUES (
	  'Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops',
	  5.0,
	  'Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday',
	  E'men\'s clothing',
	  'https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg');

INSERT INTO public.items(
	name, price, description, category, image)
	VALUES (
	  'Mens Casual Premium Slim Fit T-Shirts ',
	  8.0,
	  'Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.',
	  E'men\'s clothing',
	  'https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg');


COMMIT TRANSACTION;