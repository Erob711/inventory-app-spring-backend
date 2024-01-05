BEGIN TRANSACTION;

INSERT INTO public.user_table(
	username, password)
	VALUES ('user1', '123');

INSERT INTO public.user_table(
	username, password)
	VALUES ('user2', '321');


COMMIT TRANSACTION;