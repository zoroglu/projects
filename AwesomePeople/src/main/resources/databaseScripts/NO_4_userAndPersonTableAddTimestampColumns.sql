ALTER TABLE usr_user
  ADD updated_timestamp timestamp with time zone;

ALTER TABLE usr_user
  ADD created_timestamp timestamp with time zone;

ALTER TABLE aws_person
  ADD updated_timestamp timestamp with time zone;

ALTER TABLE aws_person
  ADD created_timestamp timestamp with time zone;

ALTER TABLE usr_user ALTER COLUMN created_timestamp SET DEFAULT now();
ALTER TABLE usr_user ALTER COLUMN updated_timestamp SET DEFAULT now();
ALTER TABLE aws_person ALTER COLUMN created_timestamp SET DEFAULT now();
ALTER TABLE aws_person ALTER COLUMN updated_timestamp SET DEFAULT now();