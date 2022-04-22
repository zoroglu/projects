--zoroglu --aktif değil
--ALTER TABLE aws_person ADD COLUMN active BOOLEAN DEFAULT FALSE;

ALTER TABLE usr_user ADD COLUMN active BOOLEAN DEFAULT FALSE;


alter table usr_user 
      add column person_id integer, 
      add constraint fk_usr_user_person 
      foreign key (person_id) 
      references aws_person (id);
      
alter table usr_user ADD COLUMN activation_hash text;