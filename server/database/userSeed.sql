BEGIN TRANSACTION;

INSERT INTO public.user_table(
	username, password)
	VALUES ('chuzbo', '123');

INSERT INTO public.user_table(
	username, password)
	VALUES ('eric2', '123');

INSERT INTO public.user_table(
	username, password)
	VALUES ('lizzy_set', '123');

INSERT INTO public.user_table(
    username, password)
    VALUES ('christ0', '123');

COMMIT TRANSACTION;